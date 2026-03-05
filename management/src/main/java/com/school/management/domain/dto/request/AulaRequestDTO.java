package com.school.management.domain.dto.request;

import com.school.management.domain.model.Turma;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AulaRequestDTO(
        Turma turma_id,
        LocalDateTime data_hora,
        String assunto
) {
}
