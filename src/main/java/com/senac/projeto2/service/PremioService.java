package com.senac.projeto2.service;

import com.senac.projeto2.entity.Premio;
import com.senac.projeto2.repository.PremioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PremioService {
    private final PremioRepository premioRepository;

    public PremioService(PremioRepository premioRepository) {
        this.premioRepository = premioRepository;
    }

    public List<Premio> listarTodos() {
        return premioRepository.findAll();
    }

    public Optional<Premio> buscarPorId(Integer id) {
        return premioRepository.findById(id);
    }

    public Premio salvar(Premio premio) {
        return premioRepository.save(premio);
    }

    public void excluir(Integer id) {
        premioRepository.deleteById(id);
    }
}
