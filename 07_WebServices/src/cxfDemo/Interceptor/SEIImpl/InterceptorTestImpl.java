package cxfDemo.Interceptor.SEIImpl;

import javax.jws.WebService;

import cxfDemo.Interceptor.SEI.InterceptorTest;

@WebService
public class InterceptorTestImpl implements InterceptorTest {

	@Override
	public boolean helloSay() {
		System.out.println("service say!!!");
		return true;
	}

}
