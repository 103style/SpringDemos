package org.example.validation.three;

import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * create by 103style on 2024/12/14 17:09
 */
@Configuration
@ComponentScan("org.example.validation.three")
public class ValidatorConfig {

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        // 这里可能原本有依赖EL的配置逻辑，现在要改成使用ParameterMessageInterpolator
        validatorFactoryBean.setMessageInterpolator(new ParameterMessageInterpolator());
        return validatorFactoryBean;
    }

    @Bean
    public MethodValidationPostProcessor processor(ValidatorFactory validatorFactory) {
        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
        processor.setValidatorFactory(validatorFactory);
        return processor;
    }
}
