package com.senac.projeto2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
@Tag(name="Usuario", description="API para gerencimento dos usuarios do sistema")
public class UsuarioController {

    @GetMapping("/listar")
     public String listar (){
         return "Listando com sucesso!";
     }

    @GetMapping("listarPorIdUsuario/{idUsuario}")
    @Operation(summary ="Listar usuarios do sistema pelo id do usuario")
    public String listarPorIdUsuario (@PathVariable("idUsuario") Integer idUsuario){
        return "Listando um usuário por id "+ idUsuario +" com sucesso!";
    }

     @PostMapping("/criar")
    public String criar (){
        return "Usuario criado com sucesso!";
     }

     @PutMapping("/atualizar")
     public String atualizar (){
         return "Usuario atualizado com sucesso!";
     }

     @DeleteMapping("/apagar")
     public String apagar (){
         return "Usuario apagado com sucesso!";
     }
}
