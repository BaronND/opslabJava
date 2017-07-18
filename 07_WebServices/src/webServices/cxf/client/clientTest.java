package webServices.cxf.client;

import java.util.Iterator;
import java.util.List;

import webServices.cxf.client.demo.DataTypeWS;
import webServices.cxf.client.demo.DataTypeWSImpleService;
import webServices.cxf.client.demo.GetStudentsMapResponse.Return;
import webServices.cxf.client.demo.Student;
/**
 * 
 *  demo包下的内容全部有以下命令生成：
 *  wsdl2java.bat -p webServices.cxf.client.demo -all http://localhost:8080/J2EE/services/datatype?wsdl
 *  
 *  注意：
 *  	纯JDK的webservices是不支持map数据类型
 */
public class clientTest {
	public static void main(String[] args) {
		DataTypeWSImpleService  factory = new DataTypeWSImpleService();
		DataTypeWS dataTypes = factory.getDataTypeWSImplePort();
		
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
