package JDBC.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class meteTest1 {

    private static final String Drivers = "oracle.jdbc.driver.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String DBUSER = "scott";
    private static final String DBPASS = "tiger";

    public static void main(String[] args) throws SQLException {

        //用于表示一个连接
        Connection con = null;

        //加载驱动
        try {
            Class.forName(Drivers);
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动异常：" + Drivers);
            e.printStackTrace();
        }


        //获得数据连接
        try {
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (SQLException e) {
            System.out.println("获取数据库连接失败");
            e.printStackTrace();
        }


        System.out.println(con.getMetaData());


        //关闭数据库连接
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
