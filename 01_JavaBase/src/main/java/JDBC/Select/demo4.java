package JDBC.Select;

import java.sql.*;

/**
 * @author 禅师
 * @resume 获取可移动的结果集
 */
public class demo4 {

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
        PreparedStatement pstmt = null;
        ResultSet res = null;
        String sql = "select * from java";


        //创建可以滚动的结果集对象
        try {
            pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            res = pstmt.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        System.out.print("第2条记录:");
        if (res.absolute(2)) {
            System.out.println(res.getString(1) + "->" + res.getString(2));
        }
        System.out.print("第1条记录:");
        if (res.absolute(1)) {
            System.out.println(res.getString(1) + "->" + res.getString(2));
        }


        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
