package cxfDemo.Interceptor.SEI;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface InterceptorTest {

	@WebMethod
	public boolean helloSay();
}
