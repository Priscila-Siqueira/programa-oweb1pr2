package com.senac.projeto2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "jogo")
public class Jogo {
    @Id
    @GeneratedValue
    @Column(name="jogo_id")
    private int id;

    @Column(name="jogo_nome",nullable = false,length = 30)
    private String nome;

    @Column(name="jogo_status",nullable = false)
    private int status;

    @JoinColumn(name = "categoria_id", nullable = false)
    @JsonIgnore
    private Categoria categoria;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
