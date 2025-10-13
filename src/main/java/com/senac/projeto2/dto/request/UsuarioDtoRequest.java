package com.senac.projeto2.dto.request;


import com.senac.projeto2.entity.RoleName;
import com.senac.projeto2.validators.ValidaDataNascimento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UsuarioDtoRequest {

    @NotBlank(message= "o nome é obrigatório")
    private String nome;

    @Size(min = 11, max= 11, message = "O cpf tem que ter 11 caracteres.")
    @NotBlank(message = "o cpf é obrigatório")
    private String cpf;

    @ValidaDataNascimento
    private LocalDate dataNascimento;

    private String login;

    private String senha;

    private RoleName roleName;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String email) {
        this.login = email;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }


}
