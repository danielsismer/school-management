package com.school.management.controller;

import com.school.management.domain.dto.request.TurmaRequestDTO;
import com.school.management.domain.dto.response.TurmaResponseDTO;
import com.school.management.service.TurmaService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
@RequiredArgsConstructor
public class TurmaController {

    private final TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<TurmaResponseDTO>> listAll(){
        return ResponseEntity.ok(turmaService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TurmaResponseDTO> save(@RequestBody TurmaRequestDTO turmaRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.save(turmaRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaResponseDTO> update (
            @RequestBody TurmaRequestDTO turmaRequestDTO,
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(turmaService.update(turmaRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        turmaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
