package com.school.management.service;

import com.school.management.domain.dto.request.TurmaRequestDTO;
import com.school.management.domain.dto.response.TurmaResponseDTO;
import com.school.management.domain.model.Turma;
import com.school.management.mapper.TurmaMapper;
import com.school.management.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaMapper turmaMapper;
    private final TurmaRepository turmaRespository;

    public List<TurmaResponseDTO> listAll() {

        return turmaRespository.findAll()
                .stream()
                .map(turma -> turmaMapper.toResponse(turma, turmaRespository.findProfessoresByCursoId(turma.getId())))
                .toList();
    }


    public TurmaResponseDTO findById(Long id) {
        return turmaRespository.findById(id)
                .map(turma -> turmaMapper.toResponse(turma, turmaRespository.findProfessoresByCursoId(turma.getId())))
                .orElseThrow();
    }


    public TurmaResponseDTO save(TurmaRequestDTO turmaRequestDTO) {
        Turma turma = turmaMapper.toEntity(turmaRequestDTO);

        return Optional.of(turmaRespository.save(turma))
                .map(turmaRsponse -> turmaMapper.toResponse(turmaRsponse, turmaRespository.findProfessoresByCursoId(turmaRsponse.getId())))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

    }

    public TurmaResponseDTO update(TurmaRequestDTO turmaRequestDTO, Long id) {
        Turma turma = turmaRespository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Turma não encontrada!!!"));

        turma.setCurso(turmaRequestDTO.curso());
        turma.setNome(turmaRequestDTO.nome());
        turma.setProfessor(turmaRequestDTO.professor());

        return Optional.of(turmaRespository.save(turma))
                .map(turmaResponse -> turmaMapper.toResponse(turmaResponse, turmaRespository.findProfessoresByCursoId(turma.getId())))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT));

    }

    public void deleteById(Long id) {
        if(!turmaRespository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        turmaRespository.deleteById(id);
    }
}
