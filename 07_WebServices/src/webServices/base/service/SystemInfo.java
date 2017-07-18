package webServices.base.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 
 * @summary:
 * 		定义webservice sei接口
 */
@WebService
public interface SystemInfo {
	//定义接口方法
	@WebMethod
	public String time(String format);
	
	@WebMethod
	public String network();
	
	@WebMethod
	public String mem();
}
