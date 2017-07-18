##利用注解和AOP实现业务的日志记录##

利用AOP思想在所有业务层的方法调用上加入业务日志。
首先建立业务日志实体
    
    ```
    public class BusinessLog {
    
        @Getter @Setter private Long id;
    
        @Getter @Setter private String uri;
    
        @Getter @Setter private String userName;
    
        @Getter @Setter private String address;
    
        @Getter @Setter private Date startTime = new Date();
        
        @Getter @Setter private Date endTime = new Date();
    
        @Getter @Setter private String operationName;
    
        @Getter @Setter private String operationParam;
        
        @Getter @Setter private String type;
    
        @Getter @Setter private String result;
    
        @Getter @Setter private String msg;
    
        @Override
        public String toString() {
            return " ["+(endTime.getTime() - startTime.getTime())+" - "+ result+"] -> "+operationName+"("+operationParam+")";
        }
    }
    ```
##建立并定义AOP切入点##

    ```
    public class LogInterceptor implements Interceptor {
    
        private static final long serialVersionUID = 965894819250440297L;
    
        @Override
        public void destroy() {
    
        }
    
        @Override
        public void init() {
    
        }
    
        @Override
        public String intercept(ActionInvocation action) throws Exception {
            String methodName = action.getProxy().getMethod();
            Class clazz = action.getAction().getClass(); // 获取类对象
            Method currentMethod = clazz.getMethod(methodName);
            ActionContext context = action.getInvocationContext();
            HttpServletRequest request = ServletActionContext.getRequest();
            Map<String, Object> actionParam = context.getParameters();
            String uri = request.getRequestURI();
            String temp = "";
            if (currentMethod.isAnnotationPresent(ActionMethod.class)) {
                ActionMethod annotation = currentMethod.getAnnotation(ActionMethod.class);
                temp = annotation.type() + "::" + annotation.name();
            } else {
                return uri+"方法无签名,请不会执行！";
            }
            Long startTime = System.currentTimeMillis();
            // Map<String, Object> session = context.getSession();
            String result = action.invoke();
            Long endTime = System.currentTimeMillis();
            StringBuffer paramters = new StringBuffer();
            Iterator<Entry<String, Object>> iterator = actionParam.entrySet().iterator();
            Entry<String, Object> entry;
            while (iterator.hasNext()) {
                entry = iterator.next();
                paramters.append("&");
                paramters.append(entry.getKey());
                paramters.append("=");
                paramters.append(StringUtil.arr2Str((String[]) entry.getValue()));
            }
            System.out.println(DateUtil.getDateTime(new Date()) + " struts[" + (endTime - startTime) + "]->" + temp + " > " + uri + "::" + paramters.toString());
            return result;
        }
    
    }
    ```
定切入点

    ```
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
	```
	
#单元测试#
    ```
	@Test
	public void getMenuList(){
		RightsService service = (RightsService) Context.getBean("rightsService");
		
		List<?> list = service.getMenuList();
		
		System.out.println(list.size());
	}
	```
测试结果如下
 
利用Struts拦截器和Anontation记录和拦截请求层输入
编写Anontation

    ```
    public enum ActionType {
        NONE,		//无
        SYSTEM,		//系统方法
        TOOLS,		//工具方法
        BUSINESS;	//业务方法
    }
    @Target(value=ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ActionMethod {
        public ActionType type() default ActionType.BUSINESS;
        public String name() default "业务请求";
    }
    ```

编写Action的拦截器记录并拦截为签名的请求输入
    
    ```
    public class LogInterceptor implements Interceptor {
        private static final long serialVersionUID = 965894819250440297L;
        @Override
        public void destroy() {
        }
        @Override
        public void init() {
        }
        @Override
        public String intercept(ActionInvocation action) throws Exception {
            String methodName = action.getProxy().getMethod();
            Class clazz = action.getAction().getClass(); // 获取类对象
            Method currentMethod = clazz.getMethod(methodName);
            ActionContext context = action.getInvocationContext();
            HttpServletRequest request = ServletActionContext.getRequest();
            Map<String, Object> actionParam = context.getParameters();
            String uri = request.getRequestURI();
            String temp = "";
            if (currentMethod.isAnnotationPresent(ActionMethod.class)) {
                ActionMethod annotation = currentMethod.getAnnotation(ActionMethod.class);
                temp = annotation.type() + "::" + annotation.name();
            } else {
                return uri+"方法无签名,请不会执行！";
            }
            Long startTime = System.currentTimeMillis();
            // Map<String, Object> session = context.getSession();
            String result = action.invoke();
            Long endTime = System.currentTimeMillis();
            StringBuffer paramters = new StringBuffer();
            Iterator<Entry<String, Object>> iterator = actionParam.entrySet().iterator();
            Entry<String, Object> entry;
            while (iterator.hasNext()) {
                entry = iterator.next();
                paramters.append("&");
                paramters.append(entry.getKey());
                paramters.append("=");
                paramters.append(StringUtil.arr2Str((String[]) entry.getValue()));
            }
            System.out.println(DateUtil.getDateTime(new Date()) + " struts[" + (endTime - startTime) + "]->" + temp + " > " + uri + "::" + paramters.toString());
            return result;
        }
    }
    ```