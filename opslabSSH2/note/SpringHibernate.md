#Spring整合Hibernate#
时至今日，Java EE通常都会面向对象的方式来操作关系数据库，都会采用ORM框架来完成这一功能，其中Hiernate以其灵巧，<br>
轻便的封装赢得了准多开发者的青睐。Spring以良好的开放性，能与大部分发ORM框架良好整合。<br>


##Spring提供的DAO支持##

DAO模式是一种标准的Java EE设计模式，DAO模式的核心思想是：所有的数据库访问，都通过DAO组建完成，<br>
DAO组建封装了数据库的增、删、改等原子操作。<br>
对于Java EE应用的架构，有非常多的选择，但不管细节如何变换。Java EE应用都大致可分为如下三层：<br>
<pre>
	表现层<br>
	业务逻辑层<br>
	数据持久层<br>
</pre>
轻量级Java EE框架以Spring Ioc容器为核心，承上启下，相上管理来自表现层的Action，下下管理业务逻辑层组建，
同时负责业务逻辑层所需的DAO对象。DAO组建是整个Java EE应用的持久层访问的重要组件，<br>
每个Java EE应用的底层实现都难以离开DAO组件的支持。Spring对实现DAO组件提供了许多工具类，<br>
系统的DAO组件可以继承这些工具类完成，从而可以更简单的实现DAO组件Spring提供了一系列的抽象类，<br>
这些抽象类将被作为应用中DAO实现的父类，通过继承这些抽象类，spring简化DAO的开发不足，<br>
能以一致的方式使用数据库访问技术。不管底层采用JDBC、JDO还是Hibernate。<br>
就Hibernate的持久层访问技术而言，spring提供了如下三个工具类（或接口）来支持DAO组件的实现:<br>
<pre>
	HibernateDaoSupport<br>
	HibernateTemplate<br>
	HibernateCallback<br>
</pre>
管理Hibernate的SessionFactory当通过Hibernate进行持久层访问时，必须先获得SessionFactory对象。<br>
它是单个数据库映射关系编译后的内存镜像。大部分情况下，一个JavaEE应用对应一个数据库，即对应一个SessionFactory对象<br>
Spring的IoC容器正好提供了这种管理方式，它不仅能以声明式的方式配置SessionFactory实例，也可以为SessionFactory注入数据源。<br>
例如：<br>

    ```
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
        <!-- 配置Spring数据源 Oracle10g -->
        <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
            <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></property>
            <property name="url" value="jdbc:oracle:thin:@localhost:1521:orcl"></property>
            <property name="username" value="scott"></property>
            <property name="password" value="tiger"></property>
        </bean>
        <!-- 定义Hibernate的SessionFactory -->
        <bean id="sessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
            <property name="dataSource" ref="dataSource"/>
            <!-- mappingResources属性用来列出全部映射文件 -->
            <property name="mappingResources">
                <list>
                    <!-- 以下用来列出所有的PO映射文件 -->
                    <value>conf/hbm/User.hbm.xml</value>
                </list>
            </property>
             <!-- 定义Hibernate的SessionFactory属性 -->
            <property name="hibernateProperties">
                 <props>
                    <!-- 指定Hibernate的连接方言 -->
                    <prop key="hibernate.dialect">
                        org.hibernate.dialect.Oracle9Dialect
                    </prop>
                    <!-- 配置启动应用时，是否根据Hibernate映射自动创建数据表 -->
                    <prop key="hibernate.hbm2ddl.auto">update</prop>
               </props>
            </property>
        </bean>
    </beans>
    ```
    
一旦在Spring的IoC容器中配置了SessionFactory Bean，它将随应用的启动而加载，并可以充分利用IoC容器的功能，<br>
将SessionFactory Bean注入任何bean。<br>
比如DAO组件，一旦DAO组件获得了SessionFactory Bean的引用，就可以完成实际的数据库访问。<br>

##使用HibernateTemplate##
HibernateTemplate提供持久层访问模板化，它需要提供一个SessionFactory的引用，就可执行持久化操作。<br>
SessionFactory对象既可通过构造参数传入，也可以通过设值方式传入，HibernateTemplate提供如下三个构造函数：<br>
<pre>
    	HibernateTemplate():构造一个默认的HibernateTemplate实例，因此创建了HibernateTemplate实例之后，<br>
                    还必须使用setSessionFactory(SessionFactory sf)为HibernateTemplate注入SessionFactory对象，<br>
                    然后才可以进行持久化操作。<br>
    	HibernateTemplate(org.hibernate.SessionFactory sessionFactory)在构造时已经传入SessionFactory对象，<br>
                    创建后立即可以执行持久化操作。<br>
    	HibernateTemplate(org.hibernate.SessionFactory sessionFactory,Boolean allowCreate):
                    <br>allowCreate参数表明，如果当前线程没有找到一个事务性的Session，<br>
                    是否需要创建一个非事务的Session<br>
