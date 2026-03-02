package com.school.management.controller;

import com.school.management.domain.dto.request.CursoResquestDTO;
import com.school.management.domain.dto.response.CursoResponseDTO;
import com.school.management.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoResponseDTO>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CursoResponseDTO> save(@RequestBody CursoResquestDTO cursoResquestDTO) {
        return ResponseEntity.ok(cursoService.save(cursoResquestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> update(
            @RequestBody CursoResquestDTO cursoResquestDTO,
            @PathVariable Long id
    ){
        return ResponseEntity.ok(cursoService.update(cursoResquestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
