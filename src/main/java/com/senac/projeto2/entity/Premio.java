package com.senac.projeto2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "premio")
public class Premio {

    @Id
    @GeneratedValue
    @Column(name = "premio_id")
    private int id;

    @Column(name="premio_descricao",nullable = false,length = 300)
    private String descicao;

    @Column(name="premio_ordem_premiacao",nullable = false)
    private int ordemPremiacao;

    @Column(name="premio_categoria")
    private int categoria;

    @Column(name="premio_status")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    public int getOrdemPremiacao() {
        return ordemPremiacao;
    }

    public void setOrdemPremiacao(int ordemPremiacao) {
        this.ordemPremiacao = ordemPremiacao;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
