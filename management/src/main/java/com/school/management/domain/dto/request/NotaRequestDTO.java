package com.school.management.domain.dto.request;

public record NotaRequestDTO (
        Long aluno_id,
        Long aula_id,
        double valor
){
}
