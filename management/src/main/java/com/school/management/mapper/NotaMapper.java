package com.school.management.mapper;

import com.school.management.domain.dto.request.NotaRequestDTO;
import com.school.management.domain.dto.response.NotaResponseDTO;
import com.school.management.domain.model.Nota;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Component;

@Component
public class NotaMapper {

    public Nota toEntity(NotaRequestDTO notaRequestDTO){

        return new Nota(
                notaRequestDTO.aluno_id(),
                notaRequestDTO.aula_id(),
                notaRequestDTO.valor()
        );

    }

    public NotaResponseDTO toResponse(Nota nota){

        return new NotaResponseDTO(
                nota.getId(),
                nota.getAluno_id().getNome(),
                nota.getAula_id().getAssunto(),
                nota.getValor()
        );

    }
}
