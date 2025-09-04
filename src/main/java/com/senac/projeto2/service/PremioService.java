package com.senac.projeto2.service;

import com.senac.projeto2.entity.Premio;
import com.senac.projeto2.repository.PremioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremioService {
    private final PremioRepository premioRepository;

    public PremioService(PremioRepository premioRepository) {
        this.premioRepository = premioRepository;
    }

    public List<Premio> listarPremios(){
        return this.premioRepository.findAll();
    }

    public Premio listarPremioPorId(int idPremio){
        return this.premioRepository.findById(idPremio).orElse(null);
    }
}
