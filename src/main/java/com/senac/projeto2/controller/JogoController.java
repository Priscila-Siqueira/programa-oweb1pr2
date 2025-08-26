package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Categoria;
import com.senac.projeto2.entity.Jogo;
import com.senac.projeto2.service.CategoriaService;
import com.senac.projeto2.service.JogoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    private  final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping
    public List<Jogo> listarTodos() {
        return jogoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Jogo> buscarPorId(@PathVariable Integer id) {
        return jogoService.buscarPorId(id);
    }

    @PostMapping
    public Jogo salvar(@RequestBody Jogo jogo) {
        return jogoService.salvar(jogo);
    }

    @PutMapping("/{id}")
    public Jogo atualizar(@PathVariable Integer id, @RequestBody Jogo jogo) {
        jogo.setId(id);
        return jogoService.salvar(jogo);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        jogoService.excluir(id);
    }
}
