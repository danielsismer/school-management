package com.school.management.repository;

import com.school.management.domain.model.Aluno;
import com.school.management.domain.model.Professor;
import com.school.management.domain.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

    @Query("SELECT DISTINCT t.professor FROM Turma t WHERE t.curso.id = :cursoId")
    List<Aluno> findProfessoresByCursoId(@Param("cursoId") Long cursoId);

}
