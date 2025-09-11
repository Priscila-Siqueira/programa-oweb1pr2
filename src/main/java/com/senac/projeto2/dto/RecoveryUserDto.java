package com.senac.projeto2.dto;

import com.senac.projeto2.entity.Role;

import java.util.List;

public record RecoveryUserDto(

        Long id,
        String email,
        List<Role> roles

) {
}