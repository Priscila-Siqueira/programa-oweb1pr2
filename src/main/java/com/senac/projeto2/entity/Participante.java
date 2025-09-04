package com.senac.projeto2.entity;

import jakarta.persistence.*;

import java.io.File;
import java.util.List;

@Entity
@Table(name="participante")
public class Participante {

    @Id
    @GeneratedValue
    @Column(name = "participante_id")
    private int id;

    @Column(name="participante_nome",nullable = false,length = 300)
    private String nome;

    @Column(name="participante_email",nullable = false,length = 45)
    private String email;

    @Column(name="participante_identificacao",nullable = false,length = 45)
    private String identificacao;

    @Column(name="participante_endereco",nullable = false,length = 300)
    private String endereco;

    @Column(name="participante_foto_perfil")
    private File fotoPerfil;

    @Column(name="participante_status")
    private int status;

    @OneToMany(mappedBy = "participante")
    private List<Inscricao> inscricoes;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public File getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(File fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
}
