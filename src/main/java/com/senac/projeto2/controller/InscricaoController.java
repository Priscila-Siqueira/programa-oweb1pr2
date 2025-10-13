package com.senac.projeto2.controller;

import com.senac.projeto2.dto.request.InscricaoDtoRequest;
import com.senac.projeto2.dto.request.InscricaoDtoRequestUpdate;
import com.senac.projeto2.dto.response.CategoriaDtoResponse;
import com.senac.projeto2.dto.response.InscricaoDtoResponse;
import com.senac.projeto2.entity.Inscricao;
import com.senac.projeto2.service.InscricaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/listarPorIdInscricao/{idInscricao}")
    @Operation(summary = "Listar inscrições no sistema pelo Id.")
    public ResponseEntity<Inscricao> listarPorIdInscricao(@PathVariable("idInscricao")Integer idInscricao){
        Inscricao inscricao = inscricaoService.listarInscricaoPorId(idInscricao);

        if(inscricao == null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(inscricao);
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar uma inscrição.")
    public ResponseEntity<InscricaoDtoResponse> criarCategoria(@Valid @RequestBody InscricaoDtoRequest inscricaoDtoRequest){
        return ResponseEntity.ok(inscricaoService.salvar(inscricaoDtoRequest));
    }

    @PutMapping("/atualizar/{idInscricao}")
    @Operation(summary = "Atualiza uma inscrição.")
    public ResponseEntity<InscricaoDtoResponse> atualizar(
            @Valid @PathVariable("idInscricao") Integer idInscricao,
            @RequestBody InscricaoDtoRequestUpdate inscricaoDtoRequestUpdate){
        return ResponseEntity.ok(inscricaoService.atualizar(idInscricao, inscricaoDtoRequestUpdate));
    }

    @DeleteMapping("/apagar/{idInscricao}")
    @Operation(summary = "Deleta uma inscrição do sistema pelo seu Id.")
    public ResponseEntity<InscricaoDtoResponse> apagar(@PathVariable("idInscricao") Integer idInscricao){
        inscricaoService.apagar(idInscricao);
        return ResponseEntity.noContent().build();
    }

}
