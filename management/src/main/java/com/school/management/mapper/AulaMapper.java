package com.school.management.mapper;

import com.school.management.domain.dto.request.AulaRequestDTO;
import com.school.management.domain.dto.response.AulaResponseDTO;
import com.school.management.domain.model.Aula;
import com.school.management.domain.model.Turma;
import org.springframework.stereotype.Component;

@Component
public class AulaMapper {

    public Aula toEntity(AulaRequestDTO aulaRequestDTO) {

        return new Aula(
                aulaRequestDTO.turma_id(),
                aulaRequestDTO.data_hora(),
                aulaRequestDTO.assunto()
        );
    }

    public AulaResponseDTO toResponse(Aula aula) {


        return new AulaResponseDTO(
                aula.getId(),
                aula.getTurma_id().getNome(),
                aula.getData_hora(),
                aula.getAssunto()
        );
    }
}
