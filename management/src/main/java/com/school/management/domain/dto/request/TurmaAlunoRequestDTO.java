package com.school.management.domain.dto.request;

import com.school.management.domain.model.Aluno;
import com.school.management.domain.model.Turma;

import java.net.HttpURLConnection;

public record TurmaAlunoRequestDTO(
        Aluno aluno,
        Turma turma
) {
}
