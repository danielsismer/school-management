package com.school.management.service;

import com.school.management.domain.dto.request.ProfessorRequestDTO;
import com.school.management.domain.dto.response.ProfessorResponseDTO;
import com.school.management.domain.model.Professor;
import com.school.management.mapper.ProfessorMapper;
import com.school.management.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public List<ProfessorResponseDTO> listAll() {
        return professorRepository.findAll()
                .stream()
                .map(professorMapper::toResponse)
                .toList();
    }


    public ProfessorResponseDTO findById(Long id) {

        if (!professorRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não Encontrado!!!");
        }

        return professorRepository.findById(id)
                .map(professorMapper::toResponse)
                .orElseThrow();
    }

    public ProfessorResponseDTO save(ProfessorRequestDTO professorRequestDTO) {

        Professor professor = professorMapper.toEntity(professorRequestDTO);

        return Optional.of(professorRepository.save(professor))
                .map(professorMapper::toResponse)
                .orElseThrow();

    }

    @Transactional
    public ProfessorResponseDTO update(Long id, ProfessorRequestDTO professorRequestDTO) {

        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado"));

        professor.setNome(professorRequestDTO.nome());
        professor.setEmail(professorRequestDTO.email());
        professor.setDisciplina(professorRequestDTO.disciplina());

        return Optional.of(professorRepository.save(professor))
                .map(professorMapper::toResponse)
                .orElseThrow();

    }

    public void deleteById(Long id) {

        if(!professorRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.OK, "Professor não Encontrado!!!");
        }

        professorRepository.deleteById(id);

    }
}
