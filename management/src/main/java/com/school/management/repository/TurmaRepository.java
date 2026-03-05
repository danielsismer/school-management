package com.school.management.repository;

import com.school.management.domain.model.Aluno;
import com.school.management.domain.model.Professor;
import com.school.management.domain.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Long> {


    @Query(value = """
            SELECT a.* FROM aluno a
            JOIN turma_aluno ta ON ta.aluno_id = a.id
            WHERE ta.turma_id = :turmaId
            """,
            nativeQuery = true)
    List<Aluno> findAlunosByTurmaId(@Param("turmaId") Long turmaId);
}



