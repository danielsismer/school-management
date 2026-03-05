package com.school.management.domain.model;

import com.school.management.mapper.AlunoMapper;
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

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno_id;

    @ManyToOne
    @JoinColumn(name = "aula_id", nullable = false)
    private Aula aula_id;

    @Column(name = "valor", nullable = false)
    private double valor;

    public Nota(Aluno aluno_id, Aula aula_id, double valor) {
        this.aluno_id = aluno_id;
        this.aula_id = aula_id;
        this.valor = valor;
    }

}
