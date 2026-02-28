package com.school.management.domain.dto.response;

import java.util.Date;

public record AlunoResponseDTO(Long id, String nome, String email, String matricula, Date data_nascimento) {}
