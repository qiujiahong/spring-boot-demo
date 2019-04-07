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

## List<String>属性


* custom.properties

```java
country.cities[0]=北京
country.cities[1]=shanghai
country.cities[2]=南京
```

* 对象 CountryDto

```java
@Data
@Component
@PropertySource(value = "classpath:custom.properties",encoding = "UTF-8")
@ConfigurationProperties("country")
public class CountryDto {
    private List<String > cities;
}
```

* 注入  

```java
   @Autowired
    private CountryDto countryDto;

    @GetMapping(value = "/country")
    public CountryDto getCountry(){
        return  countryDto;
    }
```


## List<Object>


*  custom.properties

```
group.users[0].name=zhangsan
group.users[0].age=23
group.users[1].name=lisi
group.users[1].age=25
group.users[2].name=wangwu ww
group.users[2].age=30
```

* 对象  

```java
@Data
@Component
@PropertySource(value = "classpath:custom.properties",encoding = "UTF-8")
@ConfigurationProperties("group")
public class GroupDto {
    List<User> users;
}
```

```java
@Data
public class User {
    private String name;
    private int age;
}

```

* 注入使用

```java

    @Autowired
    private GroupDto groupDto;

    @GetMapping(value = "/group")
    public GroupDto getGroup(){
        return  groupDto;
    }
```

## [完整代码](https://github.com/qiujiahong/spring-boot-demo/tree/master/04-readconfig)