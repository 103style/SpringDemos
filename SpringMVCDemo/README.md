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
`RequestMapping` 注解的介绍
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
  
* 占位符获取， 示例：请求`/testRest/1/admin`,通过`@PathVariable`注解即可获取到对应的占位符的值
  ```
  @RequestMapping("/testRest/{id}/{username}")
  public String testRest(@PathVariable("id") String id, @PathVariable("username") String username) {
      System.out.println("id:" + id + ",username:" + username);
      return "success";
  }
  ```