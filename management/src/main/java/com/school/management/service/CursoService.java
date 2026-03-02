package com.school.management.service;

import com.school.management.domain.dto.request.CursoResquestDTO;
import com.school.management.domain.dto.response.CursoResponseDTO;
import com.school.management.domain.model.Curso;
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
        return cursoRepository.findAll()
                .stream()
                .map(cursoMapper::toResponse)
                .toList();
    }

    public CursoResponseDTO findById(Long id) {
        return cursoRepository.findById(id)
                .map(cursoMapper::toResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não Encontrado"));

    }

    public CursoResponseDTO save(CursoResquestDTO cursoResquestDTO) {
        Curso curso = cursoMapper.toEntity(cursoResquestDTO);

        return Optional.of(cursoRepository.save(curso))
                .map(cursoMapper::toResponse)
                .orElseThrow();

    }

    public CursoResponseDTO update(CursoResquestDTO cursoResquestDTO, Long id) {

        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));

        curso.setCodigo(cursoResquestDTO.codigo());
        curso.setNome(cursoResquestDTO.nome());

        return Optional.of(cursoRepository.save(curso))
                .map(cursoMapper::toResponse)
                .orElseThrow();

    }

    public void deleteById(Long id) {
        if(!cursoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado!!!");
        }
        cursoRepository.deleteById(id);
    }
}
