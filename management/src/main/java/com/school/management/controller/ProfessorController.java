package com.school.management.controller;

import com.school.management.domain.dto.request.ProfessorRequestDTO;
import com.school.management.domain.dto.response.ProfessorResponseDTO;
import com.school.management.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> listAll(){
        return ResponseEntity.ok(professorService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(professorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> save(@RequestBody ProfessorRequestDTO professorRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professorRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> update(@PathVariable Long id, @RequestBody ProfessorRequestDTO professorRequestDTO){
        return ResponseEntity.ok(professorService.update(id, professorRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        
        return ResponseEntity.noContent().build();

    }

}
