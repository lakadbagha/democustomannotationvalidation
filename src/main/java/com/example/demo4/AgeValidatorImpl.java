/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4;

import com.example.demo4.model.Student;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author deepak
 */
class AgeValidatorImpl implements ConstraintValidator<AgeValidator, Integer> {

    private int upperLimit;
    private int lowerLimit;

    @Override
    public void initialize(AgeValidator constraintAnnotation) {
        this.lowerLimit = constraintAnnotation.lower();
        this.upperLimit = constraintAnnotation.upper();
    }

    @Override
    public boolean isValid(Integer t, ConstraintValidatorContext cvc) {
        System.out.println(": invoked");
        return lowerLimit < t && t < upperLimit;
    }

}
