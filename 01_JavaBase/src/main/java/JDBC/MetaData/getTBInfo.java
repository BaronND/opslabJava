package JDBC.MetaData;

import java.sql.*;

public class getTBInfo {
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
        DatabaseMetaData ddm = con.getMetaData();
        Statement stmt = null;
        ResultSet res = null;
        ResultSetMetaData rdm = null;


        System.out.println("数据库的名称:" + ddm.getDatabaseProductName());
        System.out.println("数据库的版本:" + ddm.getDatabaseProductVersion());

        stmt = con.createStatement();

        String sql = "select * from java";

        res = stmt.executeQuery(sql);
        rdm = res.getMetaData();

        System.out.println("从" + rdm.getTableName(1) + "表中" + "获取了" + rdm.getColumnCount() + "数据");


        res.close();


        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
