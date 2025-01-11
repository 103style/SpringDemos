package com.style103.springmvc.intercept;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * create by 103style on 2025/1/11 22:04
 * github:https://github.com/103style
 */
@Component
public class TestFirstIntercept implements HandlerInterceptor {

    /**
     * 在控制器方法执行前执行
     *
     * 多个拦截器是配置的先后顺序执行
     * 参考代码：
     * org.springframework.web.servlet.HandlerExecutionChain#applyPreHandle
     * org.springframework.web.servlet.HandlerExecutionChain#applyPostHandle
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("TestFirstIntercept preHandle");
        // false 直接拦截  true 放行
        return true;
    }

    /**
     * 在控制器方法执行后执行
     *
     * 多个拦截器是配置的顺序 逆序执行
     * 参考代码：
     * org.springframework.web.servlet.HandlerExecutionChain#applyPreHandle
     * org.springframework.web.servlet.HandlerExecutionChain#applyPostHandle
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("TestFirstIntercept postHandle");
    }

    /**
     * 在控制器方法执行，且视图渲染完毕之后 执行
     *
     * 多个拦截器是配置的顺序 逆序执行
     * 参考代码：
     * org.springframework.web.servlet.HandlerExecutionChain#applyPreHandle
     * org.springframework.web.servlet.HandlerExecutionChain#applyPostHandle
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("TestFirstIntercept afterCompletion");
    }
}
