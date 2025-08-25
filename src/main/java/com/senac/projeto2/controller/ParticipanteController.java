package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Participante;
import com.senac.projeto2.service.ParticipanteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {
    private final ParticipanteService participanteService;

    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @GetMapping
    public List<Participante> listarTodos() {
        return participanteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Participante> buscarPorId(@PathVariable Integer id) {
        return participanteService.buscarPorId(id);
    }

    @PostMapping
    public Participante salvar(@RequestBody Participante participante) {
        return participanteService.salvar(participante);
    }

    @PutMapping("/{id}")
    public Participante atualizar(@PathVariable Integer id, @RequestBody Participante participante) {
        participante.setId(id);
        return participanteService.salvar(participante);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        participanteService.excluir(id);
    }
}
