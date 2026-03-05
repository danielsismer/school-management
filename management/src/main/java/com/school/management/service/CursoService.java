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

    public List<CursoResponseDTO> findAll() {

        // todos os cursos
        List<Curso> cursos = cursoRepository.findAll();


        return cursos.stream()
                .map(curso -> {
                    List<Professor> professores = cursoRepository.findProfessoresByCursoId(curso.getId());

                    List<String> nome = professores
                            .stream()
                            .map(Professor::getNome)
                            .toList();

                    return cursoMapper.toResponse(curso, nome);
                })
                .toList();
    }

    public CursoResponseDTO findById(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));

        List<Professor> professores = cursoRepository.findProfessoresByCursoId(id);

        List<String> nome = professores
                .stream()
                .map(Professor::getNome)
                .toList();


        return cursoMapper.toResponse(curso, nome);
    }

    public CursoResponseDTO save(CursoResquestDTO cursoRequestDTO) {
        Curso curso = cursoMapper.toEntity(cursoRequestDTO);
        Curso savedCurso = cursoRepository.save(curso);

        List<Professor> professores = cursoRepository.findProfessoresByCursoId(savedCurso.getId());

        List<String> nome = professores
                .stream()
                .map(Professor::getNome)
                .toList();


        return cursoMapper.toResponse(savedCurso, nome);
    }

    public CursoResponseDTO update(CursoResquestDTO cursoRequestDTO, Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado!!!");
        }

        Curso curso = cursoMapper.toEntity(cursoRequestDTO);
        curso.setId(id);

        Curso updatedCurso = cursoRepository.save(curso);
        List<Professor> professores = cursoRepository.findProfessoresByCursoId(id);

        List<String> nome = professores
                .stream()
                .map(Professor::getNome)
                .toList();


        return cursoMapper.toResponse(updatedCurso, nome);
    }

    public void deleteById(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado!!!");
        }
        cursoRepository.deleteById(id);
    }
}