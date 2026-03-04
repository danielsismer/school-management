package com.school.management.repository;

import com.school.management.domain.model.Aula;
import com.school.management.domain.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AulaRepository extends JpaRepository<Aula, Long> {

    @Query("SELECT a.turma_id FROM aula a WHERE a.id = :aula_id")
    String findTurmaByAula(@Param("aula_id") Long id);

}
