package cxfDemo.myInterceptor.SEIImpl;

import javax.jws.WebService;

import cxfDemo.myInterceptor.SEI.MyInterceptorWS;

@WebService
public class MyInterceptorWSImpl implements MyInterceptorWS {

	@Override
	public String helloWS() {
		System.out.println("Service say");
		return "Service say";
	}

}
