package com.school.management.domain.dto.response;

import java.util.List;

public record CursoResponseDTO(
        Long id,
        String nome,
        String codigo,
        List<String> professores
) {
}
