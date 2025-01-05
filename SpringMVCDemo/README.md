# 运行报错404问题 & web.xml配置的<filter-mapping>的<filter-name>的值报红问题修正
* 打开工程结构选项框 (project structure)
* 选择Modules
* 选中对应的模块
* 点击模块的web配置
* 将Web配置的 `Deployment Descriptor`设置为对应的 web.xml文件的正确路径
* 然后运行即可

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
     通过 `request.getParameter("username")`来获取对应的参数，测试报错❌
  * `getParams(String username, String password)`：直接写参数的名字作为方法的参数，测试报错❌
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

* `HttpServletRequest` 的`setAttribute` 方式，运行报错 待处理
* `ModelAndView` 的 `addObject` 方式共享数据
* `Model` 的 `addAttribute` 方式共享数据
* `Map` 的 `put` 方法添加共享数据
* `ModelMap` 的 `addAttribute` 方式
* `session` 的`setAttribute` 方式，运行报错 待处理
* `application` 的`setAttribute` 方式，运行报错 待处理

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