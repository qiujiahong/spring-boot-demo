# 拦截器


## 实现步骤

* 实现自定义拦截器

```java
@Component
public class SomeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行拦截器");
        return true;//preHandle 返回true, 才会继续下面的执行.
    }
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {}

}
```


* 配置添加该拦截器

```java
@Configuration
public class SomMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    SomeInterceptor someInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(someInterceptor)
                .addPathPatterns("/first/**")
                .excludePathPatterns("/second/**");
    }
}
```

* 被拦截的控制类  

```java
@RestController
public class SomeController {

    @GetMapping("/first/some")
    public String firstHandle() {
        return "first";
    }

    @GetMapping("/second/other")
    public String secondHandle() {
        return "second";
    }
}
```