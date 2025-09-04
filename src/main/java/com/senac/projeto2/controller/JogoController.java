package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Jogo;
import com.senac.projeto2.service.JogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/jogo")
@Tag(name="Jogo",description = "API para gerenciamento dos jogos no sistema")
public class JogoController {
    private final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar jogos no sistema")
    public ResponseEntity<List<Jogo>> listar(){
        return ResponseEntity.ok(jogoService.listarJogos());
    }

    @GetMapping("/listarPorIdJogo/{idJogo}")
    @Operation(summary = "Lista os jogos no sistema pelo Id.")
    public ResponseEntity<Jogo> listarPorIdJogo(@PathVariable("idJogo")Integer idJogo){
        Jogo jogo = jogoService.listarJogoPorId(idJogo);

        if (jogo == null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(jogo);
        }

    }
}
