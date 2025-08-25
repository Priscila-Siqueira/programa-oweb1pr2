package com.senac.projeto2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patrocinador")
public class Patrocinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patrocinador_id")
    private Integer id;

    @Column(name = "patrocinador_nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "patrocinador_representante_nome", length = 100, nullable = false)
    private String representanteNome;

    @Column(name = "patrocinador_status")
    private Integer status;

    public Patrocinador() {}

    public Patrocinador(Integer id, String nome, String representanteNome, Integer status) {
        this.id = id;
        this.nome = nome;
        this.representanteNome = representanteNome;
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

    public String getRepresentanteNome() {
        return representanteNome;
    }

    public void setRepresentanteNome(String representanteNome) {
        this.representanteNome = representanteNome;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
