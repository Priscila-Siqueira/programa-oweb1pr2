package com.senac.projeto2.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class InscricaoDtoRequestUpdate {
    @NotBlank(message = "A data é obrigatória")
    private LocalDateTime data;

    @NotBlank(message = "É obrigatório um participante.")
    private Integer participanteId;

    @NotBlank(message = "É obrigatório um jogo.")
    private Integer jogoId;

    private Integer status;

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Integer participanteId) {
        this.participanteId = participanteId;
    }

    public Integer getJogoId() {
        return jogoId;
    }

    public void setJogoId(Integer jogoId) {
        this.jogoId = jogoId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
