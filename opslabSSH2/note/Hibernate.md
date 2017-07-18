#Hibernate#
映射对象标识符
Hibernate使用对象标识符（OID）来建立内存中的对象和数据库表中记录的对应关系。对象的OID和数据表的主键对应，<br>
Hibernate通过标识符生成器来为主键赋值。Hibernate推荐在数据表中使用代理主键，既不具备业务含义的字段，代理<br>
主键通常为整数类型，因为整数类型比字符串类型要节省更多的数据库空间在对象-关系映射文件中id元素用来设置对象<br>
标识符。Generator子元素用来设定标识符生成器。Hibernate提供了标识符生成器接口:identifierGenerator并提供<br>
了各种内置对象 

##主键生成策略##
    ```
    <id name="id" type="java.lang.Long">
                <column name="ID" />
               <generator class="native"/>
    </id>
    ```
Id设定持久化类的OID和表的主键的映射<br>
	-name：标识持久化类OID的属性名<br>
	-column：设置标识属性所映射的数据库表的列名（主键字段的名称）<br>
	-unsaved-value：若设定了改属性，Hibernate会通过比较持久化类的OID值和改属性值来分区当前持久化类的对象是否为临时对象<br>
	
-type:指定Hibernate映射类型，hibernate映射类型是Java类型的SQL类型的桥接，如果没有为某个属性显示设定映射类型，<br>
        Hibernate会运用反射机制先识别出持久化类的特定属性的Java类型，然后自动使用与之对应的默认的Hibernate映射类型<br>
-java:基本数据类型和包装对应相同的Hibernate映射类型。基本数据类型无法表达null.所以对于持久化类的OID推荐使用包装类型。<br>
Generator是id的子类，用来设定持久化类设定标识符生气<br>
	-class：指定使用的标识符生成器全限定的类名或其缩写名<br>

##Hibernate提供了内置的生成器##
标识符生成器	描述

	Increment	代理主键。有hibernate自动以递增方式生成
	Identity	代理主键。有底层数据库生成标识符
	Sequence	代理主键。Hibernate根据底层数据库的序列生成标识符，这些要求底层数据库支持序列
	Hilo	    代理主键。Hibernate分局high/low算法生成标识符
	Seqhilo	    代理主键。使用一个高/低位算法来高校的生成long/short类型的标识符
	Native	    代理主键。根据底层数据库对自动生成标识符的方式，自动选用identity	Sequence或hilo
	Uuid.hex	代理主键。Hibernate采用128位的UUID算法生成标识符
	Uuid.string	适用于代理主键。UUID被选编码成一个16字符长的字符串
	Assigned	自然主键。有Java应用程序负责生成标识符
	Foreign	    代理主键。使用另外一个相关的对象的标识符
	
Property
Property元素用于指定类型的属性和表的字段映射

    -name：指定改持久化类的属性名字
    -column：指定与类的属性映射的表的字段名，如果没有设置啊属性，hibernate将值将是哟年类的属性名做为字段
    -type：指定hibernate映射类型。Hibernate映射类型是Java类型与SQL类型的桥梁，如果没有映射没一个属性，hibernate会用反射机制为持久化类的特定属性的Java类型，然后自动使用与质对应的默认的hibernate映射类型
    -not-null：若改属性值为true，表明不允许为null。偶人为falshe
    -access：指定hibernate的默认的属性访问策略。默认值为property既使用getter/setter方法来访问属性。若指定field，则hibernate会忽略getter/setter方法，而通过反射访问成员变量
    -unique：设置是否为该属性所映射的数据列添加唯一约束
    -index：指定一个字符串的索引名称，当系统需要hibernate自动建表时，为该属性映射的数据列表创建索引，从而该加快该数据列的查询
    -length：指定该属性所映射数据列的字段的长度
    -scale：指定该属性所映射数据列的小数位，对double，float，decimal等类型的数据列有效
    -formula：设置一个SQL表达式，hibernate将根据它来计算派生属性的值

Hibernate映射类型	Java类型	标准SQL类型

    integer	        java.lang.Integer	                INTEGER
    long	        java.lang.Long	                    BIGINT
    short	        java.lang.Short	                    SMALLINT
    float	        java.lang.Float	                    FLOAT
    double	        java.lang.Double	                DOUBLE
    big_decimal	    java.math.BigDecimal	            NUMERIC
    character	    java.lang.String	                CHAR(1)
    string	        java.lang.String	                VARCHAR
    byte	        byte或java.lang.Byte	                TINYINT
    boolean	        boolean或java.lang.Boolean	        BIT
    yes_no	        boolean或java.lang.Boolean	        CHAR(1)('Y'或'N')
    true_false	    boolean或java.lang.Boolean	        CHAR(1)('Y'或'N')
    date	        java.util.Date或java.sql.Date	    DATE
    time	        java.util.Date或java.sql.Time	    TIME
    timestamp	    java.util.Date或java.sql.Timestamp	TIMESTAMP
    calendar	    java.util.Calendar	                TIMESTAMP
    calendar_date	java.util.Calendar	                DATE
    binary	        byte[]	                            VARBINARY或BLOB
    text	        java.lang.String	                CLOB
    serializable	java.io.Serializable实例          	VARBINARY或BLOB
    clob	        java.sql.Clob	                    CLOB
    blob	        java.sql.Blob	                    BLOB
    class	        java.lang.Class	                    VARCHAR
    locale	        java.util.Locale	                VARCHAR
    timezone	    java.util.TimeZone	                VARCHAR
    currency	    java.util.Currency	                VARCHAR


