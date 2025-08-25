package com.senac.projeto2.controller;
import com.senac.projeto2.entity.Patrocinador;
import com.senac.projeto2.service.PatrocinadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {
    private final PatrocinadorService patrocinadorService;

    public PatrocinadorController(PatrocinadorService patrocinadorService) {
        this.patrocinadorService = patrocinadorService;
    }

    @GetMapping
    public List<Patrocinador> listarTodos() {
        return patrocinadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Patrocinador> buscarPorId(@PathVariable Integer id) {
        return patrocinadorService.buscarPorId(id);
    }

    @PostMapping
    public Patrocinador salvar(@RequestBody Patrocinador patrocinador) {
        return patrocinadorService.salvar(patrocinador);
    }

    @PutMapping("/{id}")
    public Patrocinador atualizar(@PathVariable Integer id, @RequestBody Patrocinador patrocinador) {
        patrocinador.setId(id);
        return patrocinadorService.salvar(patrocinador);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        patrocinadorService.excluir(id);
    }
}
