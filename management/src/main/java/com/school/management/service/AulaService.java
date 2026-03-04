package com.school.management.service;

import com.school.management.domain.dto.request.AulaRequestDTO;
import com.school.management.domain.dto.response.AulaResponseDTO;
import com.school.management.domain.model.Aula;
import com.school.management.mapper.AulaMapper;
import com.school.management.repository.AulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AulaService {

    private final AulaRepository aulaRepository;
    private final AulaMapper aulaMapper;

    public List<AulaResponseDTO> findAll() {
        return aulaRepository.findAll()
                .stream()
                .map(aula -> aulaMapper.toResponse(aula, aulaRepository.findTurmaByAula(aula.getId())))
                .toList();
    }

    public AulaResponseDTO findById(Long id) {
        return aulaRepository.findById(id)
                .map(aula -> aulaMapper.toResponse(aula, aulaRepository.findTurmaByAula(aula.getId())))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public AulaResponseDTO save(AulaRequestDTO aulaRequestDTO) {

        Aula aula = aulaMapper.toEntity(aulaRequestDTO);

        return Optional.of(aulaRepository.save(aula))
                .map(aulaResponse -> aulaMapper.toResponse(aulaResponse, aulaRepository.findTurmaByAula(aulaResponse.getId())))
                .orElseThrow();

    }

    public AulaResponseDTO update(Long id, AulaRequestDTO aulaRequestDTO) {

        if(!aulaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Aula aula = aulaMapper.toEntity(aulaRequestDTO);
        aula.setId(id);

        return Optional.of(aulaRepository.save(aula))
                .map(aulaResponse -> aulaMapper.toResponse(aulaResponse, aulaRepository.findTurmaByAula(aulaResponse.getId())))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT));
    }

    public void delete(Long id) {

        if(!aulaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        aulaRepository.deleteById(id);
    }
}
