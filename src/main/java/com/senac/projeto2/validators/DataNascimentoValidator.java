package com.senac.projeto2.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DataNascimentoValidator implements ConstraintValidator<ValidaDataNascimento, LocalDate> {

    @Override
    public void initialize(ValidaDataNascimento constraintAnnotation){

    }

    @Override
    public boolean isValid(LocalDate dataNascimento, ConstraintValidatorContext context){
        if (dataNascimento == null){
            return true;
        }
        if (dataNascimento.isAfter(LocalDate.now())){
            return false;
        }
        int idadeMinima = 18;
        if(dataNascimento.plusYears(idadeMinima).isAfter(LocalDate.now())){
            return false;
        }

        return true;
    }
}
