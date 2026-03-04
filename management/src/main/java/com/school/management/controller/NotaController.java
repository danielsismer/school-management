package com.school.management.controller;

import com.school.management.domain.dto.request.NotaRequestDTO;
import com.school.management.domain.dto.response.NotaResponseDTO;
import com.school.management.service.NotaService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notas")
public class NotaController {

    private final NotaService notaService;

    @GetMapping
    public ResponseEntity<List<NotaResponseDTO>> findALl(){
        return ResponseEntity.ok(notaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(notaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<NotaResponseDTO> save(@RequestBody NotaRequestDTO notaRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(notaService.save(notaRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaResponseDTO> update(
            @PathVariable Long id,
            @RequestBody NotaRequestDTO notaRequestDTO
    ){
        return ResponseEntity.ok(notaService.update(id, notaRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        notaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
