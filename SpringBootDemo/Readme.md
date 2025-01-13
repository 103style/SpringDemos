# SpringBoot-01-Hello
* 启动类添加注解 `@SpringBootApplication`
* 在 `main` 方法中执行 `SpringApplication.run(当前启动类名.class, args);`
* 然后SpringMVC的方式写请求响应代码
  ```
  @RestController
    public class HelloController {
      /**
      * 访问 http://localhost:8080/hello
      */
      @GetMapping("/hello")
      public String hello() {
        return "Hello SpringBoot!";
    }
  }
  ```
* `mvn clean package` 打出jar包
* `java -jar xxx.jar` 运行
* 可以在jar包目录创建 `application.properties` 文件，设置 `server.port=8888`，关闭程序，重新运行就能修改端口号为8888了。

---

# SpringBoot-02-StartSpringIO
通过 `start.spring.io` 或者 spring插件直接创建一键工程
* `xxxApplication` 程序启动入口
* `static`目录放静态资源
* `templates` 放页面
* `application.properties` 配置文件

---


