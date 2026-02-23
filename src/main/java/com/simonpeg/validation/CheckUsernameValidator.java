package com.simonpeg.validation;

import com.simonpeg.dao.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckUsernameValidator implements ConstraintValidator<CheckUsername, String> {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if(accountRepository.getUsername(username) > 0){
            return false;
        }
        return true;
    }
}
