package com.senac.projeto2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "premio")
public class Premio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "premio_id")
    private Integer id;

    @Column(name = "premio_descricao", length = 300, nullable = false)
    private String descricao;

    @Column(name = "premio_ordem_premiacao")
    private Integer ordemPremiacao;

    @Column(name = "premio_categoria")
    private Integer categoriaId;

    @Column(name = "premio_status")
    private Integer status;

    public Premio() {}

    public Premio(Integer id, String descricao, Integer ordemPremiacao, Integer categoriaId, Integer status) {
        this.id = id;
        this.descricao = descricao;
        this.ordemPremiacao = ordemPremiacao;
        this.categoriaId = categoriaId;
        this.status = status;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getOrdemPremiacao() {
        return ordemPremiacao;
    }

    public void setOrdemPremiacao(Integer ordemPremiacao) {
        this.ordemPremiacao = ordemPremiacao;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
