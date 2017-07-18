package dbutils.test;

import dbutils.util.DBConnectionUtil;
import junit.framework.TestCase;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 使用dbuntils做update插入测试
 */
public class updateTest{
    //创建连接
    private Connection conn = DBConnectionUtil.makeConnection();

    //创建SQL执行工具
    private QueryRunner qRunner = new QueryRunner();

    @Test
    @Ignore
    public void test_update() throws SQLException {
        String sql = "update fuzz.tt_nick_1 t set t.counts=? where t.nick =?";
        qRunner.update(conn, sql, 100, "方丈0");
    }
}
