package com.senac.projeto2.service;

import com.senac.projeto2.dto.request.JogoDtoRequest;
import com.senac.projeto2.dto.response.JogoDtoResponse;
import com.senac.projeto2.entity.Jogo;
import com.senac.projeto2.repository.CategoriaRepository;
import com.senac.projeto2.repository.JogoRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {
    private final JogoRepository jogoRepository;
    private final CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public JogoService(JogoRepository jogoRepository, CategoriaRepository categoriaRepository) {
        this.jogoRepository = jogoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Jogo> listarJogos(){
        return this.jogoRepository.listarJogos();
    }

    public Jogo listarJogoPorId(int idJogo){
        return this.jogoRepository.obterJogoPorId(idJogo);
    }

    public JogoDtoResponse salvar(JogoDtoRequest jogoDtoRequest){
//        Jogo jogo = modelMapper.map(jogoDtoRequest, Jogo.class);
//
//        Jogo jogoSalvo = this.jogoRepository.save(jogo);
//
//        return modelMapper.map(jogoSalvo,JogoDtoResponse.class);
        Jogo jogo = new Jogo();
        jogo.setNome(jogoDtoRequest.getNome());
        jogo.setStatus(jogoDtoRequest.getStatus());
        jogo.setCategoria(categoriaRepository.obterCategoriaAtivaPorId(jogoDtoRequest.getCategoriaId()));
        Jogo jogoSave = this.jogoRepository.save(jogo);

        return modelMapper.map(jogoSave,JogoDtoResponse.class);
    }

    public JogoDtoResponse atualizar(@Valid Integer idJogo, JogoDtoRequest jogoDtoRequest){
        Jogo jogo = this.listarJogoPorId(idJogo);
        if(jogo!= null){
            jogo.setNome(jogoDtoRequest.getNome());
            jogo.setStatus(jogoDtoRequest.getStatus());
            jogo.setCategoria(categoriaRepository.obterCategoriaAtivaPorId(jogoDtoRequest.getCategoriaId()));
            Jogo jogoTemp = this.jogoRepository.save(jogo);
            return modelMapper.map(jogoTemp,JogoDtoResponse.class);
        }else {
            return null;
        }
    }

    public void apagar(Integer idJogo){
        this.jogoRepository.apagadorLogico(idJogo);

    }
}
