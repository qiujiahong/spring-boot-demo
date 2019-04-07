# 多环境配置

## 前言

本文讲诉如何实现多环境下使用不同的配置文件，以及使用不同的代码。


## 操作步骤

* 新建spring 工程

* 修改配置文件application.properties

```prop
#进行多环境选择
spring.profiles.active=dev
# java -jar file.jar --spring.profiles.active=dev
```


* 新建开发环境配置文件``application-dev.properties``    
```
#开发环境

server.port=8888
server.servlet.context-path=/ddd
```

*  新建生产环境配置文件``application-pro.properties``

```
#生成环境
server.port=9999
server.servlet.context-path=/ppp
```


* 应用接口

```java
public interface MsgService {
    String send();
}
```

* 接口实现，开发环境

```java
@Service
@Profile("dev")
public class DevMsgServiceImpl implements MsgService {
    @Override
    public String  send() {
        System.out.println("----------DevMsgServiceImpl-----------");
        return "dev";
    }
}

```

* 接口实现，生产环境 
```java
@Service
@Profile("pro")
public class ProMsgServiceImpl implements MsgService {
    @Override
    public String send() {
        System.out.println("----------ProMsgServiceImpl-----------");
        return "pro";

    }
}

```


## [完整代码](https://github.com/qiujiahong/spring-boot-demo/tree/master/02-multienv)