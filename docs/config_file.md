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


## [完整代码]()