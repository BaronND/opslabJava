# 对象关系映射
POJO类和关系数据库之间的映射可以用一个以*.hbm.xml结尾的XML文档来定，Hibernate通过该xml文件解析类和数据表之间的对应关系和类属性与数据库列的对应关系。在运行时Hibernate根据该文件可以生成各种类型的SQL语句。

## 映射文件的结构
```xml
-类层次:class
    * 主键:id
    * 基本类型:property
    * 实体应用类:many-to-one | one-to-one
    * 集合:set | list | map | array
        - one-to-many
        - many-to-many
    * 子类:subclass | joined_sublclass
    * 其他:component | any 等
- 查询语句:quary(用来放置查询语句，便于对数据库查询做统一的管理和优化)
```

### hibernate-mapping
hibernate-mapping是hibernate映射文件的根元素,该元素有如下属性
```xml
    - schema
        指定所映射的数据库schema的名词.若指定该属性,则转换后的SQL会有schame前缀
    - catalog
        指定所映射的数据catalog的名称
    - default-cascade(默认为none)
        设置hibernate默认的级联属性
    - default-access(默认为property)
        指定默认的属性访问策略,property即指定getter和setter方法来访问,若指定access则会反射进行属性访问
    - default-lazy(默认为true)
        设置hibernate morning的延迟加载策略
    - auto-import(默认为true)
        指定是否可以查询语言中使用非全限定的类名
    - package
        指定一个包前缀
```

### class
class元素用来指定类和表的映射,该元素有如下属性
```xml
    - abstract
    - batch-size
        指定根据OID来抓取实例时每批抓取的实例数
    - catalog
    - check
    - discriminatory-value
        指定区分不同子类的值，当使用subclass元素来定义持久化类的继承关系是需要使用该属性
    - dynamic-insert
        若设置为true,表示当保存一个对象时会动态生成insert语句,insert语句中仅包含所有取值不为null的字段
    - dynamic-update
        若设置为true,表示当更新一个对象时会动态生成update语句,update语句中仅包含所有需要更新的字段
    - entity-name
    - lazy
        指定是否使用延迟加载
    - mutable
        若设置为true，表示所有的property元素的update属性为false表示整个实例不能被更新
    - name
        指定该持久化类的名称
    - node
    - optimistic-lock
    - persister
    - polymorphism
    - proxy
    - rowid
    - schema
    - select-before-update
        设在做更新前做一次查询
    - subselect
    - table 
        指定该持久化类映射的数据表名称
    - where
```

### id
用来映射持久化类的OID和表的主键的映射,该元素有如下属性
```xml
	- access
	- column
		设置数据库表的主键列名(确保其值的唯一性)
	- length
	- name
		表示持久化类OID的属性名
	- node
	- type
		指定hibernate映射类型(关系到类属性和数据列的数据类型)
	- unsaved-value
		若设定了该属性,hibernate会通过比较持久化类的OID值和该属性值来区分持久化类是否为临时类
	- class
		generator:指定持久化的表示符生成器
			* increment 适用于代理主键,由hibernate自动以递增的方式生成
			* identity		适用于代理主键,由底层数据生成标示符
			* sequence		适用于代理主键,hibernate根据底层数据以序列的方式生成标示符
			* hilo			适用于代理主键,hibernate以high/low算法生成标示符
			* seqhili		适用于代理主键,high/low算法生成标示符
			* native		适用于代理主键,根据地城数据自动生成标示符
			* uuid.hex 		适用于代理主键,根据128的UUID算法生成标示符
			* uuid.string 	适用于代理主键,根据UUID被编码成16为的字符串
			* assigned		适用于自然主键,有java程序负责设置主键
			* foreign		适用于代理主键,使用另一相关联的对象的标示符

```
例如
```xml
<id name="EmployeeId" type="java.lang.Integer">
    <column name="EMPLOYEEID" />
    <generator class="native" />
</id>
```

### property
property元素用于指定类的属性和表的字段之间的映射关系,该元素有如下属性
```xml
	- name
	- access
	- column
	- formula
	- generate
	- index
	- insert
	- lazy
	- length
	- node
	- not-null
	- optimistic-lock
	- precision
	- scale
	- type
	- unique-key
	- unique
	- update
	
```