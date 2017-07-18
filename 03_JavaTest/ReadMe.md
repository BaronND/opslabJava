#JTest

    Java相关的组件测试.
    
#SDE
    Win7x64
    IDEA14
    JDK1.7
    ENCODING:UTF-8
    
    
#JFreechart
JfreeChart是一个开源的Java项目，它主主要用来生成各种各样的图表，
这些图表包括：饼图，柱状图，线图，区域图，分布图，混合土以及一些仪表盘等。
它的源码和 API 都可以免费获得。 JFreeChart 的功能非常强大，可以实现饼图 柱状图 ， 线图 
点图 , 时序图 , 甘特图 ,股票行情图 , 混和图 , 温度计图 , 刻度图等常用商用图表，
图形可以导出成 PNG 和 JPEG 格式，同时还可以与 PDF 和 EXCEL 关联，
支持对图形的放大、缩小，支持常见图形的 3D 显示。

利用JFreeChart绘图其实就是简单的俩步：
    1.创建JFreeChart对象
        如：
        ```java
        JFreeChart chart=ChartFactory.
            createPieChart(
                String title, 
                PieDataset dataset,
                boolean legend, 
                boolean tooltips, 
                boolean urls);
        ```        
    2.将JFreeChar对象转为图片
        ```java
        ChartUtilities.saveChartAsJPEG(file, chart, 400, 300);
        ```
        
=饼图=
饼图需要的数据集
```java
    DefaultPieDataset ds = new DefaultPieDataset();
    ds.setValue("C/C++", 27);
    ds.setValue("Java", 18);
    ds.setValue("object-c",10);
    ds.setValue("C#", 6);
    ds.setValue("PHP", 4);
    ds.setValue("vb", 4);
    ds.setValue("Python", 4);
    ds.setValue("SQL", 4);
    ds.setValue("Javascript", 4);
    ds.setValue("Ruby", 2);
```    
        
# ApachePOI
Apache POI是一种流行的API，它允许程序员使用Java程序创建，修改和显示MS Office文件
这由Apache软件基金会开发使用Java分布式设计或修改Microsoft Office文件的开源库。它
包含类和方法对用户输入数据或文件到MS Office文档进行解码。

# JSqlParser
项目主页:https://github.com/JSQLParser/JSqlParser

一个可以使用Java解析SQL语句的类库

# FreeMarker
项目主页:http://freemarker.incubator.apache.org/

FreeMarker是一个用Java语言编写的模板引擎，它基于模板来生成文本输出。FreeMarker与Web
容器无关，即在Web运行时，它并不知道Servlet或HTTP。它不仅可以用作表现层的实现技术，而
且还可以用于生成XML，JSP或Java 等。

# Guava
项目主页:
    http://code.google.com/p/guava-libraries
    https://github.com/google/guava

Guava 是一个 Google 的基于java1.6的类库集合的扩展项目，包括 collections, caching,
primitives support, concurrency libraries, common annotations, string processing,
I/O, 等等. 这些高质量的 API 可以使你的JAVa代码更加优雅，更加简洁，让你工作更加轻松愉悦。

# apache commons-dbutils
项目主页:http://commons.apache.org/proper/commons-dbutils/

Commons DbUtils是Apache组织提供的一个对JDBC进行简单封装的开源工具类库，使用它能够简化
JDBC应用程序的开发，同时也不会影响程序的性能

# Jodd
项目主页:https://github.com/oblac/jodd/

是一个开源的 Java 工具集， 包含一些实用的工具类和小型框架。简单，却很强大！

# netty
项目主页:
    http://netty.io/
    https://github.com/netty/netty

Netty是由JBOSS提供的一个java开源框架。Netty提供异步的、事件驱动的网络应用程序框架和工具，
用以快速开发高性能、高可靠性的网络服务器和客户端程序。
    
    