package com.senac.projeto2.dto;

import com.senac.projeto2.entity.RoleName;

import java.time.LocalDate;

public record CreateUserDto(

        String nome,
        String cpf,
        LocalDate dataNascimento,
        String email,
        String password,
        RoleName role

) {
}
