package com.school.management.repository;

import com.school.management.domain.model.Curso;
import com.school.management.domain.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT DISTINCT t.professor FROM Turma t WHERE t.curso.id = :cursoId")
    List<String> findProfessoresByCursoId(@Param("cursoId") Long cursoId);}
