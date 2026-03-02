package com.school.management.controller;

import com.school.management.domain.dto.request.TurmaAlunoRequestDTO;
import com.school.management.domain.dto.response.TurmaAlunoResponseDTO;
import com.school.management.service.TurmaAlunoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas_alunos")
@RequiredArgsConstructor
public class TurmaAlunoController {

    private final TurmaAlunoService turmaAlunoService;

    @GetMapping
    public ResponseEntity<List<TurmaAlunoResponseDTO>> listALl(){
        return ResponseEntity.ok(turmaAlunoService.listAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TurmaAlunoResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(turmaAlunoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TurmaAlunoResponseDTO> save(@RequestBody TurmaAlunoRequestDTO turmaAlunoRequestDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(turmaAlunoService.save(turmaAlunoRequestDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<TurmaAlunoResponseDTO> update(
            @RequestBody TurmaAlunoRequestDTO turmaAlunoRequestDTO,
            @PathVariable Long id
    ){
        return ResponseEntity.ok(turmaAlunoService.update(turmaAlunoRequestDTO, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        turmaAlunoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
