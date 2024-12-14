package org.example.validation.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * create by 103style on 2024/12/14 18:19
 */
public class GenderValidator implements ConstraintValidator<Gender,Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value != 0 && value != 1) {
            String template = context.getDefaultConstraintMessageTemplate();
            System.out.println(template);
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("字段只能是 0：女 和 1：男").addConstraintViolation();
            return false;
        }
        return true;
    }
}
