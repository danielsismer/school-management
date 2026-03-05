package com.school.management.domain.dto.request;

import com.school.management.domain.model.Aluno;
import com.school.management.domain.model.Aula;

public record NotaRequestDTO (
        Aluno aluno_id,
        Aula aula_id,
        double valor
){
}
