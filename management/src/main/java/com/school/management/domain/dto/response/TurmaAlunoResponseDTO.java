package com.school.management.domain.dto.response;

import com.school.management.domain.model.Aluno;
import com.school.management.domain.model.Turma;

public record TurmaAlunoResponseDTO(
        Aluno aluno,
        Turma turma
) {
}