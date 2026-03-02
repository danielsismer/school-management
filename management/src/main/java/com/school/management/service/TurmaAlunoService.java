package com.school.management.service;

import com.school.management.domain.dto.request.TurmaAlunoRequestDTO;
import com.school.management.domain.dto.response.TurmaAlunoResponseDTO;
import com.school.management.domain.model.Turma;
import com.school.management.domain.model.TurmaAluno;
import com.school.management.mapper.TurmaAlunoMapper;
import com.school.management.repository.TurmaAlunoRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TurmaAlunoService {

    private final TurmaAlunoMapper turmaAlunoMapper;
    private final TurmaAlunoRepository turmaAlunoRepository;

    public List<TurmaAlunoResponseDTO> listAll() {
        return turmaAlunoRepository.findAll()
                .stream()
                .map(turmaAlunoMapper::toResponse)
                .toList();
    }

    public @Nullable TurmaAlunoResponseDTO findById(Long id) {

        return turmaAlunoRepository.findById(id)
                .map(turmaAlunoMapper::toResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));

    }

    public @Nullable TurmaAlunoResponseDTO save(TurmaAlunoRequestDTO turmaAlunoRequestDTO) {
        TurmaAluno turma = turmaAlunoMapper.toEntity(turmaAlunoRequestDTO);

        return Optional.of(turmaAlunoRepository.save(turma))
                .map(turmaAlunoMapper::toResponse)
                .orElseThrow();
    }

    public @Nullable TurmaAlunoResponseDTO update(TurmaAlunoRequestDTO turmaAlunoRequestDTO, Long id) {
        TurmaAluno turmaAluno = turmaAlunoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        turmaAluno.setAluno(turmaAlunoRequestDTO.aluno());
        turmaAluno.setTurma(turmaAlunoRequestDTO.turma());

        return Optional.of(turmaAlunoRepository.save(turmaAluno))
                .map(turmaAlunoMapper::toResponse)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.CONFLICT));
    }

    public void deleteById(Long id) {
        if (!turmaAlunoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        turmaAlunoRepository.deleteById(id);
    }
}
