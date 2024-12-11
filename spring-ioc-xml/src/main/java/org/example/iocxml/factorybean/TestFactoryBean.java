package org.example.iocxml.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean implements FactoryBean<OtherBean> {
    @Override
    public OtherBean getObject() throws Exception {
        return new OtherBean();
    }

    @Override
    public Class<?> getObjectType() {
        return OtherBean.class;
    }


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-factorybean.xml");
        Object bean = context.getBean("factoryBean");
        // 这里创建的是 OtherBean 对象 而不是 TestFactoryBean 对象
        // 用于整合第三方框架
        System.out.println(bean instanceof OtherBean);
    }
}
