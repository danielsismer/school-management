package com.school.management.mapper;

import com.school.management.domain.dto.request.TurmaAlunoRequestDTO;
import com.school.management.domain.dto.response.TurmaAlunoResponseDTO;
import com.school.management.domain.model.TurmaAluno;
import org.springframework.stereotype.Component;

@Component
public class TurmaAlunoMapper {

    public TurmaAluno toEntity(TurmaAlunoRequestDTO turmaAlunoRequestDTO){
        return new TurmaAluno(
                turmaAlunoRequestDTO.aluno(),
                turmaAlunoRequestDTO.turma()
        );
    }

    public TurmaAlunoResponseDTO toResponse(TurmaAluno turmaAluno){
        return new TurmaAlunoResponseDTO(
                turmaAluno.getAluno(),
                turmaAluno.getTurma()
        );
    }

}
