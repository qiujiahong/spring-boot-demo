# servlet

## 前言

在spring boot中使用servlet可以使用注解方式，也可以使用配置文件方式。


## 注解方式

* 定义servlet类  

```java
@WebServlet(name = "/some")
public class SomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.getWriter().println("Hello servlet");
    }
}

```

* 配置扫码servlet的包   

```java
@SpringBootApplication
@ServletComponentScan("com.nick.primary.servlet")//开启servlet扫描
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
```