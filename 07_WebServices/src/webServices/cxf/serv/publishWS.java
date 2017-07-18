package webServices.cxf.serv;

import javax.xml.ws.Endpoint;
import webServices.cxf.serv.impl.DataTypeWSImple;

public class publishWS {
	public static void main(String[] args) {
		String address = "http://localhost:8080/J2EE/services/datatype";
		
		Endpoint.publish(address, new DataTypeWSImple());
		
		System.out.println("Service 发布成功");
	}
}
