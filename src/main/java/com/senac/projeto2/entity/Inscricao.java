package com.senac.projeto2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;


import java.time.LocalDateTime;

@Entity
@Table(name="inscricao")
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inscricao_id")
    private int id;

    @Column(name = "inscricao_data", nullable = false, length = 50)
    private LocalDateTime data;

    @Column(name = "inscricao_status", nullable = false, length = 11)
    private int status;

    @Transient
    @JsonProperty("idParticipante")
    public int getIdParticipante(){
        return participante != null ? participante.getId() : null;
    };

    @Transient
    @JsonProperty("nomeParticipante")
    public String getNomeParticipante(){
        return participante != null ? participante.getNome() : null;
    };

    @Transient
    @JsonProperty("idJogo")
    public int getIdJogo(){
        return jogo != null ? jogo.getId() : null;
    };

    @ManyToOne
    @JoinColumn(name = "participante_id")
    @JsonIgnore
    private Participante participante;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "jogo_id",nullable = false)
    private Jogo jogo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }


}
