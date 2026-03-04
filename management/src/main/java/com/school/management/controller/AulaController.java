package com.school.management.controller;

import com.school.management.domain.dto.request.AulaRequestDTO;
import com.school.management.domain.dto.response.AulaResponseDTO;
import com.school.management.service.AulaService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/aulas")
public class AulaController {


    private final AulaService aulaService;

    @GetMapping
    public ResponseEntity<List<AulaResponseDTO>> listAll(){
        return ResponseEntity.ok(aulaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AulaResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(aulaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AulaResponseDTO> save(@RequestBody AulaRequestDTO aulaRequestDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(aulaService.save(aulaRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AulaResponseDTO> update(@PathVariable Long id,
                                                  @RequestBody AulaRequestDTO aulaRequestDTO){
        return ResponseEntity.ok(aulaService.update(id, aulaRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        aulaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
