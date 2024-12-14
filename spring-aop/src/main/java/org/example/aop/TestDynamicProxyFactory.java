package org.example.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * create by 103style on 2024/12/14 19:11
 * todo https://www.bilibili.com/video/BV1kR4y1b7Qc  52-60小节
 */
public class TestDynamicProxyFactory {

    private final Object target;

    public TestDynamicProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        /**
         * 第一个参数: ClassLoader 加载动态生成代理类的类加载器
         * 第二个参数: interfaces 目标对象实现的所有接口的class类型数组
         * 第三个参数: InvocationHandler 设置代理对象实现目标对象方法的过程
         */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                return null;
            }
        });
    }
}
