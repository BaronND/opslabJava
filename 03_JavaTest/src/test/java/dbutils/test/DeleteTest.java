package dbutils.test;

import dbutils.util.DBConnectionUtil;
import junit.framework.TestCase;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 使用dbuntils做delete删除测试
 */
public class DeleteTest {
    //创建连接
    private Connection conn = DBConnectionUtil.makeConnection();

    //创建SQL执行工具
    private QueryRunner qRunner = new QueryRunner();

    @Test
    @Ignore
    public void test_delete() throws SQLException {
        String sql = "delete from fuzz.tt_nick_1  where counts=?";
        qRunner.update(conn, sql, 100);
    }
    @Test
    @Ignore
    public void test_deletebatch() throws SQLException {
        String sql = "delete from fuzz.tt_nick_1  where counts=?";
        qRunner.batch(conn, sql, new Object[][]{{1}, {2}});
    }
}
