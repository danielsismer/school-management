package com.school.management.mapper;

import com.school.management.domain.dto.request.CursoResquestDTO;
import com.school.management.domain.dto.response.CursoResponseDTO;
import com.school.management.domain.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public Curso toEntity(CursoResquestDTO cursoResquestDTO){
        return new Curso(
                cursoResquestDTO.nome(),
                cursoResquestDTO.nome()
        );
    }

    public CursoResponseDTO toResponse(Curso curso){
        return new CursoResponseDTO(
                curso.getId(),
                curso.getNome(),
                curso.getCodigo()
        );
    }
}
