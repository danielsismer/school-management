package com.school.management.domain.dto.request;

import java.sql.Date;

public record AlunoRequestDTO(String nome, String email, String matricula, Date data_nascimento) {}
