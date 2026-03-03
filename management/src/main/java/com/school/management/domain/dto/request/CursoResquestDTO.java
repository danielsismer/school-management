package com.school.management.domain.dto.request;

import java.util.List;

public record CursoResquestDTO(
        String nome,
        String codigo,
        List<Long> professoresIds
) {
}
