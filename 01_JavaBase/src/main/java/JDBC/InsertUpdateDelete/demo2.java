package JDBC.InsertUpdateDelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 禅师
 * @resume 批量执行插入
 */
public class demo2 {
    //连接数据库的信息
    private static final String Drivers = "oracle.jdbc.driver.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String DBUSER = "scott";
    private static final String DBPASS = "tiger";


    /**
     * function: getCon()
     * resume: 获取数据库连接
     */
    public static Connection getCon() {
        Connection con = null;

        //加载驱动
        try {
            Class.forName(Drivers);
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException error:  加载oracle驱动失败");
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (SQLException e) {
            System.err.println("SQLException error:  获取Oracle连接失败");
            e.printStackTrace();
        }

        return con;
    }


    public static void main(String[] args) throws SQLException {
        Connection con = getCon();
        Statement stmt = null;

        //取消自动提交
        con.setAutoCommit(false);

        stmt = con.createStatement();
        //执行五条SQL
        stmt.addBatch("INSERT INTO java VALUES('小妮','111')");
        stmt.addBatch("INSERT INTO java VALUES('小妮','222')");
        stmt.addBatch("INSERT INTO java VALUES('小妮','333')");
        stmt.addBatch("INSERT INTO java VALUES('小妮','444')");
        stmt.addBatch("INSERT INTO java VALUES('小妮','555')");

        //批量执行
        try {
            int temp[] = stmt.executeBatch();
            con.commit();
            System.out.println("执行了" + temp.length + "SQL");

        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
        }


        try {
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
