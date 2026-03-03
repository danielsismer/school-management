package com.school.management.service;

import com.school.management.domain.dto.request.CursoResquestDTO;
import com.school.management.domain.dto.response.CursoResponseDTO;
import com.school.management.domain.model.Curso;
import com.school.management.domain.model.Professor;
import com.school.management.mapper.CursoMapper;
import com.school.management.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    public List<CursoResponseDTO> listAll() {

        List<Curso> cursos = cursoRepository.findAll();

        return cursos.stream()
                .map(curso -> cursoMapper.toResponse(curso, cursoRepository.findProfessoresByCursoId(curso.getId())))
                .toList();
    }

    public CursoResponseDTO findById(Long id) {

        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));

        List<Professor> professores = cursoRepository.findProfessoresByCursoId(curso.getId());

        return cursoMapper.toResponse(curso, professores);

    }

    public CursoResponseDTO save(CursoResquestDTO cursoResquestDTO) {

        Curso curso = cursoMapper.toEntity(cursoResquestDTO);

        return Optional.of(cursoRepository.save(curso))
                .map(savedCurso -> cursoMapper.toResponse(savedCurso, cursoRepository.findProfessoresByCursoId(savedCurso.getId())))
                .orElseThrow();

    }

    public CursoResponseDTO update(CursoResquestDTO cursoResquestDTO, Long id) {

        if(!cursoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado!!!");
        }

        Curso curso = cursoMapper.toEntity(cursoResquestDTO);
        curso.setId(id);

        return Optional.of(cursoRepository.save(curso))
                .map(savedCurso -> cursoMapper.toResponse(savedCurso, cursoRepository.findProfessoresByCursoId(savedCurso.getId())))
                .orElseThrow();

    }

    public void deleteById(Long id) {

            if(!cursoRepository.existsById(id)){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado!!!");
            }

            cursoRepository.deleteById(id);

    }
}
