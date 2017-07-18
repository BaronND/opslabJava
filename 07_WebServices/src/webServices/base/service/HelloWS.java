package webServices.base.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/***********************************************
 * 
 * @author admins
 * @summary:定义webservice的接口函数
 * 		即SEI
 **********************************************/
@WebService
public interface HelloWS {
	//定义接口方法
	@WebMethod
	public String sayHello(String name);
	
}
