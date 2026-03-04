package com.school.management.domain.dto.response;

public record NotaResponseDTO (
        Long id,
        String nome_aluno,
        String aula_assunto,
        double valor
){
}
