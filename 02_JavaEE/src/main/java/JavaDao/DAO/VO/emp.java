package JavaDao.DAO.VO;
/**
 * 
 * @author 禅师
 * @resume DAO模式VO类
 * 		   DB:oracle
 * 		   schema:scott
 * 		   table:emp
 * @table-desc
 * 	EMPNO                          NUMBER
 *	ENAME                          VARCHAR2
 *	JOB                            VARCHAR2
 *	MGR                            NUMBER
 *	HIREDATE                       DATE
 *	SAL                            NUMBER
 *	COMM                           NUMBER
 *	DEPTNO                         NUMBER
 */
import java.util.Date;
public class emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int  sal;
	private int comm;
	private int depno;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDepno() {
		return depno;
	}
	public void setDepno(int depno) {
		this.depno = depno;
	}
	@Override
	public String toString() {
		return "emp [empno=" + empno + ", ename=" + ename + ", job=" + job
				+ ", mgr=" + mgr + ", hiredate=" + hiredate + ", sal=" + sal
				+ ", comm=" + comm + ", depno=" + depno + "]";
	}
	
}
