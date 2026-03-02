package com.school.management.domain.dto.response;

import com.school.management.domain.model.Curso;
import com.school.management.domain.model.Professor;

public record TurmaResponseDTO (
        Long id,
        String nome,
        Curso curso,
        Professor professor
){
}