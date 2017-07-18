package JavaDao.DAO;

import JavaDao.DAO.DAO.emp_dao;
import JavaDao.DAO.PROXY.emp_proxy;

public class DAOFactory{
	public static emp_dao getEmpDAO()throws Exception{
		return (emp_dao) new emp_proxy();
	}
}