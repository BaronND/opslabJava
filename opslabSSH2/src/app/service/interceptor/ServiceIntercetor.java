package app.service.interceptor;

import app.annotation.ServiceMethod;
import app.annotation.ServiceType;
import app.entries.BusinessLog;
import app.entries.User;
import app.service.BusinessLogService;
import app.util.StringUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 利用SpringAOP实现业务层的日志记录
 */
public class ServiceIntercetor {

	public static Logger logger = LoggerFactory.getLogger(ServiceIntercetor.class);

	@Resource(name = "businessLogService") @Getter @Setter private BusinessLogService businessLogService;


	private BusinessLog log = new BusinessLog();

	public Object logAop(ProceedingJoinPoint pjp) {
		try {
			String className = pjp.getTarget().getClass().getName();
			String opeationName = pjp.getSignature().getName();
			Method meths[] = pjp.getSignature().getDeclaringType().getMethods();

			String ann = "";
			for (Method m : meths) {
				if (opeationName.equals(m.getName())) {
					if (m.isAnnotationPresent(ServiceMethod.class)) {
						ServiceMethod annotation = m.getAnnotation(ServiceMethod.class);
						ann = annotation.name();
						log.setType(annotation.type().toString());
					} else {
						ann = "该方法没有业务层的注解";
						log.setType(ServiceType.NONE.toString());
					}
				}
			}
			log.setOperationName(ann + "::" + className + "::" + opeationName);
			//操作参数 
			log.setOperationParam(StringUtil.arr2Str(pjp.getArgs()));
			
			//获取session中的数据
			ActionContext context = ActionContext.getContext();
			if(context != null){
				Map<String, Object> session = context.getSession();
				if(session != null){
					User user = (User) session.get("user");
					if(user != null){
						log.setUserName(user.getUsername());
					}
				}
				HttpServletRequest request = ServletActionContext.getRequest();
				if(request != null){
					String uri=request.getRequestURI();
					String address=request.getRemoteAddr();
					log.setAddress(address);
					Map<String, Object> actionParam = context.getParameters();
					StringBuffer paramters = new StringBuffer();
					Iterator<Entry<String, Object>> iterator = actionParam.entrySet().iterator();
					Entry<String, Object> entry;
					while(iterator.hasNext()){
						entry =iterator.next();
						paramters.append("&");
						paramters.append(entry.getKey());
						paramters.append("=");
						paramters.append(StringUtil.arr2Str((String[])entry.getValue()));
					}
					if("" != paramters.toString()){
						log.setUri(uri);
					}else{
						log.setUri(uri+"?"+paramters.toString());
					}

				}
			}
			//调用目标对象的方法
			Object ret = pjp.proceed();
			//设置操作结果
			log.setResult("success");
			//设置结果消息
			if(ret != null){
				if(ret.toString().length() > 200){
					log.setMsg(ret.toString().substring(0,200));
				}
			}
			return ret ;
		}catch(Throwable e){
			e.printStackTrace();
			log.setResult("Exception");
			String msg= e.getMessage();
			if(msg.length() > 200){
				msg = msg.substring(0, 200);
			}
			log.setMsg(msg);
		}finally{
			businessLogService.save(log);
			logger.info("Spring-Businsss-AopLog:" + log);
		}
		return null;
	}
	
}
