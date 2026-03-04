package com.school.management.domain.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AulaRequestDTO(
        Long turma_id,
        LocalDateTime data_hora,
        String assunto
) {
}
