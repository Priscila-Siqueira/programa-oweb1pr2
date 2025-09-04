package com.senac.projeto2.service;

import com.senac.projeto2.entity.Participante;
import com.senac.projeto2.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService {
    private final ParticipanteRepository participanteRepository;

    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    public List<Participante> listarParticipantes(){
        return this.participanteRepository.findAll();
    }

    public Participante listarParticipantePorId(int idParticipante){
        return this.participanteRepository.findById(idParticipante).orElse(null);
    }

}
