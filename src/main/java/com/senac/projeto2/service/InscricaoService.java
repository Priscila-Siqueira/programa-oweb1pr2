package com.senac.projeto2.service;

import com.senac.projeto2.dto.request.InscricaoDtoRequest;
import com.senac.projeto2.dto.request.InscricaoDtoRequestUpdate;
import com.senac.projeto2.dto.response.InscricaoDtoResponse;
import com.senac.projeto2.entity.Inscricao;
import com.senac.projeto2.repository.InscricaoRepository;
import com.senac.projeto2.repository.JogoRepository;
import com.senac.projeto2.repository.ParticipanteRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {
    private final InscricaoRepository inscricaoRepository;
    private final ParticipanteRepository participanteRepository;
    private final JogoRepository jogoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public InscricaoService(InscricaoRepository inscricaoRepository,
                            ParticipanteRepository participanteRepository,
                            JogoRepository jogoRepository) {
        this.inscricaoRepository = inscricaoRepository;
        this.participanteRepository = participanteRepository;
        this.jogoRepository = jogoRepository;
    }


    public List<Inscricao> listarInscricoes(){
        return this.inscricaoRepository.listarInscricoesAtivas();
    }

    public Inscricao listarInscricaoPorId(Integer idInscricao){
        return this.inscricaoRepository.obterInscricaoAtivaPorId(idInscricao);
    }

    public InscricaoDtoResponse salvar(InscricaoDtoRequest inscricaoDtoRequest) {
//        Inscricao inscricao = modelMapper.map(inscricaoDtoRequest, Inscricao.class);
//        inscricao.setStatus(1);
          Inscricao inscricao = new Inscricao();
          inscricao.setData(inscricaoDtoRequest.getData());
          inscricao.setStatus(1);
          inscricao.setParticipante(participanteRepository.obterParticipanteAtivoPorId(inscricaoDtoRequest.getParticipanteId()));
          inscricao.setJogo(jogoRepository.obterJogoPorId(inscricaoDtoRequest.getJogoId()));
        Inscricao inscricaoSalva = this.inscricaoRepository.save(inscricao);

        return modelMapper.map(inscricaoSalva, InscricaoDtoResponse.class);
    }

    public InscricaoDtoResponse atualizar(Integer idInscricao, InscricaoDtoRequestUpdate inscricaoDtoRequestUpdate){
        Inscricao inscricao = this.listarInscricaoPorId(idInscricao);
        if (inscricao != null){
            inscricao.setData(inscricaoDtoRequestUpdate.getData());
            inscricao.setStatus(inscricaoDtoRequestUpdate.getStatus());
            inscricao.setParticipante(participanteRepository.obterParticipanteAtivoPorId(inscricaoDtoRequestUpdate.getParticipanteId()));
            inscricao.setJogo(jogoRepository.obterJogoPorId(inscricaoDtoRequestUpdate.getJogoId()));
//            modelMapper.map(inscricaoDtoRequestUpdate, inscricao);
            Inscricao inscricaoTemp = this.inscricaoRepository.save(inscricao);

            return modelMapper.map(inscricaoTemp,InscricaoDtoResponse.class);
        }else{
            return null;
        }
    }

    public void apagar(Integer idInscricao){
        Inscricao inscricao = listarInscricaoPorId(idInscricao);
        if (inscricao != null){
            this.inscricaoRepository.apagadorLogico(idInscricao);
        }
    }
}
