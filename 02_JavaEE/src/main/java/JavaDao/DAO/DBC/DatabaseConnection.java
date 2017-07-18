package JavaDao.DAO.DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @resume 主要完成数据库的连接
 * 	
 * 注意：
 * 		如要考虑到后期可能跨数据库  可以将此处改为接口
 */
public class DatabaseConnection {
	private static final String DRIVER= "oracle.jdbc.driver.OracleDriver";
	private static final String DBURL= "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER= "scott";
	private static final String PASS= "tiger";
	
	private Connection con = null;		//代表数据库连接

	public DatabaseConnection(){
		try{
			Class.forName(DRIVER);
			this.con = DriverManager.getConnection(DBURL,USER,PASS);
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public Connection getConneciton(){
		return this.con;
	}
	
	public void close(){
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
