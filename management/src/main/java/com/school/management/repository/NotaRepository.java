package com.school.management.repository;

import com.school.management.domain.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface NotaRepository extends JpaRepository<Nota, Long> {

    @Query("SELECT n.aluno_id.nome FROM Nota n WHERE n.aluno_id.id = :alunoId")
    String findNomeAlunoById(@Param("alunoId") Long alunoId);

    @Query("SELECT n.aula_id.assunto FROM Nota n WHERE n.aula_id.id = :aulaId")
    String findAssuntoByAulaId(@Param("aulaId") Long aulaId);
}