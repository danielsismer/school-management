package com.school.management.controller;

import com.school.management.domain.dto.request.AlunoRequestDTO;
import com.school.management.domain.dto.response.AlunoResponseDTO;
import com.school.management.service.AlunoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> save(@RequestBody AlunoRequestDTO alunoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(alunoRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> update(@RequestBody AlunoRequestDTO alunoRequestDTO, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.update(alunoRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
           return ResponseEntity.ok(alunoService.deletebyId(id));
    }
}
