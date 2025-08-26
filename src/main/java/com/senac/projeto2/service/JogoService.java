package com.senac.projeto2.service;

import com.senac.projeto2.entity.Jogo;
import com.senac.projeto2.repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {
    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> listarTodos() {
        return jogoRepository.findAll();
    }

    public Optional<Jogo> buscarPorId(Integer id) {
        return jogoRepository.findById(id);
    }

    public Jogo salvar(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public void excluir(Integer id) {
        jogoRepository.deleteById(id);
    }
}