Java大对象类型的Hibernate映射
在Java中，java.lang.String可用于表示长字符串(长度超过255)，<br>
字符数组byte[]可以用于存放图片或二进制数据，<br>
此外，在JDBC API中还提供了Java.sql.Clob和java.sql.Blob类型，<br>
它们分别和标准SQL中的CLOB和BLOB类型对应。CLOB表示字符串大对象。BLOB表示二进制大对象<br>
 
实际上在Java应用程序中处理长度超过255的字符串，使用java.lang.String比java.sql.Clob更方便。<br>
Java时间和日期类型Hibernate映射<br>
在java中，代表时间和日期的类型包括：java.util.Date和java.util.Calendar。<br>
此外JDBC按批中还提供3个扩展了Java.util.Date类的子类：java.sql.Date。java.sql.Time和java.sql.Timestamp<br>
这三个类分别和标准的SQL类型中的DATE，time和timestamp类型对应<br>
 
##使用Hibernate内置映射类型##
以下情况必须显示指定hibernate映射类型<br>
	一个java类型可能对应多个hibernate映射类型。<br>
	例如：如果持久化类的属性为：java.Util.Date，对应的hibernate映射类型可以是data，<br>
	time或timestamp，此时必须根据对应的数据表的字段的SQL类型，来确定hibernate映射类型，<br>
	如果字段为date类型，那么hibernate映射类型为date；如果字段为time类型，<br>
	那么hibernate映射类型为time，如果字段为TIMESTATMP类型，那么hibernate映射类型为timestamp<br>
例如：

    ```
    package hibernate3.POJO;
    import java.sql.Blob;
    import java.sql.Date;
    import java.sql.Timestamp;
    public class CustomerVO {
        private long id;
        private String name;
        private char sex;
        private int  phoneNum;
        private boolean married;
        private String descript;
        private Blob image;
        private Date birthday;
        private Timestamp regeditTime;
        //getter/setter
    }
    
    <!--Hibernate映射文件配置-->
    <?xml version="1.0"?>
    <!DOCTYPE hibernate-mapping PUBLIC
    	"-//Hibernate/Hibernate Mapping DTD 3.0//EN"
    	"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
    
    <hibernate-mapping package="hibernate3.POJO">
    
    	<class name="CustomerVO" table="hbm_tbl_customer">
    
    		<id name="id" column="recordid">
    			<generator class="native" />
    		</id>
    
    		<property name="name" column="name" type="java.lang.String"></property>
    
    		<property name="sex" column="sex" type="character"></property>
    
    		<property name="phoneNum" column="phone_num" type="java.lang.Integer"></property>
    
    		<property name="married" column="married" type="java.lang.Boolean"></property>
    
    		<property name="descript" column="descript" type="java.lang.String"></property>
    
    		<property name="image" column="image" type="java.lang.String"></property>
    
    		<property name="birthday" column="birthday" type="java.sql.Date"></property>
    
    		<property name="regeditTime" column="regidt_time" type="java.sql.Timestamp"></property>
    	</class>
    
    </hibernate-mapping>
    ```


    ```
    package hibernate3.CoreTest;
    import java.sql.Date;
    import java.sql.Timestamp;
    import hibernate3.POJO.CustomerVO;
    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import org.hibernate.Transaction;
    import org.hibernate.cfg.Configuration;
    import org.junit.After;
    import org.junit.Before;
    import org.junit.Test;
    public class ConfigFileTest {
        Configuration configuration;
        SessionFactory sessionFactory;
        Session session;
        Transaction tx;
        @Before
        public void before(){
            configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
        }
        @After
        public void after(){
            tx.commit();
            session.close();
            sessionFactory.close();
        }
        @Test
        public void testConfigFile() {
            CustomerVO obj = new CustomerVO();
            obj.setName("hibernate3");
            obj.setSex("男".charAt(0));
            obj.setMarried(false);
            obj.setPhoneNum(13122223333);
            obj.setBirthday(Date.valueOf("2000-01-01"));
            obj.setRegeditTime(new Timestamp(new java.util.Date().getTime()));
            session.save(obj);
        }
    }
    ```
##映射组成关系##

建立域模型和关系数据模型有着不同的出发点：
	-域模型：由程序代码组成，通过细化持久化类的粒度可提供代码的可重用性，简化编程
	-关系数据模型：由关系数据组成，在存在数据冗余的情况下，需要把粗粒度的表表分成具有外键参照关系的几个细粒度的表，从而节省存储空间。另外一方面，在没有数据冗余的情况下，应该尽量减少表的数目，简化表之间的参照关系，以便提供数据的访问速度。

Hibernate把持久化类的属性分为俩中：
-值（value）类型：没有OID不能被单独持久化，生命周期依赖于所属的持久化类的对象的生命周期
-实体（entity）类型：有OID可以被单独持久化，有独立的生命周期

无法直接用propperty映射name属性。Hibernate使用<component>元素来映射成组的关系。
Component元素用来映射组成关系，常用的属性：
	-name
	-access
	-class:设定组成关系属性的类型
	-insert=”true”
	-lazy=”false”
	-node
	-optimistic-lock=”true”
	Parent元素指定组成属性所属的整体类
例如：
 
	<component name="pay" class="pay">
		<parent name="worker"/>
	
		<property name="monthlyPay" column="month_pay" type="integer"></property>
		<property name="vocationWithPay" column="vocation_with_pay" type="integer"></property>
		<property name="yearPay" column="year_pay" type="integer"></property>
	</component>
	

