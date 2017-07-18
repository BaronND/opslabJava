package dbutils.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 用于获取数据连接
 */
public class DBConnectionUtil {
    private static String dirverClassName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/tencent?useUnicode=true&characterEncoding=utf8";
    private static String user = "root";
    private static String password = "123456";

    public static Connection makeConnection() {
        Connection conn = null;
        try {
            Class.forName(dirverClassName);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
