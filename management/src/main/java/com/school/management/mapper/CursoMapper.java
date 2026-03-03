package com.school.management.mapper;

import com.school.management.domain.dto.request.CursoResquestDTO;
import com.school.management.domain.dto.response.CursoResponseDTO;
import com.school.management.domain.model.Curso;
import com.school.management.domain.model.Professor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CursoMapper {

    public CursoResponseDTO toResponse(Curso curso, List<Professor> professores) {

        if (curso == null) return null;

        List<String> nomesProfessores = professores.stream()
                .map(Professor::getNome)
                .toList();

        return new CursoResponseDTO(
                curso.getId(),
                curso.getNome(),
                curso.getCodigo(),
                nomesProfessores
        );
    }

    public Curso toEntity(CursoResquestDTO dto) {

        if (dto == null) return null;

        Curso curso = new Curso();
        curso.setNome(dto.nome());
        curso.setCodigo(dto.codigo());

        return curso;
    }
}
