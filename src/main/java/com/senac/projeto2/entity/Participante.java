package com.senac.projeto2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "participante")
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participante_id")
    private Integer id;

    @Column(name = "participante_nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "participante_email", length = 150, nullable = false, unique = true)
    private String email;

    @Column(name = "participante_telefone", length = 20)
    private String telefone;

    @Column(name = "participante_status")
    private Integer status;

    public Participante() {}

    public Participante(Integer id, String nome, String email, String telefone, Integer status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
