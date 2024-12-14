package org.example.validation.one;

import org.junit.Test;
import org.springframework.validation.DataBinder;

public class TestPerson {

    @Test
    public void test() {
        // 创建对象
        Person person = new Person();
        person.setName("John");
//        person.setAge(-1);
//        person.setAge(250);
        person.setAge(25);
        // 创建person对应的dataBinder
        DataBinder binder = new DataBinder(person);
        // 设置校验器
        binder.setValidator(new PersonValidator());
        //调用方法执行校验
        binder.validate();
        // 输入校验结果
        System.out.println(binder.getBindingResult().getAllErrors());
    }
}
