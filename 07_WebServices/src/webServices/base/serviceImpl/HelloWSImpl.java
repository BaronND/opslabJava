package webServices.base.serviceImpl;


import webServices.base.service.HelloWS;

public class HelloWSImpl implements HelloWS {

	/**
	 * webServices接口方法实现
	 */
	@Override
	public String sayHello(String name) {
		String str ="WebService hello " +name;
		System.out.println(str);
		return str;
	}


}
