package annotation.support;

import annotation.Bean;
import annotation.DI;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;

public class AnnotationApplicationContext implements ApplicationContext {

    private final HashMap<Class, Object> beanFactoryMap = new HashMap<>();
    private static String rootPath;

    @Override
    public Object getBean(Class clazz) {
        return beanFactoryMap.get(clazz);
    }


    /**
     * @param packageName org.example.iocimp
     */
    public AnnotationApplicationContext(String packageName) {
        // ⚠️⚠️⚠️ mac 需要用 "/"  windows 应该是 "\\\\" ⚠️⚠️⚠️
        String packagePath = packageName.replaceAll("\\.", "/");
        System.out.println("packageName:" + packageName + ", packagePath:" + packagePath);

        try {
            Enumeration<URL> urlEnumeration = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urlEnumeration.hasMoreElements()) {
                URL url = urlEnumeration.nextElement();
                System.out.println("url:" + url);
                String filePath = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8);
                System.out.println("filePath:" + filePath);

                rootPath = filePath.substring(0, filePath.length() - packagePath.length());
                System.out.println("rootPath:" + rootPath);

                loadBean(new File(filePath));

                // 配置了 @Bean 注解的类对象才能注入 属性字段
                configField();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadBean(File file) throws Exception {
        // 1.判断是否是文件夹
        if (file.isDirectory()) {
            // 2.获取文件的所有内容
            File[] files = file.listFiles();
            // 3.判断文件是否为空， 为空直接返回
            if (files == null || files.length == 0) {
                return;
            }
            // 4.遍历所有的文件
            for (File childFile : files) {
                // 4.1 如果是文件夹， 则递归调用 loadBean
                if (childFile.isDirectory()) {
                    loadBean(childFile);
                    continue;
                }

                // 4.2 如果是文件
                // 4.3 得到包路径 + 类名称的部分
                String childPath = childFile.getAbsolutePath().replace(rootPath, "");
                System.out.println("childPath: " + childPath);
                // 4.4 判断当前文件类型是否是.class
                if (!childPath.contains(".class")) {
                    continue;
                }
                // 4.5 如果是.class类型，把路径重的"/"替换成"." 并去掉".class"
                String classPackagePath = childPath.replace(".class", "").replaceAll("/", ".");
                System.out.println("classPackagePath: " + classPackagePath);

                // 4.6 判断类上面是否有注解 @Bean，如果有则 通过反射创建对象
                // 4.6.1 获取类的class
                Class<?> clazz = Class.forName(classPackagePath);
                // 4.6.2 判断是否是接口, 接口不需要实例化
                if (clazz.isInterface()) {
                    continue;
                }

                // 4.6.3 判断是否有注解, 没有注解直接返回
                if (clazz.getAnnotation(Bean.class) == null) {
                    continue;
                }
                // 4.6.4 示例话对象
                Object object = clazz.getDeclaredConstructor().newInstance();
                System.out.println("object: " + object);
                // 4.7 将创建的对象存入map
                // 4.7.1 判断的对象是有接口, 有接口的话，把接口class作为map的key
                if (clazz.getInterfaces().length > 0) {
                    Class<?> anInterface = clazz.getInterfaces()[0];
                    System.out.println("anInterface: " + anInterface);
                    beanFactoryMap.put(anInterface, object);
                } else {
                    beanFactoryMap.put(clazz, object);
                }
            }
        }
    }

    private void configField() throws IllegalAccessException {
        // 1.遍历所有实例化的对象
        for (Object object : beanFactoryMap.values()) {
            // 2.获取对象的字段
            Field[] fields = object.getClass().getDeclaredFields();
            // 3.遍历字段，判断是都有 DI 注解
            for (Field field : fields) {
                if (field.getAnnotation(DI.class) != null) {
                    // 4.设置写入权限
                    field.setAccessible(true);
                    // 5.读取字段的类型
                    Class<?> type = field.getType();
                    System.out.println("type: " + type);
                    // 6. 从map中获取类型对应的对象，写入字段
                    field.set(object, beanFactoryMap.get(type));
                }
            }
        }
    }
}
