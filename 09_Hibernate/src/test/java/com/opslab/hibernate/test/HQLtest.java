package com.opslab.hibernate.test;

import com.opslab.hibernate.entity.oracle.UserTabColumnsVO;
import com.opslab.hibernate.entity.oracle.UserTablesVO;
import org.hibernate.Query;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * 
 * 通过映射查询oracle的一些系统展示HQL的用法
 */
@SuppressWarnings("unchecked")
public class HQLtest extends SuperTest{
	/*
	@Test
	public void test_USERTABLES(){
		List<UserTablesVO> user_tables = session.createQuery("FROM UserTablesVO").list();
		System.out.println(user_tables.size());
		Iterator<UserTablesVO> iter = user_tables.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	
	@Test
	public void test_USERCOLUMNS(){
		//第一种绑定参数的方法
		//创建一个Query对象
		Query query = session.createQuery("FROM UserTabColumnsVO o where o.tableName like ? ");
		//绑定参数,并执行查询
		List<UserTabColumnsVO> user_cols =query.setString(0, "%EMP%").list();

		Iterator<UserTabColumnsVO> iter = user_cols.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		//第二种方式
		query = session.createQuery("FROM UserTabColumnsVO o where o.tableName like :tableName");
		user_cols = query.setString("tableName", "%EMP%").list();
		iter = user_cols.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	
	
	@Test
	public void test_pageSize(){
		//利用hibernate实现分页
		int pageNumber = 2;
		
		int pageSize = 3;
		
		String hql ="from UserTabColumnsVO";
		
		Query query = session.createQuery(hql);
		List<UserTabColumnsVO> user_cols = query.setFirstResult((pageNumber)* pageSize)
				.setMaxResults(pageSize)
				.list();
		Iterator<UserTabColumnsVO> iter = user_cols.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
				
	}
	
	@Test
	public void testHQLQuery(){
		//从配置文件中获取一个Query对象并执行查询
		List<UserTablesVO> user_tables = session.getNamedQuery("Oracle.User_tables").list();
		for(UserTablesVO vo: user_tables){
			System.out.println(vo);
		}
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void test_ProjectionQuery(){
		//利用投影查询进行对象查询
		
		//例如值查询UserTablesVO的tableName，tableSpaceName
		String  hql = "SELECT o.tableName,o.tableSpaceName FROM UserTablesVO o";
		
		//创建Query对象
		//注意此时query的list方法返回的是对象数组
		List<Object[]> tables = session.createQuery(hql).list();
		for(Object[] objs:tables){
			for(Object obj:objs){
				System.out.print(obj+"\t");
			}
			System.out.println();
		}
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void test_ProjectionQuery2(){
		//将投影查询封装成对象的信息
		
		//例如查询例如值查询UserTablesVO的tableName，tableSpaceName
		//并且想将结果集封装成UserTableVO的list集合。则必须在UserTableVO的POJO中定义这个俩个字段的构造方法，并且不要忘了些无参构造
		
		//hql中的new后面的类名要写全路径名
		String  hql ="SELECT "
				+ "new hibernate3.POJO.oracle.UserTablesVO(o.tableName,o.tableSpaceName) "
				+ "FROM UserTablesVO o";
		
		List<UserTablesVO> userTables = session.createQuery(hql).list();
		Iterator<UserTablesVO> iter = userTables.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
	}
	*/
}
