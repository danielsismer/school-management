package com.school.management.domain.dto.response;

import com.school.management.domain.model.Curso;
import com.school.management.domain.model.Professor;

import java.util.List;

public record TurmaResponseDTO (
        Long id,
        String nome,
        Curso curso,
        Professor professor,
        List<String> alunos
){
}