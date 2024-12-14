package org.example.validation.two;

import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by 103style on 2024/12/14 15:53
 */
@Service
public class MyJakartaValidation {

    @Autowired
    private Validator validator;

    public boolean validatorPerson(User user) {
        return validator.validate(user).isEmpty();
    }
}
