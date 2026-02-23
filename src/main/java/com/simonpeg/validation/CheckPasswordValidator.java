package com.simonpeg.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Object> {
    private String password;
    private String passwordConfirm;

    @Override
    public void initialize(CheckPassword checkPassword){
        this.password = checkPassword.password();
        this.passwordConfirm = checkPassword.passwordConfirm();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String passwordValue = new BeanWrapperImpl(o).getPropertyValue(password).toString();
        String passwordConfirmValue = new BeanWrapperImpl(o).getPropertyValue(passwordConfirm).toString();

        if(passwordValue.equals(passwordConfirmValue)){
            return true;
        }

        return false;
    }
}
