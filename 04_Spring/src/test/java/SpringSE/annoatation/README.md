要使用spring的annoatation首先需要在bean的配置文件中，假如如下的配置项，以保证spring能对注解进行解析
	<!-- 指定spring的扫描的包 -->
	<context:component-scan base-package="SpringSE.annoatation"></context:component-scan>
	

	<!-- 
		-base-package:指定spring容器扫描的包，当扫描多个包是使用，进行分割
		-如果指向扫描特定的类，而不是全部的类，可以使用resource-pattern
		-context:include-filter 字节表示包含的目标类
		-context:execlude-filter:子节点表示要排除在外的目标类
	 -->

@Repository:用表将数据访问层DAO表示为SpringBean
@Component:是一个泛型的概念，仅仅表示一个组件Bean，可以作用在任何层次
@Service:通常作用在业务层
@Controller:通常作用在控制成

@Scope指定bean的作用域默认是单例模式

@PostConstrut:用于指定类的初始化方法
@PreDestroy:用于指定类的销毁方法

@Required:进行Bean的依赖检查

//指定bean的自动装配策略
@Resource
@Autowired
@Qualifier


//进行Bean的声明
@Configuration
@Bean
