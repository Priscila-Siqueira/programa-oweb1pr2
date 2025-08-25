package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Premio;
import com.senac.projeto2.service.PremioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/premios")
public class PremioController {
    private final PremioService premioService;

    public PremioController(PremioService premioService) {
        this.premioService = premioService;
    }

    @GetMapping
    public List<Premio> listarTodos() {
        return premioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Premio> buscarPorId(@PathVariable Integer id) {
        return premioService.buscarPorId(id);
    }

    @PostMapping
    public Premio salvar(@RequestBody Premio premio) {
        return premioService.salvar(premio);
    }

    @PutMapping("/{id}")
    public Premio atualizar(@PathVariable Integer id, @RequestBody Premio premio) {
        premio.setId(id);
        return premioService.salvar(premio);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        premioService.excluir(id);
    }
}
