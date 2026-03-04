package com.school.management.service;

import com.school.management.domain.dto.request.NotaRequestDTO;
import com.school.management.domain.dto.response.NotaResponseDTO;
import com.school.management.domain.model.Nota;
import com.school.management.mapper.NotaMapper;
import com.school.management.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotaService {

    private NotaRepository notaRepository;
    private NotaMapper notaMapper;


    public List<NotaResponseDTO> findAll() {
        return notaRepository.findAll()
                .stream()
                .map(notaResponse -> notaMapper.toResponse(
                        notaResponse,
                        notaRepository.findNomeAlunoById(notaResponse.getAluno_id()),
                        notaRepository.findAssuntoByAulaId(notaResponse.getAula_id())
                ))
                .toList();
    }

    public NotaResponseDTO findById(Long id) {
        return notaRepository.findById(id)
                .map(notaResponse -> notaMapper.toResponse(
                        notaResponse,
                        notaRepository.findNomeAlunoById(notaResponse.getAluno_id()),
                        notaRepository.findAssuntoByAulaId(notaResponse.getAula_id())
                ))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public NotaResponseDTO save(NotaRequestDTO notaRequestDTO) {

        Nota nota = notaMapper.toEntity(notaRequestDTO);

        return Optional.of(notaRepository.save(nota))
                .map(notaResponse -> notaMapper.toResponse(
                        notaResponse,
                        notaRepository.findNomeAlunoById(notaResponse.getAluno_id()),
                        notaRepository.findAssuntoByAulaId(notaResponse.getAula_id())
                ))
                .orElseThrow();
    }

    public NotaResponseDTO update(Long id, NotaRequestDTO notaRequestDTO) {

        if(!notaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Nota nota = notaMapper.toEntity(notaRequestDTO);
        nota.setId(id);

        return Optional.of(notaRepository.save(nota))
                .map(notaResponse -> notaMapper.toResponse(
                        notaResponse,
                        notaRepository.findNomeAlunoById(notaResponse.getAluno_id()),
                        notaRepository.findAssuntoByAulaId(notaResponse.getAula_id())
                ))
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.CONFLICT));

    }

    public void delete(Long id) {

        if(!notaRepository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        notaRepository.deleteById(id);
    }
}
