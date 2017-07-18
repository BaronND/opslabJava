# Spring Boot and Spring Cloud

## 工程说明

* spring-mybatis-service    //Spring Boot mybatis
* SpringBootStu             //Spring Boot Demo
* SpringCloud               //Spring Cloud Demo
* SpringCloudConsumer       //Spring Cloud Service Consumer
* SpringCloudEurekaService  //Spring Cloud EurekaService
* SpringCloudServiceProducer//Spring Cloud Producer
* SpringConfigService       //Spring Config Service

## SpringCloud分部署开发五大神兽

* 服务发现  Netfix Eureka
  一个RESTful服务，用来定位运行在AWS地区（Region）中的中间层服务，由俩个组件组成：Eureka服务器和Eureka客户端。
  Eureka服务器用作服务器，Eureka客户端是一个Java客户端，用来简化与服务器的交互，作为轮询负载均衡器。
* 客服端负载均衡 Netfix Ribbon
  Ribbon主要提供客户侧的负载均衡算法
* 断路器 Netfix Hystrix
  断路器可以防止一个应用程序多次试图执行一个操作。
* 服务网关 Netfix Zuul
  类似nginx，反向代理的功能，不过netflix自己增加了一些配合其他组件的特性。
* 分布式配置 SpringCloudConfig
  这个还是静态的，得配合Spring Cloud Bus实现动态的配置更新。