package org.example.iocxml.lifecycle;

public class User {
    private String name;

    public User() {
        System.out.println("1.对象创建，调用无参数构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2.设置属性值");
        this.name = name;
    }

    public void init() {
        System.out.println("4.调用初始化方法");
    }

    public void destroy() {
        System.out.println("7.调用销毁方法");
    }
}
