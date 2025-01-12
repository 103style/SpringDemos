package com.style103.springmvc;

import com.style103.springmvc.intercepts.FirstIntercept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * create by 103style on 2025/1/12 13:30
 * github:https://github.com/103style
 * <p>
 * 代替SpringMVC的配置文件
 * 1.扫描组件       : @ComponentScan
 * 2.视图解析器      : viewResolver()
 * 3.默认的servlet  : configureDefaultServletHandling()
 * 4.mvc驱动        : @EnableWebMvc
 * 5.视图控制器      : addViewControllers()
 * 6.文件上传解析器   : @Bean StandardServletMultipartResolver multipartResolver()
 * 7.拦截器          : addInterceptors()
 * 8.异常解析器      : configureHandlerExceptionResolvers()
 */
@Configuration // 注解表示 将该类设置为配置类
@ComponentScan("com.style103.springmvc.controller") // 配置扫描注解
@EnableWebMvc //开启MVC驱动
public class WebConfig implements WebMvcConfigurer {

    // 默认的servlet来处理静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 设置配置可用
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    /**
     * @Bean注解 标识的方法的 返回值可以作为bean来进行管理， bean的id为方法名
     */
    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 拦截器处理所有的请求
        registry.addInterceptor(new FirstIntercept()).addPathPatterns("/**");
    }

    // 配置异常解析器
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("java.lang.ArithmeticException", "error");
        resolver.setExceptionMappings(properties);
        resolver.setExceptionAttribute("ex");
        resolvers.add(resolver);
    }


    //配置生成模板解析器
    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    //生成模板引擎并为模板引擎注入模板解析器
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    //生成视图解析器并未解析器注入模板引擎
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }
}
