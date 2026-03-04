package com.school.management.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nota")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aluno_id", nullable = false)
    private Long aluno_id;

    @Column(name = "aula_id", nullable = false)
    private Long aula_id;

    @Column(name = "valor", nullable = false)
    private double valor;

    public Nota(Long aluno_id, Long aula_id, double valor) {
        this.aluno_id = aluno_id;
        this.aula_id = aula_id;
        this.valor = valor;
    }

}
