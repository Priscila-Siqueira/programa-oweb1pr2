package com.senac.projeto2.controller;

import com.senac.projeto2.entity.Patrocinador;
import com.senac.projeto2.service.PatrocinadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/patrocinador")
@Tag(name="Patrocinador",description = "API para gerenciamento dos patrocinadores do sistema.")
public class PatrocinadorController {
    private final PatrocinadorService patrocinadorService;

    public PatrocinadorController(PatrocinadorService patrocinadorService) {
        this.patrocinadorService = patrocinadorService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar patrocinadores no sistema.")
    public ResponseEntity<List<Patrocinador>> listar(){
        return ResponseEntity.ok(patrocinadorService.listarPatrocinadores());
    }

    @GetMapping("/listarPorIdPatrocinador/{idPatrocinador}")
    @Operation(summary = "Listar patrocinador no sistema pelo Id.")
    public ResponseEntity<Patrocinador> listarPorIdPatrocinador(@PathVariable("idPatrocinador") Integer idPatrocinador){
        Patrocinador patrocinador = patrocinadorService.listarPatrocinadorPorId(idPatrocinador);

        if (patrocinador == null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(patrocinador);
        }
    }
}
