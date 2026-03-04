package com.school.management.repository;

import com.school.management.domain.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    @Query("SELECT al.nome FROM nota n JOIN aluno al ON al.id = n.aluno_id WHERE n.aluno_id = :alunoId")
    String findNomeAlunoById(@Param("alunoId") Long id);

    @Query("SELECT au.assunto FROM nota n JOIN aula au ON au.id = n.aula_id WHERE n.aula_id = :aulaId")
    String findAssuntoByAulaId(@Param("aulaId") Long id);

}
