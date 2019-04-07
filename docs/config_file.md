# 读取配置文件


## 在application.properties中读取自定义属性

* application.properties 

```
#
server.port=8888
server.servlet.context-path=/nick


# 自定义属性

company.name=xxx company.
```

* 注入使用

```java
    @Value("${company.name}")
    private String companyName;
```


## 在自定义文件


* custom.properties

```
city.name=深圳.
```

* 注入引用  

```java

@RestController
@PropertySource(value = "classpath:custom.properties",encoding = "UTF-8") //如果有汉字使用该方式
//@PropertySource("classpath:custom.properties")
public class SomeController {


    @Value("${city.name}")
    private String cityName;

    @GetMapping(value = "/city")
    public String getCity(){
        return "hello "+ cityName;
    }

}
```

## 对象配置

* custom.properties

```java
student.name=张三
student.age=20
student.score=96.7
```

* 对象StudentDto.java

```java
@Data
@Component
@PropertySource("classpath:custom.properties")
@ConfigurationProperties("student")
public class StudentDto {
    private String name;
    private int age;
    private double score;
}

```

* 引用

```java

@RestController
@PropertySource(value = "classpath:custom.properties",encoding = "UTF-8") //如果有汉字
//@PropertySource("classpath:custom.properties")
public class SomeController {
    @Autowired
    StudentDto studentDto;

    @GetMapping(value = "/student")
    public StudentDto getStudent(){
        return  studentDto;
    }

}

```

## [完整代码](https://github.com/qiujiahong/spring-boot-demo/tree/master/04-readconfig)