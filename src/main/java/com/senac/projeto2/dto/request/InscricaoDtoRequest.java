package com.senac.projeto2.dto.request;

import com.senac.projeto2.entity.Jogo;
import com.senac.projeto2.entity.Participante;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InscricaoDtoRequest {

    @NotBlank(message = "A data é obrigatória")
    private LocalDate data;

    @NotBlank(message = "É obrigatório um participante.")
    private int participanteId;

    @NotBlank(message = "É obrigatório um jogo.")
    private int jogoId;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(int participanteId) {
        this.participanteId = participanteId;
    }

    public int getJogoId() {
        return jogoId;
    }

    public void setJogoId(int jogoId) {
        this.jogoId = jogoId;
    }
}
