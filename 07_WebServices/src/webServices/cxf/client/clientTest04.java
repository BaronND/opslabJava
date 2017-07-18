package webServices.cxf.client;

import java.util.Iterator;
import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;

import webServices.cxf.client.demo.DataTypeWS;
import webServices.cxf.client.demo.DataTypeWSImpleService;
import webServices.cxf.client.demo.Student;
import webServices.cxf.client.demo.GetStudentsMapResponse.Return;

public class clientTest04 {
	public static void main(String[] args) {
		DataTypeWSImpleService  factory = new DataTypeWSImpleService();
		DataTypeWS dataTypes = factory.getDataTypeWSImplePort();
		
		//添加拦截器
		Client client = ClientProxy.getClient(dataTypes);
		List<Interceptor<? extends Message>> outFaultInterceptors = client.getOutInterceptors();
		outFaultInterceptors.add(new InterceptorTest("admin", "admin"));
		
		//====add
		Student st = new Student();
		st.setId(100);
		st.setName("client");
		st.setSex("男");
		st.setAge(20);
		dataTypes.addStudent(st);
		
		//====get
		Student st1 = dataTypes.getStudentById(101);
		System.out.println(st1);
		
		//====list
		List<Student> list = dataTypes.getStudentsList();
		Iterator<Student> iter = list.iterator();
		while(iter.hasNext()){
			System.out.println((Student)iter.next());
		}
		
		//====map
		//请注意此处导入的包
		Return map = dataTypes.getStudentsMap();
		List<webServices.cxf.client.demo.GetStudentsMapResponse.Return.Entry> entry = map.getEntry();
		Iterator<webServices.cxf.client.demo.GetStudentsMapResponse.Return.Entry> iters = entry.iterator();
		webServices.cxf.client.demo.GetStudentsMapResponse.Return.Entry ent;
		while(iters.hasNext()){
			ent = iters.next();
			System.out.println(ent.getKey()+"\t"+ent.getValue());
		}
	}
}
