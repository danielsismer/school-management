package com.school.management.mapper;

import com.school.management.domain.dto.request.TurmaRequestDTO;
import com.school.management.domain.dto.response.TurmaResponseDTO;
import com.school.management.domain.model.Turma;
import org.springframework.stereotype.Component;

@Component
public class TurmaMapper {

    public Turma toEntity(TurmaRequestDTO turmaRequestDTO){
        return new Turma(
                turmaRequestDTO.nome(),
                turmaRequestDTO.curso(),
                turmaRequestDTO.professor()
        );
    }

    public TurmaResponseDTO toResponse(Turma turma){
        return new TurmaResponseDTO(
                turma.getId(),
                turma.getNome(),
                turma.getCurso(),
                turma.getProfessor()
        );
    }
}
