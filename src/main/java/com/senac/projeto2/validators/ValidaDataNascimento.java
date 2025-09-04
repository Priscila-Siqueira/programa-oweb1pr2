package com.senac.projeto2.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DataNascimentoValidator.class)
public @interface ValidaDataNascimento {

    String message() default "Data de nascimento inválida.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
