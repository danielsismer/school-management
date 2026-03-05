package com.school.management.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "turma_id", nullable = false)
    private Turma turma_id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime data_hora;

    @Column(name = "assunto", nullable = false)
    private String assunto;


    public Aula(Turma turma_id, LocalDateTime data_hora, String assunto) {
        this.turma_id = turma_id;
        this.data_hora = data_hora;
        this.assunto = assunto;
    }
}
