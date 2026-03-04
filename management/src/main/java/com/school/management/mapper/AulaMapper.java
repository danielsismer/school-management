package com.school.management.mapper;

import com.school.management.domain.dto.request.AulaRequestDTO;
import com.school.management.domain.dto.response.AulaResponseDTO;
import com.school.management.domain.model.Aula;
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

    public AulaResponseDTO toResponse(Aula aula, String nome_turma) {

        return new AulaResponseDTO(
                aula.getId(),
                nome_turma,
                aula.getData_hora(),
                aula.getAssunto()
        );
    }
}
