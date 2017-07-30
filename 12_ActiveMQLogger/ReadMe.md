# ActiveMQ安装
下载并解压ActiveMQ，之后进入bin目录执行如下命令即可启动activemq,启动后可以通过web进入后台管理http://ip:8161/admin/
```bash
//普通启动
$ activemq start
//后台启动
$ nohup ./activemq start
```
检查已经启动
 ActiveMQ默认采用61616端口提供JMS服务，使用8161端口提供管理控制台服务，执行以下命令以便检验是否已经成功启动ActiveMQ服务。
```bash
//打开端口
$ nc -lp 61616 &
//查看哪些端口被打开 
$ netstat -anp
//查看61616端口是否打开
$ netstat -an | grep 61616
```

# PTP模式实例
PTP(Point-to-Point)模型是基于队列(Queue)的,对于PTP消息模型而言,它的消息目的是一个消息队列(Queue),
消息生产者每次发送消息总是把消息送入消息队列中,消息消费者总是从消息队列中读取消息.先进队列的消息将先被消
息消费者读取.

下面的代码演示了一个消息发送者，俩个消息处理着
```java
# 向activiemq中发送消息
com.opslab.activemq.Sender
# 从activemq中取出消息
com.opslab.activemq.Receiver
com.opslab.activemq.Receiver2
```

# PUB/SUB模式
JMS Pub/Sub 模型定义了如何向一个内容节点发布和订阅消息,这些节点被称作主题(topic). 
主题可以被认为是消息的传输中介,发布者(publisher)发布消息到主题,订阅者(subscribe) 从主题订阅消息.
主题使得消息订阅者和消息发布者保持互相独立,不需要接触即可保证消息的传送. 

下面的代码演示一个消息发布者，俩个消息订阅者
```java
# 消息发布者
com.opslab.activemq.Pub
# 消息订阅者
com.opslab.activemq.Sub
```