package com.senac.projeto2.service;

import com.senac.projeto2.entity.Participante;
import com.senac.projeto2.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {
    private final ParticipanteRepository participanteRepository;

    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    public List<Participante> listarTodos() {
        return participanteRepository.findAll();
    }

    public Optional<Participante> buscarPorId(Integer id) {
        return participanteRepository.findById(id);
    }

    public Participante salvar(Participante participante) {
        return participanteRepository.save(participante);
    }

    public void excluir(Integer id) {
        participanteRepository.deleteById(id);
    }
}
