# thymeleaf

Spring2中默认使用的是thymeleaf3.x

## 使用

* 加入依赖


```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
```


* 添加控制类

```java
@Controller
public class ThymeleafController {

    @RequestMapping("/")
    public String indexHandle(Model model){
        model.addAttribute("name","nick");
        model.addAttribute("student",new StudentVO("nick",12));
        return "index";
    }
}
```


* 编写前端页面

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="https://www.thymeleaf.org/">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<p th:text="${name}">现在显示的是静态数据</p>
<div th:text="${wangshang}">现在显示的是静态数据</div>
<span th:text="${zhongguo}">现在显示的是静态数据</span>

<br>
<div th:object="${student}">
    <p>姓名: <span th:text="*{name}"></span></p>
    <p>年龄: <span th:text="*{age}"></span></p>
</div>
</body>
</html>
```

## [官网](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)

## [完整代码](https://github.com/qiujiahong/spring-boot-demo/tree/master/10-thymeleaf)