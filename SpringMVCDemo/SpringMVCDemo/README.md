# SpringMVC-01-HelloWorld
* 添加webapp模块
  * maven archetype → archetype 中选择 web-app
* 添加相关依赖 `spring-webmvc` `javax.servlet-api` `thymeleaf-spring6`
* 配置 [web-xml](https://github.com/103style/SpringDemos/blob/master/SpringMVCDemo/SpringMVCDemo/springmvc-01-helloworld/src/main/webapp/WEB-INF/web.xml)
* 创建请求控制器，添加注解 `@Controller`
* 创建SpringMVC配置 [springmvc.xml](https://github.com/103style/SpringDemos/blob/master/SpringMVCDemo/SpringMVCDemo/springmvc-01-helloworld/src/main/resources/springmvc.xml) 
* 启动Tomcat测试访问
* 在请求控制器中，添加方法，配置 `@RequestMapping("/")` 注解，返回 `index` 字符串。
* 再次测试访问
* `<a th:href="@{/hello}></a>` 配置 SpringMVC 跳转链接
  * 需要添加方法 配置 `@RequestMapping("/hellp")`注解

---

