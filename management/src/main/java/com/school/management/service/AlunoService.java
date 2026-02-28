package com.school.management.service;

import com.school.management.domain.dto.request.AlunoRequestDTO;
import com.school.management.domain.dto.response.AlunoResponseDTO;
import com.school.management.domain.model.Aluno;
import com.school.management.mapper.AlunoMapper;
import com.school.management.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public List<AlunoResponseDTO> listAll() {
        return alunoRepository.findAll()
                .stream()
                .map(alunoMapper::toResponse)
                .collect(Collectors.toList());

    }


    public AlunoResponseDTO findById(Long id) {
        return alunoRepository.findById(id)
                .map(alunoMapper::toResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    public AlunoResponseDTO save(AlunoRequestDTO alunoRequestDTO) {
        Aluno aluno = alunoMapper.toEntity(alunoRequestDTO);
        return Optional.of(alunoRepository.save(aluno))
                .map(alunoMapper::toResponse)
                .orElseThrow();
    }

    public AlunoResponseDTO update(AlunoRequestDTO alunoRequestDTO, Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));

        aluno.setNome(alunoRequestDTO.nome());
        aluno.setEmail(alunoRequestDTO.email());
        aluno.setMatricula(alunoRequestDTO.matricula());
        aluno.setData_nascimento(alunoRequestDTO.data_nascimento());



       return Optional.of(alunoRepository.save(aluno))
                .map(alunoMapper::toResponse)
                .orElseThrow();
    }

    public void deletebyId(Long id) {

        if(!alunoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }

        alunoRepository.deleteById(id);

    }
}
