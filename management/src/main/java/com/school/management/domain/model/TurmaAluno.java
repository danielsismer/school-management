package com.school.management.domain.model;

import com.school.management.controller.TurmaController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turma_aluno")
public class TurmaAluno {

    @Id
    @ManyToOne(optional = false)
    @JoinColumn
    Aluno aluno;

    @Id
    @ManyToOne
    @JoinColumn
    Turma turma;

}
