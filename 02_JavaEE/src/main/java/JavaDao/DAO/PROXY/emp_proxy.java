package JavaDao.DAO.PROXY;

import java.util.List;

import JavaDao.DAO.DAO.emp_dao;
import JavaDao.DAO.DBC.DatabaseConnection;
import JavaDao.DAO.IMPL.emp_impl;
import JavaDao.DAO.VO.*;

public class emp_proxy implements emp_dao{
	private DatabaseConnection dbc = null;
	private emp_dao dao = null;
	
	public emp_proxy(){
		this.dbc = new DatabaseConnection();
		this.dao = (emp_dao) new emp_impl(dbc.getConneciton());
	}
	
	public List<emp> selectAll(){
		List<emp> list = null;
		try {
			list = this.dao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return list;
	}

	@Override
	public emp selectByNo(int empno) {
		return null;
	}
}
