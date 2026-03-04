package com.school.management.domain.dto.response;

import com.school.management.domain.model.Turma;

import java.time.LocalDateTime;

public record AulaResponseDTO(
        Long id,
        String nome_turma,
        LocalDateTime data_hora,
        String assunto
) {
}
