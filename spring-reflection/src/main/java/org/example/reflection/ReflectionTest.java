package org.example.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {

    /**
     * 获取类的三种方式
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void getObjClass() throws ClassNotFoundException {
        // 1.
        Class clazz1 = User.class;
        System.out.println(clazz1);

        // 2.
        Class clazz2 = new User().getClass();
        System.out.println(clazz2);

        // 3.
        Class clazz3 = Class.forName("org.example.reflection.User");
        System.out.println(clazz3);
    }

    /**
     * 通过反射获取类的构造方法 并且通过构造方法创建对象
     */
    @Test
    public void getObjConstructMethod() throws Exception {
        Class clazz = User.class;
        // 只能获取公开的构造方法
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            int count = constructor.getParameterCount();
            System.out.println("params count:" + count + ", isPublic:" + Modifier.isPublic(constructor.getModifiers()));
            if (count == 3) {
                Object o = constructor.newInstance("mary", 20, 0);
                System.out.println(o);
            }
        }
        System.out.println("constructors.len:" + constructors.length);

        // 获取所有的构造方法
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            int count = declaredConstructor.getParameterCount();
            // 判断是否是公开的
            boolean isPublic = Modifier.isPublic(declaredConstructor.getModifiers());
            System.out.println("params count:" + count + ", isPublic:" + isPublic);
            if (!isPublic && count == 2) {
                // 非公开方法需要调用 setAccessible(true)
                declaredConstructor.setAccessible(true);
                Object jack = declaredConstructor.newInstance("Jack", 25);
                System.out.println(jack);
            }
        }
        System.out.println("declaredConstructors.len:" + declaredConstructors.length);
    }

    /**
     * 通过反射获取类的字段，以及修改对应的值
     */
    @Test
    public void getObjFields() throws Exception {
        User user = new User("haha");
        System.out.println("user:" + user);
        Class clazz = user.getClass();

        // 公开的字段
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println("fieldName:" + field.getName() + ", isPubic:" + Modifier.isPublic(field.getModifiers()));
            field.set(user, "nameModified");
            System.out.println("update field user:" + user);
        }

        // 所有的字段
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            // 判断是否是公开的
            boolean isPublic = Modifier.isPublic(declaredField.getModifiers());
            System.out.println("declaredFieldName:" + declaredField.getName() + ", isPubic:" + isPublic);
            if (!isPublic) {
                // 非公开比变量需要调用  setAccessible(true)
                declaredField.setAccessible(true);
            }
            if ("name".equals(declaredField.getName())) {
                declaredField.set(user, "declaredFieldNameUpdate");
            } else if ("age".equals(declaredField.getName())) {
                declaredField.set(user, 12);
            } else if ("gender".equals(declaredField.getName())) {
                declaredField.set(user, 3);
            }
            System.out.println("update declaredField user:" + user);
        }
    }


    /**
     * 通过返回获取类的方法，并调用对应方法
     */
    @Test
    public void getObjMethod() throws Exception {
        User user = new User();
        Class clazz = Class.forName("org.example.reflection.User");

        // 返回当前类以及父类所有的公开方法
        Method[] methods = clazz.getMethods();
        System.out.println("methods count:" + methods.length);
        for (Method method : methods) {
            System.out.println("methodName:" + method.getName() + ", params count:" + method.getParameterCount());
        }

        // 返回当前类的所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println("declaredMethods count:" + declaredMethods.length);

        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethodName:" + declaredMethod.getName() + ", params count:" + declaredMethod.getParameterCount());
            boolean isPublic = Modifier.isPublic(declaredMethod.getModifiers());
            if ("run".equals(declaredMethod.getName())) {
                if (!isPublic) {
                    declaredMethod.setAccessible(true);
                }
                declaredMethod.invoke(user);
            }
        }
    }

}
