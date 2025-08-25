package com.senac.projeto2.service;
import com.senac.projeto2.entity.Patrocinador;
import com.senac.projeto2.repository.PatrocinadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrocinadorService {
    private final PatrocinadorRepository patrocinadorRepository;

    public PatrocinadorService(PatrocinadorRepository patrocinadorRepository) {
        this.patrocinadorRepository = patrocinadorRepository;
    }

    public List<Patrocinador> listarTodos() {
        return patrocinadorRepository.findAll();
    }

    public Optional<Patrocinador> buscarPorId(Integer id) {
        return patrocinadorRepository.findById(id);
    }

    public Patrocinador salvar(Patrocinador patrocinador) {
        return patrocinadorRepository.save(patrocinador);
    }

    public void excluir(Integer id) {
        patrocinadorRepository.deleteById(id);
    }
}
