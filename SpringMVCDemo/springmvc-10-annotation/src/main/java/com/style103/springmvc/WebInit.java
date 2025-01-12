package com.style103.springmvc;

import jakarta.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * create by 103style on 2025/1/12 13:23
 * github:https://github.com/103style
 *
 * 用来替代 web.xml
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 设置配置类 来代替 spring的配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    // 设置配置类 来代替 SpringMVC的配置文件
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    // 来设置SpringMVC前端控制器 DispatcherServlet 的 url-pattern
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 设置过滤器
    @Override
    protected Filter[] getServletFilters() {
        // 创建编码过滤器
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);

        //创建请求方式的过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{encodingFilter, hiddenHttpMethodFilter};
    }
}
