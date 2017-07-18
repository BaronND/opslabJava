package st2Demo.Action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @summary:
 * 	通过ActionContext获取servlet想过对象，用于访问web资源
 */
public class ActionContext_Test {
	public  String execute(){
		System.out.println("ActionContext is call....");
		//获取actionContext对象
		ActionContext actionContext = ActionContext.getContext();
		
		//获取请求对应的application对象对应的Map
		Map<String, Object> applicationMap = actionContext.getApplication();
		//从Map中获取属性等
		System.out.println("===================application========================");
		String appName  = (String) applicationMap.get("appName");
		System.out.println(appName);
		//设置属性
		applicationMap.put("applicationKey", "applicationKeyValue");
		
		
		
		//获取session对象对应的Map对象
		Map<String, Object> sessionMap = actionContext.getSession();
		//从Session中获属性等
		System.out.println("===================session========================");
		String userName = (String) sessionMap.get("userName");
		System.out.println(userName);
		//设置属性
		sessionMap.put("sessionKey","sessionValue");
		
		//获取request
		//注意actionContext没有提供getRequest方法
		@SuppressWarnings("unchecked")
		Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
		System.out.println("===================request========================");
		String requestId =(String) requestMap.get("requestId");
		System.out.println(requestId);
		requestMap.put("requestKey","requestValue");
		
		//获取请求参数对应的Map
		//该map只读不能写
		Map<String, Object> parameters = actionContext.getParameters();
		//获取请求参数
		System.out.println("===================parameters========================");
		System.out.println(parameters.get("id"));
		return "success";
	}
	

}
