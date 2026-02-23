package com.simonpeg.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CheckPasswordValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPassword {
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
    public String message();

    public String password();
    public String passwordConfirm();
}
