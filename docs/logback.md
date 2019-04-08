# 添加logback

在spring-boot-starter-web中已经加了该依赖。


可在resources下添加logback.xml文件，内容如下:  


```xml
<?xml version="1.0" encoding="UTF-8" ?>
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%-5level - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="WARN">
        <appender-ref ref="STDOUT" />
    </root>
    <logger name="com.nick.jspdemo.dao" level="DEBUG" />
</configuration>
```


* logback实现文件输出，并且日志分割

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration scan="true" scanPeriod="10 seconds" debug="false">

    <!--<jmxConfigurator/>-->
    <!-- 定义日志文件 输出位置 -->
    <!--<property name="log_dir" value="/Users/fangle/Desktop/work/projects/URPCSF0009.0/logs"/>-->
    <!-- 日志最大的历史 天 -->
    <property name="maxHistory" value="10"/>

    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} %-5level [%thread] %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <appender name="TIME_BASED_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${catalina.home}/logs/pms.log</file>
        <!--<file>${log_dir}/pms.log</file>-->
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${catalina.home}/logs/pms.%d{yyyy-MM-dd}.log.gz</fileNamePattern>
            <maxHistory>${maxHistory}</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} %-5level [%thread] %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>


    <logger name="org.apache.mina">
        <level value="ERROR" />
        <appender-ref ref="TIME_BASED_FILE"/>
    </logger>


    <logger name="com.nick.logbackdemo">
        <level value="DEBUG" />
        <appender-ref ref="TIME_BASED_FILE"/>
    </logger>

    <root level="debug">
        <appender-ref ref="STDOUT"/>
        <appender-ref ref="TIME_BASED_FILE"/>
    </root>
</configuration>
```