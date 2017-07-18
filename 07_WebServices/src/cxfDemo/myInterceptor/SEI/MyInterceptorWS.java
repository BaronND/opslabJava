package cxfDemo.myInterceptor.SEI;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MyInterceptorWS {

	@WebMethod
	public String helloWS();
}
