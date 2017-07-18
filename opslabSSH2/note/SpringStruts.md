#Spring整合Struts#
整合Spring和Struts其实就是适用Spring的IOC容器管理Struts2的Action。
首先将相应的Jar文件复制到Web/lib目录下，记得复制struts2-spring-plugin-xxx.jar文件。
在web.xml文件中配置struts2

    ```
    <filter>
    <filter-name>struts2</filter-name> 
    <filter-class>
    org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter
    </filter-class>
    </filter>
    <filter-mapping>
    <filter-name>struts2</filter-name>
    <url-pattern>/*</url-pattern>
    </filter-mapping>
    ```
    
新建struts的配置文件struts.xml
    ```
    <struts>
    <constant name="struts.enable.DynamicMethodInvocation" value="false" />
    <constant name="struts.devMode" value="true" />
    <package name="default" namespace="/" extends="struts-default">
    </package>
    </struts>
    ``
在web.xml文件中配置spring

    ```
    //配置 Spring 配置文件的位置
    <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
    </context-param>
    //配置启动 IOC 容器的 Listener
    <listener>
    <listener-class>
    org.springframework.web.context.ContextLoaderListener
    </listener-class>
    </listener>
    ```
1.在 Spring 的配置文件中配置 Struts2 的 Action 实例，注意：需要
配置 scope 属性为 prototype，因为 Struts2 的 Action 不是单例的！
例如：
    ```
    <bean id="userAction" 
    class="com.atguigu.ss.action.UserAction" scope="prototype">
    <property name="userService" ref="userService"></property>
    </bean>
    ```
    
2.  在  Struts 配置文件中配置 action, 但其 class 属性不再指向该
Action 的实现类, 而是指向 Spring 容器中 Action 实例的 ID
例如：

    ```
    <action name="helloworld" class="userAction">
    <result>/success.jsp</result>
    </action>
    ```

##原理##
Spring 插 件 是 通 过 覆 盖 Struts2 的
ObjectFactory 来增强核心框架对象的创建。当创建一个对象的时候，它会用
Struts2 配置文件中的 class 属性去和 Spring 配置文件中的 id 属性进行关联，
如果能找到， 则由 Spring 创建， 否则由 Struts 2 框架自身创建， 然后由 Spring
来装配。

##通过Spring AOP配置业务层事务##

    ```
        <?xml version="1.0" encoding="UTF-8"?>
        <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:tx="http://www.springframework.org/schema/tx"
            xmlns:context="http://www.springframework.org/schema/context"
            xmlns:aop="http://www.springframework.org/schema/aop"
            xsi:schemaLocation="http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.0.xsd
                http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd
                http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.0.xsd">
    
    
        <!-- 通过context指定外部引用的属性文件 -->
        <context:property-placeholder location="classpath:db.properties" />
    
        <!-- 配置Spring数据源 -->
        <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
            <property name="driverClass" value="${jdbc.driverClassName}" />
            <property name="jdbcUrl" value="${jdbc.url}" />
            <property name="user" value="${jdbc.username}" />
            <property name="password" value="${jdbc.password}" />
    
            <property name="maxPoolSize" value="${c3p0.pool.size.max}" />
            <property name="minPoolSize" value="${c3p0.pool.size.min}" />
            <property name="initialPoolSize" value="${c3p0.pool.size.ini}" />
            <property name="acquireIncrement" value="${c3p0.pool.size.increment}" />
        </bean>
    
    
        <!-- 定义Hibernate的SessionFactory -->
        <bean id="sessionFactory"
            class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
            <property name="dataSource" ref="dataSource" />
            <property name="mappingLocations">
                <list>
                    <value>classpath:hbm/*.hbm.xml</value>
                </list>
            </property>
            <property name="hibernateProperties">
                <props>
                    <prop key="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</prop>
                    <prop key="hibernate.show_sql">true</prop>
                    <prop key="hibernate.format_sql">false</prop>
                    <prop key="hibernate.hbm2ddl.auto">update</prop>
                    <prop key="hibernate.current_session_context_class">thread</prop>
                    <prop key="hibernate.use_sql_comments">false</prop>
                    <prop key="hibernate.temp.use_jdbc_metadata_defaults">false</prop>
                    <prop key="hibernate.current_session_context_class">org.springframework.orm.hibernate4.SpringSessionContext</prop>
                    <prop key="javax.persistence.validation.mode">none</prop>
                    <!-- <prop key="hibernate.cache.provider_class">net.sf.ehcache.hibernate.EhCacheProvider</prop> 
                        <prop key="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</prop> -->
                    <!-- <prop key="hibernate.cache.provider_class">net.sf.ehcache.hibernate.EhCacheProvider</prop> 
                        <prop key="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</> -->
                    <!-- 配置二级缓存 -->
                    <!-- <prop key="hibernate.cache.use_second_level_cache">true</prop> <prop 
                        key="hibernate.cache.provider_class">org.hibernate.cache.EhCacheProvider</prop> 
                        <prop key="hibernate.cache.use_query_cache">true</prop> 这个一定要配上，不然可能会出错 <prop 
                        key="hibernate.cache.provider_class">org.hibernate.cache.HashtableCacheProvider</prop> -->
                </props>
            </property>
        </bean>
    
        <!-- 配置hibernteTemplate -->
        <bean id="hibernateTemplate" class="org.springframework.orm.hibernate4.HibernateTemplate">
            <property name="sessionFactory" ref="sessionFactory"></property>
        </bean>
    
        <!-- 管理事务(JDBC局部事务管理策略) -->
        <bean id="transactionManager"
            class="org.springframework.orm.hibernate4.HibernateTransactionManager">
            <property name="sessionFactory" ref="sessionFactory" />
        </bean>
    
        <!-- 配置事务通知属性 -->
        <tx:advice id="txAdvice" transaction-manager="transactionManager">
            <!-- 定义事务传播属性 -->
            <tx:attributes>
                <tx:method name="get*" propagation="REQUIRED" read-only="true" />
                <tx:method name="find*" propagation="REQUIRED" read-only="true" />
                <tx:method name="load*" propagation="REQUIRED" read-only="true" />
                <tx:method name="*" propagation="REQUIRED" />
            </tx:attributes>
        </tx:advice>
    
        <!-- 配置事务切入点, 再把事务属性和事务切入点关联起来 -->
        <aop:config>
            <aop:pointcut expression="execution(* app.service.*.*(..))"
                id="txPointcut" />
            <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointcut" />
        </aop:config>
    
        <!-- 业务层的日志记录器 -->
        <bean id="serviceAopLog" class="app.service.interceptor.ServiceIntercetor" />
    
        <aop:config>
            <!-- 事务切入 -->
            <aop:advisor advice-ref="txAdvice" pointcut="execution(* *..*ServiceImpl.*(..))" order="2" />
    
            <!-- 日志切入 -->
            <aop:aspect id="serviceAopLog" ref="serviceAopLog" order="1">
                <aop:around pointcut="execution(* *..*ServiceImpl.*(..)) and !bean(businessLogService)" method="logAop" />
            </aop:aspect>
        </aop:config>
    </beans>
    ```
