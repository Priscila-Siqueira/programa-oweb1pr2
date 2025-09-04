package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Inscricao;
import com.senac.projeto2.service.InscricaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/inscricao")
@Tag(name="Inscrição", description = "API para gerenciamento das inscrições no sistema.")
public class InscricaoController {
    private final InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar inscrições no sistema.")
    public ResponseEntity<List<Inscricao>> listar(){
        return ResponseEntity.ok(inscricaoService.listarInscricoes());
    }

    @GetMapping("listarPorIdInscricao/{idInscricao}")
    @Operation(summary = "Listar inscrições no sistema pelo Id.")
    public ResponseEntity<Inscricao> listarPorIdInscricao(@PathVariable("idInscricao")Integer idInscricao){
        Inscricao inscricao = inscricaoService.listarInscricaoPorId(idInscricao);

        if(inscricao == null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(inscricao);
        }
    }
}
