package JDBC.Select;

import java.sql.*;

public class demo3 {


    private static final String Drivers = "oracle.jdbc.driver.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String DBUSER = "scott";
    private static final String DBPASS = "tiger";


    public static void main(String[] args) throws SQLException {

        //获取当前时间
        long startTime = System.currentTimeMillis();


        //驱动数据库连接
        Connection con = getCon();

        String sql = "Select * from java where name = ?";

        //创建Statement实例
        PreparedStatement pstmt = con.prepareStatement(sql);
        //设置问号的内容
        pstmt.setString(1, "禅师");


        //执行查询
        ResultSet res = null;    //用于接收返回的
        res = pstmt.executeQuery();

        //输出结果
        while (res.next()) {
            String name = res.getString("name");
            String pass = res.getString("pass");

            System.out.println(name + " -> " + pass);
        }

        //释放资源
        pstmt.close();
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
