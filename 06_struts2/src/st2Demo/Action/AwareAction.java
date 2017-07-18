package st2Demo.Action;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
/**
 * 
 *	@summary:
 *		通过*Aware接口获取web资源对应的map 
 *
 */
public class AwareAction implements ApplicationAware, RequestAware, SessionAware,ParameterAware {

	private Map<String, Object> applicationMap;
	
	private Map<String, Object> sessionMap;
	
	private Map<String, Object> requestMap;
	
	private Map<String,String[]> parameterMap;
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.requestMap  = arg0;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.applicationMap =arg0;
	}

	@Override
	public void setParameters(Map<String, String[]> arg0) {
		this.parameterMap =arg0;
	}

	
	/**
	 *	@StrutsAction: 
	 */
	public String execute(){
		//操作application对应的map
		System.out.println("appName:"+applicationMap.get("appName"));
		applicationMap.put("applicationKey", "applicationValue");
		
		//操作session对应的MAP
		System.out.println("userName:"+sessionMap.get("userName"));
		sessionMap.put("sessionKey", "sessiosValue");
		//遍历map
		Iterator<Entry<String, Object>> iterator = sessionMap.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, Object> entry = iterator.next();
			System.out.println("Session:"+entry.getKey()+"===>"+entry.getValue());
		}
		
		//操作request对应的Map
		System.out.println("requestId:"+requestMap.get("requestId"));
		requestMap.put("requestKey", "requestValue");
		Iterator<Entry<String, Object>> iterator1 = requestMap.entrySet().iterator();
		while(iterator1.hasNext()){
			Entry<String, Object> entry = iterator1.next();
			System.out.println("request:"+entry.getKey()+"===>"+entry.getValue());
		}
		//操作请求参数对应的Map
		System.out.println("parameterId:"+(parameterMap.get("id")));
		String[] par = new String[]{"parameterValue"};
		parameterMap.put("parameterKey", par);
		Iterator<Entry<String, String[]>> iterator2 = parameterMap.entrySet().iterator();
		while(iterator2.hasNext()){
			Entry<String, String[]> entry = iterator2.next();
			System.out.println("parameter:"+entry.getKey()+"==>"+entry.getValue()[0]);
		}
		return "success";
	}
	
}

