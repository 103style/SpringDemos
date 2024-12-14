package org.example.validation.two;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan("org.example.validation.two") // 开始自动扫描的路径
public class ValidatorConfig {

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        // 这里可能原本有依赖EL的配置逻辑，现在要改成使用ParameterMessageInterpolator
        validatorFactoryBean.setMessageInterpolator(new ParameterMessageInterpolator());
        return validatorFactoryBean;
    }
}