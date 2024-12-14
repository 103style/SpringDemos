package org.example.validation.three;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * create by 103style on 2024/12/14 17:11
 */
@Service
@Validated
public class ValidatorService {

    public String validator(@NotNull @Valid Teacher teacher) {
        return teacher.toString();
    }
}
