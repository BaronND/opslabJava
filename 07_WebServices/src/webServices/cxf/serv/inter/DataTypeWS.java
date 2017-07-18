package webServices.cxf.serv.inter;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import webServices.cxf.serv.dao.Student;

@WebService
public interface DataTypeWS {
	@WebMethod
	public boolean addStudent(Student s);
	
	@WebMethod	
	public Student getStudentById(Integer id);
	
	@WebMethod	
	public List<Student> getStudentsList();
	
	@WebMethod	
	public Map<Integer, Student> getStudentsMap();
}
