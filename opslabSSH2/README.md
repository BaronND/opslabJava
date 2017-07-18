#说明#
	这事一份用于学习SSH框架时写的Demo，主要用于学习Struts+Spring+Hibernate 前台使用
	了EasyUi开发的框架的Demo
	
	后端框架及版本
    	Hibernate：
    		4.3.6.Final
    	Spring:
    		4.0.2.RELEASE
    	Struts2:
    		2.3.16
    		
    前端框架及版本
		jquery 1.10.2
		bootstrap 3.3.4
		esayui 1.4
		
	
#编译
	由于系统使用了lombok简介的编写业务实体，所以需要安装LOMBOK插件，如果是IDEA用户需要设置
	setting -> compiler -> annotation Processors -> enable annotation processing
	
	

#包结构#
    ├─constant        	一些常量和静态方法
    ├─dao            	dao层的接口（Spring的@Repository层）ModelDao命名
    │  └─impl		   	DAO实现层ModelDaoImpl命名
    ├─model          	业务Model类的定义（Model命名首字母大写）
    ├─service          	Service层的接口(Spring的@Service层) ModelService命名
    │  ├─impl        	Service层的实现ModelServiceImple
    │  └─interceptor   	Service的Filter(Spring的AOP)operationInterceptor命名
    ├─struts           	控制层的接口(Spring的@Controller) 
    │  ├─Action      	控制层是实现及action实现operationAction命名
    │  └─interceptor  	控制层的Filter（Struts2的拦截器）operationInterceptor命名
    └─util             	工具类
    
    
#Web结构#
	├─admin				后台相关的一些JSP
	│  └─core
	├─commond			一些通用的JS
	├─data				一些JSON数据
	├─resoure			资源文件夹主要引入第三方类库
	│  ├─bootstrap		引入bootstrap
	│  └─easyui			引入easyui
	├─scripts			项目相关的js
	│  └─business		具体业务相关的JS文件
	├─style				样式文件
	│  └─images			图片

    
#业务实体Model#

所谓的Model也就是业务实体类，命名规范以简洁明了英文命名方式，首字大写其余小写，
每个单词之间链接处以第二个单词大写为表示(这样做而不使用驼峰命名是因为这样可以快速的生成代码)。
例如：
    
    ```
    public class Role {
        //角色ID
        @Getter @Setter private Integer RoleId;
        //角色名称
        @Getter @Setter private String RoleName;
        //角色昵称
        @Getter @Setter private String NickName;
        //角色值
        @Getter @Setter private String RoleValue;
        //角色描述
        @Getter @Setter private String RoleDesc;
        //角色拥有的权限
        @Getter @Setter private Set<Right> rights = new HashSet<Right>();
    }
    ```




#DAO层的方法定义#
Dao层通过Hibernate实现ORM映射，完成数据库到JAVA对象的映射，数据库链接又通过Spring管理。<br>
同事事务在Service层又Spring以AOP的思想实现同一的控制.<br>
DAO层的方法应以如下规则命名:<br>
<b>命名规则: CURDEntry() 	注CURD代表操作方式（通过Entry表明該操作属于DAO层）</b>

	```
	//保存实体
	public void saveEntry(T t);
	
	//更新实体
	public void updateEntry(T t);
	
	//保存或更新
	public void saveOrUpdateEntry(T t);
	
	//删除实体
	public void deleteEntry(T t);
	
	//加载实体
	public T loadEntry(String id);
	
	//加载实体
	public T getEntry(String id);
	
	//以HQL方式批量操作
	public int batchEntry (String hql,Object ...objects);
	
	//通过HQL获得实体列表
	public List<T> getEntryListByHQL(String hql,Object ...objects);
	
	//通过SQL获得提示列表
	public List<T> getEntryListBySQL(String sql,Object ...objects);

	public List<T> findEntryByHQL(String hql, Object[] objects);
	
	//以分页的方式获得实体
	public EntryPage queryPageEntry(final String hql, int page, final int size);
	```
	
##DAO层的设计原则##

DAO层顾名思义就是用来操作业务实体的CURD操作，因此不应该将业务逻辑添加到DAO层,业务层应到设计简单明了，通用。

#Service层的方法定义#
Service是J2EE软件的核心部分，主要涉及到软件的业务功能，它通过控制层将客户端请求分装传递到业务层，<br>
业务层根据具体的情况做成相应的操作，例如调用DAO层的方式实现对业务实体的控制.<br>
一般的设计原则是在业务层提供一套和DAO层统一的API接口。<br>
但为了明显的区分該方法调用是Service层的而不是DAO层的，对Service层的方法做如下规定:<br>
<b>命名规则: CURD() 	注CURD代表操作方式（通非Entry表明該操作属于Service层）</b>

	```
	//保存实体
	public void save (T t);
	//更新实体
	public void update (T t);	
	//保存或更新
	public void saveOrUpdate (T t);
	//删除实体
	public void delete (T t);
	//加载实体
	public T load(String id);
	//加载实体
	public T get(String id);
	//以HQL方式批量操作
	public int batch(String hql,Object ...objects);
	//通过HQL获得实体列表
	public List<T> getListByHQL(String hql,Object ...objects);
	//通过SQL获得提示列表
	public List<T> getListBySQL(String sql,Object ...objects);
	public List<T> findByHQL(String hql, Object[] objects);
	//以分页的方式获得实体
	public EntryPage queryPage(final String hql, int page, final int size);
	```
	
##Service层的设计原则##
Service是一个系统的核心，所有的操作及判断都应当有该层完成，另外由于Spring在初始化的时候以单利的方式进行初始化，<br>
因此可以将一些常用的费时的操作放在该层，避免其他层因创建对象而带来的性能问题。另外该层也应该保证业务完整性，<br>
及数据库事务应该有该层控制并完成。

#控制层Action的方法定义#
该层有struts2实现，在此处层有一个简单的设计原则，即所以的非静态资源都应该有Action进行跳转，及链接中不要直接出现*.JSP。<br>

<b>
方法定义:<br>
	对应Action的action的方法，应当有统一的前缀或后缀，此处使用前缀及:exec_ActionName()
</b>	

另外如果实现了ModelDriven拦截器、Preparable拦截器、Validateable拦截器<br>
其Action还需实现如下方法：<br>
<b>
	getModel():提供Model对象<br>
	prepareExecActionName ()：在调用execActionName方法前提供一个Model对象<br>
	validateExecActionName():在调用execActionName前做输入校验<br>
</b>

另外如果是实现Preparabel拦截器的话，就应当使用paramsPrepareParamsStack拦截器栈<br>
Struts 2.0的设计上要求 modelDriven 在 params 之前调用，而业务中prepare要负责准备model，<br>
准备model又需要参数，这就需要在 prepare之前运行params拦截器设置相关参数，<br>
这个也就是创建paramsPrepareParamsStack的原因。 

##Action的设计原则##
SSH整合的核心思想中Action交有Spring控制，对于每个请求Spring会重新创建一个对象，<br>
故Action的设计原则应该将其体积最小化，方法最简化。<br>
故在Action中只做简单的数据封装和传递，已经一些校验工作。其余的所有部分都应当交由Service去控制。<br>




 
