package com.senac.projeto2.controller;

import com.senac.projeto2.dto.request.JogoDtoRequest;
import com.senac.projeto2.dto.response.JogoDtoResponse;
import com.senac.projeto2.entity.Jogo;
import com.senac.projeto2.service.JogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/criar")
    @Operation(summary = "Criar um novo jogo.")
    public ResponseEntity<JogoDtoResponse> criar(@Valid @RequestBody JogoDtoRequest jogoDtoRequest){
        return ResponseEntity.ok(jogoService.salvar(jogoDtoRequest));
    }

    @PutMapping("/atualizar/{idJogo}")
    @Operation(summary = "Atualiza todos os parametros de um jogo.")
    public ResponseEntity<JogoDtoResponse> atualizar(@Valid @PathVariable("idJogo") Integer idJogo,
                                                     @RequestBody JogoDtoRequest jogoDtoRequest){
        return ResponseEntity.ok(jogoService.atualizar(idJogo, jogoDtoRequest));
    }

    @DeleteMapping("/apagar/{idJogo}")
    @Operation(summary = "Deleta um jogo do sistema pelo id.")
    public ResponseEntity<JogoDtoResponse> apagar(@PathVariable("idJogo")Integer idJogo){
        jogoService.apagar(idJogo);
        return ResponseEntity.noContent().build();
    }

}
