package dbutils.test;

import dbutils.util.DBConnectionUtil;
import junit.framework.TestCase;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * 使用dbuntils做insert插入测试
 */
public class insertTest {
    //创建连接
    private Connection conn = DBConnectionUtil.makeConnection();

    //创建SQL执行工具
    private QueryRunner qRunner = new QueryRunner();

    @Test
    @Ignore
    public void test_insert() throws SQLException {
        String insert = "insert into fuzz.tt_nick_1(nick,py_qp,py_jp,counts) values(?,?,?,?)";
        //直接按照顺序增加
        qRunner.update(conn, insert, "方丈1", "fangzhang", "fz", 11);
        //可以将参数列表些到Object数组中
        qRunner.update(conn, insert, new Object[]{"方丈2", "fangzhang", "fz", 11});
    }
    @Test
    @Ignore
    public void test_batch() throws SQLException {
        String insert = "insert into fuzz.tt_nick_1(nick,py_qp,py_jp,counts) values(?,?,?,?)";

        Object[][] values = new Object[][]{
                {"方丈3", "fangzhang", "fz", 11},
                {"方丈4", "fangzhang", "fz", 11},
                {"方丈6", "fangzhang", "fz", 11}
        };
        qRunner.batch(conn, insert, values);
    }

    /**
     * 测试结果显示性能貌似很很不错
     * 基本资源不做 有资源的做个100w级数据的测试呗
     *
     * @throws SQLException
     */
    @Test
    @Ignore
    public void test_preformance() throws SQLException {
        //测试单挑语句执行for的性能(4～5内完成)
        System.out.println(new Date());
        String insert = "insert into fuzz.tt_nick_1(nick,py_qp,py_jp,counts) values(?,?,?,?)";
        for (int i = 0; i < 10000; i++) {
            qRunner.update(conn, insert, "方丈" + i, "fangzhang", "fz", 11);
        }
        System.out.println(new Date());

        //测试先生成数据在插入(3～4内完成)
        System.out.println(new Date());
        Object[][] values = new Object[10000][];
        for (int i = 0; i < 10000; i++) {
            values[i] = new Object[]{"方丈" + (i + 10000), "fangzhang", "fz", 11};
        }
        qRunner.batch(conn, insert, values);
        System.out.print(new Date());

    }
}
