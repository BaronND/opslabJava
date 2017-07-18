package app.struts.interceptor;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import app.annotation.ActionMethod;
import app.util.DateUtil;
import app.util.StringUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings({ "rawtypes", "unchecked" })
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
		if(currentMethod.getDeclaringClass().toString().contains("xwork2")){
			//struts core method
		}else if (currentMethod.isAnnotationPresent(ActionMethod.class)) {
			ActionMethod annotation = currentMethod.getAnnotation(ActionMethod.class);
			temp = annotation.type() + "::" + annotation.name();
		} else {
			return currentMethod+"方法无签名,请不会执行！";
		}
		Long startTime = System.currentTimeMillis();
		Map<String, Object> session = context.getSession();
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
