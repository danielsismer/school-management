package com.school.management.domain.dto.request;

import com.school.management.domain.model.Curso;
import com.school.management.domain.model.Professor;

import java.util.List;

public record TurmaRequestDTO(
        String nome,
        Curso curso,
        Professor professor,
        List<Long> alunos
) {
}
