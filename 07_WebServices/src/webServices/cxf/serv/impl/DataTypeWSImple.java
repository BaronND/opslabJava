package webServices.cxf.serv.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import webServices.cxf.serv.dao.Student;
import webServices.cxf.serv.inter.DataTypeWS;

@WebService
public class DataTypeWSImple implements DataTypeWS{

	@Override
	public boolean addStudent(Student s) {
		System.out.println("Service addStudent()" + s);
		return true;
	}

	@Override
	public Student getStudentById(Integer id) {
		System.out.println("Service getStudentById()" + id);
		return new Student(id,"test",20,"男");
	}

	@Override
	public List<Student> getStudentsList() {
		System.out.println("Service getStudentsList()");
		List<Student>  list = new ArrayList<Student>();
		list.add(new Student(1,"test2",20,"女"));
		list.add(new Student(3,"test3",21,"男"));
		list.add(new Student(4,"test4",22,"女"));
		return list;
	}

	@Override
	public Map<Integer, Student> getStudentsMap() {
		System.out.println("Service getStudentsMap()");
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		map.put(1, new Student(1,"test1",20,"女"));
		map.put(2, new Student(2,"test2",20,"男"));
		map.put(3, new Student(3,"test3",20,"女"));
		map.put(4, new Student(4,"test4",20,"男"));
		return map;
	}

}
