package org.example.validation.one;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * create by 103style on 2024/12/14 15:35
 */
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "Name is empty");

        Person person = (Person) target;
        if (person.getAge() <= 0) {
            errors.rejectValue("age", "age.value.error", "Age need > 0");
        } else if (person.getAge() > 200) {
            errors.rejectValue("age", "age.value.error.old", "Age > 200");
        }
    }
}
