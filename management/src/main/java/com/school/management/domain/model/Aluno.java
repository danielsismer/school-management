package com.school.management.domain.model;

import jakarta.persistence.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "matricula", unique = true, nullable = false)
    private String matricula;

    @Column(name = "data_nascimento", nullable = false)
    private Date data_nascimento;

    public Aluno(String nome, String email,  String matricula, Date data_nascimento) {
        this.nome = nome;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.matricula = matricula;
    }
}
