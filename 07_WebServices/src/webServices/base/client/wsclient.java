package webServices.base.client;

import webServices.base.client.demo.HelloWS;
import webServices.base.client.demo.HelloWSImplService;

public class wsclient {
	public static void main(String[] args){
		//创建一个类似与SEI的工厂
		HelloWSImplService factory = new HelloWSImplService();
		//创建一个调用webservices的客户端实例
		HelloWS hello = factory.getHelloWSImplPort();
		//调用webservices方法方方法
		
		/**
		 * 此工程的jar包中有cxf的包 所以这里会抛出一个异常
		 */
		hello.sayHello("test");
	}
}
