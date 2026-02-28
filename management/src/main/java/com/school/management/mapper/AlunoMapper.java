package com.school.management.mapper;

import com.school.management.domain.dto.request.AlunoRequestDTO;
import com.school.management.domain.dto.response.AlunoResponseDTO;
import com.school.management.domain.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    public Aluno toEntity(AlunoRequestDTO alunoRequestDTO){
        return new Aluno(alunoRequestDTO.nome(),
                alunoRequestDTO.email(),
                alunoRequestDTO.matricula(),
                alunoRequestDTO.data_nascimento());
    }

    public AlunoResponseDTO toResponse(Aluno aluno){
        return new AlunoResponseDTO(aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula(),
                aluno.getData_nascimento());
    }
}
