package JDBC.MetaData;

import java.sql.*;

/**
 * @author 禅师
 * @resume 利用元数据获取数据库的信息
 */
public class getDBName {
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

        System.out.println("数据库的名称:" + ddm.getDatabaseProductName());
        System.out.println("数据库的版本:" + ddm.getDatabaseProductVersion());
        ResultSet res = ddm.getPrimaryKeys(null, null, "DEPT");
        while (res.next()) {
            System.out.println("表类别:" + res.getString(1));
            System.out.println("表模式:" + res.getString(2));
            System.out.println("表名称:" + res.getString(3));
            System.out.println("表列名:" + res.getString(4));
            System.out.println("主键序号:" + res.getString(5));
            System.out.println("主键名称:" + res.getString(6));
        }


        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
