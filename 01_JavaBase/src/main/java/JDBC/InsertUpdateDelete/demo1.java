package JDBC.InsertUpdateDelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author 禅师
 * @resume 向表中插入数据
 */
public class demo1 {
    private static final String Drivers = "oracle.jdbc.driver.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String DBUSER = "scott";
    private static final String DBPASS = "tiger";


    public static void main(String[] args) throws SQLException {

        //获取当前时间
        long startTime = System.currentTimeMillis();
        //驱动数据库连接
        Connection con = getCon();

        String sql = "INSERT INTO java values('禅师','12345')";

        //创建Statement实例
        Statement stmt = con.createStatement();

        //执行更新操纵
        //insert update delete都用可以使用executeUpdate方式执行 知识sql语句不同
        stmt.executeUpdate(sql);

        //释放资源
        stmt.close();
        con.close();
        long endTime = System.currentTimeMillis();
        System.out.println("公用了:" + (endTime - startTime) + "毫秒");
    }

    public static Connection getCon() {
        Connection con = null;

        //加载驱动
        try {
            Class.forName(Drivers);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return con;
    }


}
