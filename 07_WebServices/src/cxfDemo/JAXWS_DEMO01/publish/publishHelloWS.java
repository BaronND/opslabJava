package cxfDemo.JAXWS_DEMO01.publish;

import javax.xml.ws.Endpoint;

import cxfDemo.JAXWS_DEMO01.services.helloWSImpl;

public class publishHelloWS {
	public static void main(String[] args) {
		String address ="http://localhost:8888/services/helloWS";
		
		Endpoint.publish(address, new helloWSImpl());
	}
}