</pre>
例如：

    ```
    package spring3.impl;
    import org.springframework.orm.hibernate3.HibernateTemplate;
    import hibernate3.POJO.VO_user;
    import spring3.dao.PersonDao;
    public class PersonDaoImpl implements PersonDao{
        //使用Spring注入HibernateTemplate的一个实例
        private HibernateTemplate hibernateTemplate;
        public HibernateTemplate getHibernateTemplate() {
            return hibernateTemplate;
        }
        public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
            this.hibernateTemplate = hibernateTemplate;
        }
        @Override
        public void save(VO_user vo) {
            this.hibernateTemplate.save(vo);
        }
        @Override
        public void delete(VO_user vo) {
            this.hibernateTemplate.delete(vo);
        }
        @Override
        public VO_user getUserByID(long id) {
            return this.hibernateTemplate.get(VO_user.class, id);
        }
    }
    ```
    
利用spring进行注入

    ```
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.springframework.org/schema/beans"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
        <!-- 配置Spring数据源 Oracle10g -->
        <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
            <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></property>
            <property name="url" value="jdbc:oracle:thin:@localhost:1521:orcl"></property>
            <property name="username" value="scott"></property>
            <property name="password" value="tiger"></property>
        </bean>
        <!-- 定义Hibernate的SessionFactory -->
        <bean id="sessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
            <property name="dataSource" ref="dataSource"/>
            <!-- mappingResources属性用来列出全部映射文件 -->
            <property name="mappingResources">
                <list>
                    <!-- 以下用来列出所有的PO映射文件 -->
                    <value>conf/hbm/User.hbm.xml</value>
                </list>
            </property>
             <!-- 定义Hibernate的SessionFactory属性 -->
            <property name="hibernateProperties">
                 <props>
                    <!-- 指定Hibernate的连接方言 -->
                    <prop key="hibernate.dialect">
                        org.hibernate.dialect.Oracle9Dialect
                    </prop>
                    <!-- 配置启动应用时，是否根据Hibernate映射自动创建数据表 -->
                    <prop key="hibernate.hbm2ddl.auto">update</prop>
               </props>
            </property>
        </bean>
        <bean id="hibernateTemplate" class="org.springframework.orm.hibernate3.HibernateTemplate">
            <property name="sessionFactory" ref="sessionFactory"></property>
        </bean>
        <!-- 配置一个Person操作 -->
        <bean id="person" class="spring3.impl.PersonDaoImpl">
            <property name="hibernateTemplate" ref="hibernateTemplate"></property>
        </bean>
    </beans>
    ```

#HibernateTemplate提供的核心方法#
    
HibernateTemplate提供很多实用的方法来完成基本的操作，比如增加、删除、修改、查询等操作。<br>
大部分情况下，通过HibernateTemplate如下的方法就可以完成大多数DAO对象的CRUD操作。<br>

    	void delete(Object entity):  删除指定持久化实例
    	deleteAll(Collection entitles)：删除集合内全部持久化类实例
    	find(String queryString)：根据HQL查询字符串来返回实例集合的系列重载方法
    	findByNameQuery(String queryName)：根据命名查询返回实例集合的系列重载方法
    	get(Class entityClass,Serializable id)：根据主键加载特定持久化类的实例
    	save(Object entity)：保存新的实例
    	saveOrUpdate(Object entity)：根据实例状态，选择保存或更新
    	update(object entity)：更新实例的状态，要钱entity是持久状态
    	setMaxResults(int maxResults)：设置分页的大小


#使用HibernateCallback#
使用HibernateTemplate进行数据库访问十分方便，但不是什么时候都未必好用。<br>
为了避免HibernateTemplate灵活性不足的缺陷，HibernateTemplate还提供一种更加灵活的方式来操作数据，<br>
通过这种方式可以完全使用Hibernate的操作方式。HibernateTemplate的灵活访问方式通过如下俩个方法来完成。<br>

    	Object execute(HibernateCallback action)
    	List executeFind(HibernateCallback action)
    
这俩个方法都需要一个HibernateCallback实例，HibernateCallback，<br>
实例可在任何有效的Hibernate数据库访问中使用。程序开发者通过HibernateCallback<br>
可以完全使用Hibernate灵活的方式来访问数据库，解决Spring封装Hibernate后灵活性不足的缺陷

