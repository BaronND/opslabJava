package cxfDemo.JAXWS_DEMO02;

import javax.xml.ws.Endpoint;

import cxfDemo.JAXWS_DEMO02.SEIImpl.ProjectManagerImple;

public class publish {
	public static void main(String[] args) {
		String address ="http://localhost:8888/services/jaxwsDemo02";
		
		Endpoint.publish(address, new ProjectManagerImple());
		
		System.out.println("发布成功");
	}
}
