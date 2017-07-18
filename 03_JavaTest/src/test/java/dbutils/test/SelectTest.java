package dbutils.test;

import dbutils.entries.RowData;
import dbutils.util.DBConnectionUtil;
import junit.framework.TestCase;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 使用dbuntils做select查询测试
 */
public class SelectTest  {


    //创建连接
    private Connection conn = DBConnectionUtil.makeConnection();

    //创建SQL执行工具
    private QueryRunner qRunner = new QueryRunner();

    @After
    public void after() {
        DBConnectionUtil.close(conn);
    }


    /**
     * 测试简单的查询
     *
     * @throws SQLException
     */
    @Test
    @Ignore
    public void test_SimpleSelect() throws SQLException {

        List<String> list = (List<String>) qRunner.query(conn, "select nick from tt_data_1 limit 100",
                new ColumnListHandler("nick"));
        //输出查询结果
        for (String nick : list) {
            System.out.println(nick);
        }
        //关闭数据库连接
        DBConnectionUtil.close(conn);
    }

    /**
     * 测试各种方式的结果集处理
     * ArrayHandler: 把结果集中的第一行数据转换成对象数组
     * ArrayListHandler：把结果集中的每一样数据转换成一个数组，再放到list中
     */
    @Test
    @Ignore
    public void test_array() throws SQLException {

        //获取第一行结果集
        Object[] arrs = (Object[]) qRunner.query(conn, "select * from tt_data_1 limit 100",
                new ArrayHandler());

        System.out.println(Arrays.asList(arrs));


        //将结果集以Object数组存储到list中返回
        List<Object[]> lists = (List<Object[]>) qRunner.query(conn, "select * from tt_data_1 limit 100",
                new ArrayListHandler());
        for (Object[] objs : lists) {
            System.out.println(Arrays.asList(objs));
        }

    }

    /**
     * BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中
     * BeanListHandler: 将结果集总的每一行封装成JavaBean并存储到list中
     */
    @Test
    @Ignore
    public void test_bean() throws SQLException {
        //将结果集中的第一行封装到对应的Javabean中
        RowData row = (RowData) qRunner.query(conn, "select * from tt_data_1 limit 100",
                new BeanHandler(RowData.class));
        System.out.println(row);

        //将所有集按每行对一个JavaBean封装并存储到list中
        List<RowData> rows = (List<RowData>) qRunner.query(conn, "select * from tt_data_1 limit 100",
                new BeanListHandler<RowData>(RowData.class));
        for (RowData r : rows) {
            System.out.println(r);
        }
    }

    /**
     * ColumnListHandler：将结果集中的某一列以list的方式返回
     */
    @Test
    @Ignore
    public void test_column() throws SQLException {
        //将结果集中的某一列数据存储到list中
        List<String> list = (List) qRunner.query(conn, "select * from tt_data_1 limit 100",
                new ColumnListHandler("nick"));
        for (String n : list) {
            System.out.println(n);
        }
    }

    /**
     * KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里面，再把这些map再存储到一个map里面
     * MapHandler：将结果集中的第一行数据封装到一个Map里面，key是列名，value就是对应的只
     * MapListHandler：将结果集中的每一行数据都封装到一个Map里面，然后在放到list中
     */
    @Test
    @Ignore
    public void test_map() throws SQLException {
        String sql = "select * from tt_data_1 limit 100";
        Map<Integer, Map> map = (Map) qRunner.query(conn, sql, new KeyedHandler<Integer>("qid"));

        String printStr = "%d -{%s}";
        String temp = "\"%s\":\"%s\"";
        for (Map.Entry<Integer, Map> me : map.entrySet()) {
            int id = me.getKey();
            Map<String, Object> innerMap = me.getValue();
            //此处使用array效果会很多
            StringBuffer sbuf = new StringBuffer();
            for (Map.Entry<String, Object> innerEntry : innerMap.entrySet()) {
                sbuf.append(String.format(temp, innerEntry.getKey(), innerEntry.getValue()));
            }
            System.out.println(String.format(printStr, id, sbuf.toString()));
        }


        Map<String, Object> maps = (Map) qRunner.query(conn, sql, new MapHandler());
        for (Map.Entry<String, Object> iter : maps.entrySet()) {
            System.out.println(iter.getKey() + ":" + iter.getValue());
        }

        List<Map<String, Object>> lstMap = (List) qRunner.query(conn, sql, new MapListHandler());
        for (Map ms : lstMap) {
            System.out.println(ms);
        }
    }
}
