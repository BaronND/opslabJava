package JavaDao.DAO.IMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JavaDao.DAO.VO.emp;

public class emp_impl implements JavaDao.DAO.DAO.emp_dao {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	public emp_impl(Connection con){
		this.con = con;
	}
	
	@Override
	public List<emp> selectAll() throws Exception {
		
		List<emp> list = new ArrayList<emp>();
		
		String sql = "select empno,ename,job,mgr,hiredate,sal,comm,deptno from EMP ";
		
		this.pstmt = con.prepareStatement(sql);
		
		ResultSet res = this.pstmt.executeQuery();
		
		emp emp = null;
		while(res.next()){
			emp = new emp();
			emp.setEmpno(res.getInt(1));
			emp.setEname(res.getString(2));
			emp.setJob(res.getString(3));
			emp.setMgr(res.getInt(4));
			/**
			 * 其他的暂时省略
			 * */
			list.add(emp);
		}
		
		return list;
	}

	@Override
	public emp selectByNo(int empno) {
		return null;
	}

}
