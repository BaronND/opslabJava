package app.struts.action;

import app.constant.constant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * 
 * @author admins
 * @summary: 所有struts的action父类，主要用于继承
 */
@SuppressWarnings({"rawtypes" })
public class SupportAction<T> extends ActionSupport implements ModelDriven<T>, Preparable, RequestAware{

	public static final long serialVersionUID = -8630770937273263572L;

	@Getter @Setter public  Map<String,Object>  requestMap;

	@Getter @Setter public T model;

	@Getter @Setter public int page=1;

	@Getter @Setter public int size=constant.PAGE_SIZE;

	@Getter @Setter public String id;

	@Getter @Setter public Logger log;


	/**
	 * 通过构造方法获取的实体model的类型
	 */
	public SupportAction() {
		log = Logger.getLogger(this.getClass());
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class clazz = (Class) type.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void prepare() throws Exception {
		log.info("struts action->prepare:"+model);
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.requestMap = arg0;
	}

	public void printJSON(JSONArray json){
		HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		response.setCharacterEncoding(constant.APPLCATION_ENCODING);
		response.setContentType("application/Json");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printJSON(Object obj){
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,new JsonValueProcessor() {
		  private SimpleDateFormat sd = new SimpleDateFormat(constant.DATE_FORMAT);
		  public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
		    return  value == null ?"" : sd.format(value);
		  }
		  public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		    return null;
		  }
		});
		
		HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		response.setCharacterEncoding(constant.APPLCATION_ENCODING);
		response.setContentType("application/Json");
		try {
			response.getWriter().write(JSONArray.fromObject(obj,jsonConfig).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
