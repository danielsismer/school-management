package com.school.management.mapper;

import com.school.management.domain.dto.request.ProfessorRequestDTO;
import com.school.management.domain.dto.response.ProfessorResponseDTO;
import com.school.management.domain.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public Professor toEntity(ProfessorRequestDTO professorRequestDTO){
        return new Professor(
                professorRequestDTO.nome(),
                professorRequestDTO.email(),
                professorRequestDTO.disciplina()
        );
    }

    public ProfessorResponseDTO toResponse(Professor professor){
        return new ProfessorResponseDTO(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getDisciplina()
        );
    }

}
