## MyBatis
MyBatis官方的[文档](http://www.mybatis.org/mybatis-3)

# SQL映射的XML
Mybatis的有点就在于映射语句中，可以通过注解或者XML文件能减少代码的编写。下面是一些常用的xml配置当然也有对应的注解
> * cache   配置给定命名空间的缓存
> * cache-ref 从其他命名空间引用缓存配置
> * resultMap 最复杂也是最有用的元素，用来描述如何从数据库查询结果到你预想对象直接转换
> * sql  可以重用的SQL块，也可以被其他语句引用
> * insert 映射插入语句
> * update 映射更新语句
> * delete 映射删除语句
> * select 映射查询语句

## select
select的语法如下所示,当然很多值都用默认的值，不需要过的的设置
```xml
<select
  id="selectPerson"             # 在命名空间中位移的标示符，可以被用来引用这条语句
  parameterType="int"           # 将会传入这条语句的参数类型
  parameterMap="deprecated"     # 已经不适用
  resultType="hashmap"          # 配置期望返回的类型，应该是集合可以包含的类型，
                                # 而不是集合本身 resultType 或resultMap不能同时使用
  resultMap="personResultMap"   # 命名引用外部的resultMap。
  flushCache="false"            # 将其设置为true,无论语句什么时候被调用都会清空缓存
  useCache="true"               # 这个设置将会导致本条语句的结果被缓存。
  timeout="10000"               # 设置超时时间
  fetchSize="256"               # 暗示驱动程序每次批量返回的结果行数
  statementType="PREPARED"      # 该值有STATEMENT,PREPARED和CALLABLE
                                # 对应statemen/preparedstatement/callableStatemen
  resultSetType="FORWARD_ONLY">
```

## insert update delete
```xml
<insert
id="insertAuthor"
parameterType="domain.blog.Author"
flushCache="true"
statementType="PREPARED"
keyProperty=""
useGeneratedKeys=""
timeout="20000">
<update
id="insertAuthor"
parameterType="domain.blog.Author"
flushCache="true"
statementType="PREPARED"
timeout="20000">
<delete
id="insertAuthor"
parameterType="domain.blog.Author"
flushCache="true"
statementType="PREPARED"
timeout="20000">
```
## LIKE的写法
mybatis like查询官方文档没有明确的例子，网上很多的说法都是错的不可行，下面是在mybatis3.2.6上可行的几种写法
```java
select * from person where name  like "%"#{name}"%"
select * from person where name  like '%'||#{name}||'%'
select * from person where name  like '%${name}%'
```

## 动态语句
有时候可能根据不同的参数值执行不同的sql，如果按照原始JDBC方式只是一件非常繁琐的事情。为此MyBatis提供一些可配置的动态SQL写法

### if
if语句可以说是任何编程语言的基础，此处也不例外想要使用使用动态SQL掌握语句是不可能少的。下面是一个实例
```xml
<!--
    根据用户编码查询得到一个user对象
    -->
    <select id="userNameLike" parameterType="java.util.Map"
            resultType="com.opslab.mybatis.model.UserInfo">
        select * from t_userinfo
        <where>
            <if test ='name != null '>
                and name  like "%"#{name}"%"
            </if>
            <if test="status != null ">
                and status = #{status}
            </if>
        </where>
    </select>


    <!--update
        使用set和if组合成
    -->
    <update id="update" parameterType="java.util.Map">
        update t_userinfo
        <set>
            <if test=" name != null ">
                name = #{name}
            </if>
            <if test="nick != null">
                ,nick = #{nick}
            </if>
        </set>
        where id = #{id}
    </update>
```

### choose when otherwise
又是if语句虽然能胜任，但是却显得不够优雅，因此很多语言中提供了类似switch的语法，mybatis中也同样提供了类似的语法choose
下面是一个使用choose配置动态sql的例子
```xml
    <select id="userNameLike" parameterType="java.util.Map"
            resultType="com.opslab.mybatis.model.UserInfo">
        select * from t_userinfo where 1=1
        <choose>
            <when test ='name != null '>
                and name  like "%"#{name}"%"
            </when>
            <when test="status != null ">
                and status = #{status}
            </when>
            <otherwise>
                and 1=2
            </otherwise>
        </choose>
    </select>
```

### foreach
foreach可以迭代一个集合，通常是构建在in条中。下面是一个使用foreach的实例
```xml
    <select id="userNameLike" parameterType="java.util.Map"
            resultType="com.opslab.mybatis.model.UserInfo">
        select * from t_userinfo
        <where>
            id IN
            <foreach collection="list" item="item"  index="index" open ="(" separator="," close=")">
                #{item}
            </foreach>
        </where>
    </select>
```

## parameters
mybatis中的参数是非常强大的元素。绝大多数情况下可以像如下只用简单类型即可,如下所示传递一个int类型的参数
```xml
<select id=”selectUsers” parameterType=”int” resultType=”User”>
select id, username, password
from users
where id = #{id}
</select>
```
当然也可以像下面一样使用，当传入User类型的参数对象到语句中，id,username和password属性将会被自动查找替换传入预处理语句中
```xml
<insert id=”insertUser” parameterType=”User” >
insert into users (id, username, password)
values (#{id}, #{username}, #{password})
</insert>
```



## 字符串替换
默认情况下，使用#{}格式语法会让mybatis创建预处理语句属性并以其设值，进行查询。有时候只想插入一个不改变的字符串，如
ORDER BY,你可以这样使用
```sql
ORDER BY ${columnName}
```

## resultMap
可以说MyBatis中最强大的一个元素就是resultMap，从字面意思来例假其就是配置结果集映射关系的。当然如果数据库字段和bean字段一致的话使用resultClass指定结果集类型更加直接，但是往往事与愿违。resultMap 元素有很多子元素和一个值得讨论的结构。下面是 resultMap 元素的概念视图
> * resultMap
>   - constructor – 类在实例化时，用来注入结果到构造方法中
>       - idArg – ID 参数；标记结果作为 ID 可以帮助提高整体效能
>       - arg – 注入到构造方法的一个普通结果
>   - id – 一个 ID 结果；标记结果作为 ID 可以帮助提高整体效能
>   - result – 注入到字段或 JavaBean 属性的普通结果
>   - association – 一个复杂的类型关联；许多结果将包成这种类型
>       - 嵌入结果映射 – 结果映射自身的关联，或者参考一个
>   - collection – 复杂类型的集
>       - 嵌入结果映射 – 结果映射自身的集，或者参考一个
>   - discriminator – 使用结果值来决定使用哪个结果映射
>       - case – 基于某些值的结果映射
>           - 嵌入结果映射 – 这种情形结果也映射它本身，因此可以包含很多相
>              同的元素，或者它可以参照一个外部的结果映射

### id,result
这是最基本的结果映射，将单独列的值映射到简单的数据类型上，唯一的区别是id有点类似主键的意味，特别针对缓存后潜入时。它们都有一些共同的属性
```xml
property  映射到列结果的字段或属性。如果匹配存在的和给定名称相同即可的bean属性，
          当然也可以支持这种方式address.street.number
column    数据库表字段名或者sql重命名后的列名
javaType  一个JAVA类名，或者类型别名 如果你映射到一个 JavaBean，MyBatis 通常可以断定类型。
                          然而，如果你映射到的是 HashMap，那么你应该明确地指定 javaType
                          来保证所需的行为      
jdbcType  JDBC类型是仅仅需要对插入，更新 和删除操作可能为空的列进行处理 
typeHandler 使用这个属性，你可以覆盖默
            认的类型处理器。这个属性值是类的完全限定名或者是一个类型处理
            器的实现，或者是类型别名
```
### 构造方法
可以通过构造方法来创建对应的JAVABEAN。如下所示
```xml
    <!--
    根据用户编码查询得到一个user对象
    -->
    <select id="constructor" parameterType="String" resultMap="constructorDemo">
      select * from t_userinfo t where t.id =#{id}

    </select>

    <resultMap id="constructorDemo" type="userInfo">
        <constructor>
            <idArg column="id" javaType="string"></idArg>
            <arg column="name" javaType="string"></arg>
            <arg column="nick" javaType="string"></arg>
            <arg column="age" javaType="int"></arg>
        </constructor>
    </resultMap>
```
### 一对一映射
如果需要一对一bean的映射可以使用该方法进行配置即可得到关联对象,例如根据本级顺带查询出其班主任的信息[一对一映射](mapper/Team_mapper.xml)



### 一对多映射
一对多映射还是很常用的，比如通过一个班级顺带查出该班级的全部学生[一对多映射](mapper/ClassInfo_mapper.xml)

### 集合
集合元素的作用几乎和关联是相同的，实际上他们很相似。
假如在JavaBean中有如下的写法
```java
private List<Post> posts;
```
则可以使用类似如下的方式进行配置
```xml
<resultMap id=”blogResult” type=”Blog”>
<collection property="posts" javaType=”ArrayList” column="blog_id"
ofType="Post" select=”selectPostsForBlog”/>
</resultMap>
<select id=”selectBlog” parameterType=”int” resultMap=”blogResult”>
SELECT * FROM BLOG WHERE ID = #{id}
</select>
<select id=”selectPostsForBlog” parameterType=”int” resultType="Author">
SELECT * FROM POST WHERE BLOG_ID = #{id}
</select>
```






























