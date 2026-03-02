package com.school.management.repository;

import com.school.management.domain.model.Turma;
import com.school.management.domain.model.TurmaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaAlunoRepository extends JpaRepository<TurmaAluno, Long> {
}
