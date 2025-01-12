# 运行报错404问题 & web.xml配置的<filter-mapping>的<filter-name>的值报红问题修正
* 打开工程结构选项框 (project structure)
* 选择Modules
* 选中对应的模块
* 点击模块的web配置
* 将Web配置的 `Deployment Descriptor`设置为对应的 web.xml文件的正确路径
* 然后运行即可

---

# 使用 javax.servlet 依赖，参数使用 HttpServletRequest等运行报错
**Spring5.3+版本 用 `javax.servlet` 会报错， 需要替换成 `jakarta.servlet` 依赖**

错误信息如下
```
jakarta.servlet.ServletException: Request processing failed: java.lang.IllegalStateException: No primary or single unique constructor found for interface javax.servlet.http.HttpServletRequest
	org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1022)
	org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:903)
	jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)
	org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
	jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)
	org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
```


---

# SpringMVC-01-HelloWorld
* 添加webapp模块
  * maven archetype → archetype 中选择 web-app
* 添加相关依赖 `spring-webmvc` `javax.servlet-api` `thymeleaf-spring6`
* 配置 [web-xml](https://github.com/103style/SpringDemos/blob/master/SpringMVCDemo/springmvc-01-helloworld/src/main/webapp/WEB-INF/web.xml)
* 创建请求控制器，添加注解 `@Controller`
* 创建SpringMVC配置 [springmvc.xml](https://github.com/103style/SpringDemos/blob/master/SpringMVCDemo/springmvc-01-helloworld/src/main/resources/springmvc.xml) 
* 启动Tomcat测试访问
* 在请求控制器中，添加方法，配置 `@RequestMapping("/")` 注解，返回 `index` 字符串。
* 再次测试访问
* `<a th:href="@{/hello}></a>` 配置 SpringMVC 跳转链接
  * 需要添加方法 配置 `@RequestMapping("/hellp")`注解

---

# SpringMVC-02-RequestMapping
* `RequestMapping` 注解的介绍
  * `value` 属性
    * 是一个数组，可以配置多个地址对应同一个内容，示例：
      ```
      @RequestMapping(value = {"/", "/home", "/index"})
      ```
    * 当类上有 `@RequestMapping("/position")`的注解是，方法配置的路径前面需要加上类上配置的路径
      ```
      @RequestMapping("/position")
      public class RequestMappingPositionTest {
          @RequestMapping("/index")
          public String index() {
              // 对应的访问链接是 /position/index
              return "position";
          }
      }
      ```
  * `method`属性
    * 是一个数组，可以配置多个方法，示例：
      ```
      @RequestMapping(value = {"/gettest"}, method = {RequestMethod.GET, RequestMethod.POST})
      ```  
    * `@GetMapping` = `@RequestMapping(method = {RequestMethod.GET})`
    * `@PostMapping` = `@RequestMapping(method = {RequestMethod.POST})`
    * `@PUTMapping` = `@RequestMapping(method = {RequestMethod.PUT})`
  
  * `params` 参数匹配, 示例：params = {"username"}：通过属性参数匹配，参数不匹配会报错 400
    * `username`：表示请求必须携带 username 参数
    * `!username`：表示请求一定不能携带 username 参数
    * `username=value`：表示请求必须携带 username 参数，并且值要等于value
    * `username!=value`：表示请求如果携带 username参数，值一定不能为value，可以不带username参数
  
  * `headers` 请求头匹配， 示例：headers={"referer"}：通过请求头匹配，不匹配会报错 404
    * `referer`：表示请求头必须携带 referer 参数
    * `!referer`：表示请求头一定不能携带 referer 参数
    * `referer=value`：表示请求头必须携带 referer 参数，并且值要等于value
    * `referer!=value`：表示请求头如果携带 referer，值一定不能为value，可以不带 referer

  * ant风格路径： 可以在路径中添加 `?`、`*`、`**` 三个匹配符
    * `?`:表示任意的单个字符（不包括 ? 这些特殊字符）
    * `*`:表示任意的0个或多个字符（不包括 ? 这些特殊字符）
    * `**`:匹配任意层数的任意目录， 前后不能有其他字符，**只能写在双斜线中
  
  * 占位符获取， 示例：请求`/testRest/1/admin`,配置匹配链接为`/testRest/{id}/{username}` ,通过`@PathVariable`注解即可获取到对应的占位符的值
    ```
    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable("id") String id, @PathVariable("username") String username) {
        System.out.println("id:" + id + ",username:" + username);
        return "success";
    }
    ```
* 获取请求参数
  * `get(HttpServletRequest request)`：配置 HttpServletRequest 类型的参数值, 
     通过 `request.getParameter("username")`来获取对应的参数，测试报错❌ (已修正，Spring5.3+版本 用 `javax.servlet` 会报错， 需要替换成 `jakarta.servlet` 依赖)
  * `getParams(String username, String password)`：直接写参数的名字作为方法的参数，测试报错❌ (已修正，Spring5.3+版本 用 `javax.servlet` 会报错， 需要替换成 `jakarta.servlet` 依赖)
  * 通过给参数配置注解 `@RequestParam` 来指定当前参数对应哪个请求参数
    * `value`: 对应的请求参数名
    * `required`: 是否必传,默认false, 设置了 `defaultValue` 之后无效
    * `defaultValue`: 默认值
    ```
    public String getParams2(
            @RequestParam(value = "username", required = true, defaultValue = "103style") String name,
            @RequestParam(value = "password", required = true, defaultValue = "123123") String password
    ) {}
    ```
  * 通过对应的请求参数名字的实体类来获取参数
    ```
    public String getParams3(User user) {}
    ```
* 配置请求/响应的编码，避免乱码

---

# SpringMVC-03-ShareData
[参考代码](https://github.com/103style/SpringDemos/blob/master/SpringMVCDemo/springmvc-03-sharedata/src/main/java/com/style103/springmvc/controller/ShareDataController.java)

* `HttpServletRequest` 的`setAttribute` 方式，运行报错 (已修正，Spring5.3+版本 用 `javax.servlet` 会报错， 需要替换成 `jakarta.servlet` 依赖)
* `ModelAndView` 的 `addObject` 方式共享数据
* `Model` 的 `addAttribute` 方式共享数据
* `Map` 的 `put` 方法添加共享数据
* `ModelMap` 的 `addAttribute` 方式
* `session` 的`setAttribute` 方式，运行报错 (已修正，Spring5.3+版本 用 `javax.servlet` 会报错， 需要替换成 `jakarta.servlet` 依赖)
* `application` 的`setAttribute` 方式，运行报错 (已修正，Spring5.3+版本 用 `javax.servlet` 会报错， 需要替换成 `jakarta.servlet` 依赖)

**Model、ModelMap、Map的关系**
```
public interface Model{}
public class ModelMap extends LinkedHashMap<String, Object> {}
public class ExtendedModelMap extends ModelMap implements Model {}
public class BindingAwareModelMap extends ExtendedModelMap {}
```

---

# SpringMVC-04-View
* `xxx`: ThymeleafView 
  * 当控制器方法中所设置的视图名称没有任何前缀时,此时的视图名称会被SpringMVC配置文件中所配置的视图解析器解析
* `forward:/xxx` 转发视图：`InternalResourceView`
  * 当控制器方法中所设置的视图名称以"forward:"为前缀时，创建InternalResourceView视图
* `forward:/xxx` 重定向视图：`RedirectView`
  * 当控制器方法中所设置的视图名称以"redirect:"为前缀时，创建RedirectView视图


---

# SpringMVC-05-Restful
* `put` 和 `delete` 方法请求
  * 首先需要在 `web.xml` 中配置 `HiddenHttpMethodFilter` 过滤器
  * 然后添加 `from`表单，将`method`配置成 `post`, 内部需要添加一个 `<input type="hidden" name="_method" value="put/delete"/>`

* 控制台输出中文乱码
  * 检查 `Setting -> Editor -> File Encodings` 的所有编码是否设置为 `UTF-8`
  * `web.xml` 中是否配置 `CharacterEncodingFilter` 过滤器，以及参数`encoding`是否配置为`UTF-8`，`forceEncoding`是否配置为`true`
  * 可以在启动的 `VM options` 中配置 `-Dfile.encoding=UTF-8`

* 静态资源处理
  * 需要在 `springmvc.xml` 中 添加以下两个配置， 浏览器发送的请求默认会被`DispatcherServlet`处理，处理不了的会被`DefaultServlet`处理
    * `<mvc:default-servlet-handler/>` 配置默认的servlet处理静态资源
    * `<mvc:annotation-driven/>`  开启注解驱动

* vue.js下载方式
  * 点击 https://cn.vuejs.org/
  * 点击快速上手
  * 点击左边栏的快速上手
  * 下拉找到 `通过CDN使用Vue`, 打开`<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>`中的链接复制内容到本地
  * 也可以直接使用 CDN的方式使用Vue
  * 点击事件设置 `v-on:click="deleteEmployee($event)"`

---

# SpringMVC-06-ajax
ajax请求地址为 `http://localhost:8080` 后面的全路径 

参考文档：https://www.axios-http.cn/docs/intro

请求示例:
```
// 这两个方式选一个都可以
// 1
// <script th:src="@{/static/js/vue.js}"></script>
// 2
const axios = require('axios');


// 向给定ID的用户发起请求
axios.get('/user?ID=12345')
  .then(function (response) {
    // 处理成功情况
    console.log(response);
  })
  .catch(function (error) {
    // 处理错误情况
    console.log(error);
  })
  .finally(function () {
    // 总是会执行
  });

axios.post('/springmvc/test/ajax?id=1001', {
        username: 'admin',
        password: '123456'
    },
    {
        headers: {
            'Content-Type': 'application/json' // 确保 Content-Type 为 application/json
        }
    }
).then(function (response) {
    console.log(response);
}).catch(function (error) {
    console.log(error);
});
```


---


# SpringMVC-07-DownUpload
* 下载
  ```
  public ResponseEntity<byte[]> downloadFile(HttpSession session) throws IOException {
      //获取ServletContext对象
      ServletContext servletContext = session.getServletContext();
      //获取服务器中文件的真实路径
      String realPath = servletContext.getRealPath("img") + File.separator + "heiwukong.png";
      System.out.println("realPath:" + realPath);
      //创建输入流
      InputStream is = new FileInputStream(realPath);
      //创建字节数组
      byte[] bytes = new byte[is.available()];
      //将流读到字节数组中
      is.read(bytes);
      //创建HttpHeaders对象设置响应头信息
      MultiValueMap<String, String> headers = new HttpHeaders();
      //设置要下载方式以及下载文件的名字
      headers.add("Content-Disposition", "attachment;filename=heiwukong.jpg");
      //设置响应状态码
      HttpStatus statusCode = HttpStatus.OK;
      //创建ResponseEntity对象
      ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
      //关闭输入流
      is.close();
      return responseEntity;
  }
  ```
* 上传
  * `form` 表单一定需要设置 `method` 的为 `post`, `enctype` 为 `multipart/form-data`
  * `input` 配置的 `name` 的值就是请求参数
    ```
    <form enctype="multipart/form-data" method="post" th:action="@{/test/upload}">
        头像：<input accept="image/*" id="photo" multiple="multiple" name="photo" type="file"> <br>
        <input type="submit" value="上传">
    </form>
    ```
  * springmvc配置需要配置 `id="multipartResolver" class="org.springframework.web.multipart.support.StandardServletMultipartResolver"` 的文件上传解析器
    * 😫😫😫TODO 目前上传还是失败，还没找到哪里不对😫😫😫 
    ```
    <!-- 配置文件上传解析器 通过id获取 -->
    <bean id="multipartResolver" class="org.springframework.web.multipart.support.StandardServletMultipartResolver">
        <property name="resolveLazily" value="true" />
    </bean>
    ```

---

# SpringMVC-08-Intercept
拦截器，会拦截`DispatcherServlet`处理所有的请求（可以通过配置修改）

* 首先需要实现 `HandlerInterceptor` 接口
* 需要在springmvc配置中添加拦截器配置
  ```
  <mvc:interceptors>
      <!-- 方式1和2配置的拦截器会拦截DispatcherServlet处理所有的请求-->
      <!-- 方式1 -->
      <!-- <bean class="com.style103.springmvc.intercept.TestFirstIntercept"/>-->
      <!-- 方式2  需要在 TestFirstIntercept 中添加@Component注解-->
      <!-- component-scan 配置的扫描包也要包含TestFirstIntercept所在包 -->
      <!-- <ref bean="testFirstIntercept"/>-->
      <!-- 方式3  可以配置要拦截的路径 和 排除的路径-->
      <mvc:interceptor>
          <!-- /* 只能匹配 一层路径（/abc）, /a/b/c 就不会匹配， 需要匹配就需要改成 /** -->
          <!--  <mvc:mapping path="/*"/>-->
          <mvc:mapping path="/**"/>
          <mvc:exclude-mapping path="/abc/ab"/>
          <ref bean="testFirstIntercept"/>
      </mvc:interceptor>
      ...
  </mvc:interceptors>
  ```
* 拦截器方法的执行顺序
  * `preHandle`是配置的顺序 **顺序执行**，其他两个方法是 **逆序执行**, 参考以下代码：
    * `org.springframework.web.servlet.HandlerExecutionChain#applyPreHandle`
    * `org.springframework.web.servlet.HandlerExecutionChain#applyPostHandle`
  * 如果后面的拦截器 `preHandle` 返回 `false`, 前面拦截器的 `preHandle`和`afterCompletion`会执行。

---

# SpringMVC-09-ExceptionHandler 
异常处理器

有两个配置，第一种通过在springmvc.xml中配置，第二种通过注解的方式
* xml配置方式:
  ```
  <!--  配置异常处理器  -->
  <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
      <property name="exceptionMappings">
          <props>
              <!-- 配置对应异常跳转的逻辑视图 -->
              <prop key="java.lang.ArithmeticException">error</prop>
          </props>
      </property>
      <!-- 共享异常信息到请求域中， 名字为value配置的值 -->
      <property name="exceptionAttribute" value="ex"/>
  </bean>
  ```
  
* 注解方式：通过在方法上添加 `@ExceptionHandler(ArithmeticException.class)`, 配置要处理的异常。
  ```
  // 配置要处理的异常， 返回遇到该异常时要跳转的逻辑视图
  @ExceptionHandler(ArithmeticException.class) 
  public String handleException(Throwable ex, Model model) {
      System.out.println("-------handleException ex:" + ex);
      System.out.println("-------handleException ex:" + ex);
      model.addAttribute("ex", ex);
      return "error";
  }
  ```


---


# SpringMVC-10-Annotation
通过注解配置SpringMVC，替换 `web.xml``配置

* 继承抽象类 `AbstractAnnotationConfigDispatcherServletInitializer`，实现对应的方法
  * `Class<?>[] getRootConfigClasses()`    : spring配置的class数组
  * `Class<?>[] getServletConfigClasses()` : springmvc配置的class数组
  * `String[] getServletMappings()`        : 设置SpringMVC前端控制器 `DispatcherServlet` 的 `url-pattern`
  * `Filter[] getServletFilters()`         : 设置过滤器

* 给Spring配置和 SpringMVC配置的类 添加注解 `@Configuration`, 标识该类设置为配置类

* SpringMVC类配置，继承类 `WebMvcConfigurer`, 参考示例类 `WebConfig`
  * 扫描组件       : 给配置类添加注解 `@ComponentScan(包名)`
  * 视图解析器      : 实现方法`viewResolver() / templateEngine() / templateResolver()` ，并在方法添加 `@Bean` 注解，
  * 默认的servlet  : 重写方法 `configureDefaultServletHandling()`
  * mvc驱动        : 给配置类添加注解 `@EnableWebMvc`
  * 视图控制器      : 重写方法 `addViewControllers()`
  * 文件上传解析器   : 实现方法 `StandardServletMultipartResolver multipartResolver()`，并在方法添加 `@Bean` 注解
  * 拦截器         : 重写方法 `addInterceptors()`
  * 异常解析器      : 重写方法 `configureHandlerExceptionResolvers()`

---