package com.school.management.mapper;

import com.school.management.domain.dto.request.TurmaRequestDTO;
import com.school.management.domain.dto.response.TurmaResponseDTO;
import com.school.management.domain.model.Aluno;
import com.school.management.domain.model.Turma;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TurmaMapper {

    public Turma toEntity(TurmaRequestDTO turmaRequestDTO){
        return new Turma(
                turmaRequestDTO.nome(),
                turmaRequestDTO.curso(),
                turmaRequestDTO.professor()
        );
    }

    public TurmaResponseDTO toResponse(Turma turma, List<Aluno> alunos){

        if (turma == null) return null;

        List<String> nomeAlunos = alunos
                .stream()
                .map(Aluno::getNome)
                .toList();

        return new TurmaResponseDTO(
                turma.getId(),
                turma.getNome(),
                turma.getCurso(),
                turma.getProfessor(),
                nomeAlunos
        );
    }
}
