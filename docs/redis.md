# redis 

## 前言

本文介绍如何在springboot中使用redis,使用redis的步骤如下：

* 在pom文件中添加springboot 与 redis 整合依赖；
* 在主配置文件中注册redis链接信息
* 由于要将查询的实体类对象缓存到redis,redis要求实体类必须要序列化，所以必须实现序列化接口。

