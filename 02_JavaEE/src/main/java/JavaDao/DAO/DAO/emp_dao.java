package JavaDao.DAO.DAO;
/**
 * 
 * @resume 定义emp vo的相关DAO操作接口。其实实现有DAO.IMPL.emp_impl.class实现
 * 
 */

import java.util.List;

import JavaDao.DAO.VO.*;
public interface emp_dao {
	
	/**
	 * @fun:selectAll()
	 * @param:null
	 * @return: 以List<emp>的形式范围emp表中的所有内容
	 * @exception：Exception
	 */
	public List<emp> selectAll() throws Exception;
	
	/**
	 * @fun:selectByNo(int empno);
	 * @param:emp.empno
	 * @return: 返回emp
	 * @exception：Exception
	 */
	public emp selectByNo(int empno);
	
	
}
