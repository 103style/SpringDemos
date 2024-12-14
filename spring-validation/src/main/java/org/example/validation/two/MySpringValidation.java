package org.example.validation.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

/**
 * create by 103style on 2024/12/14 15:55
 */
@Service
public class MySpringValidation {

    @Autowired
    private Validator validator;

    public boolean validatorPerson(User user) {
        BindException bindException = new BindException(user, user.getName());
        validator.validate(user, bindException);
        System.out.println(bindException.getAllErrors());
        return bindException.hasErrors();
    }
}
