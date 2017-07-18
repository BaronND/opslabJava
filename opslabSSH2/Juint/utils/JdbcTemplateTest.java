package utils;

import app.entries.BusinessLog;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import services.TestUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * <h6>Description:<h6>
 * <p>测试JdbcTemplate工具类</p>
 *
 * @date 2015-06-10.
 */
public class JdbcTemplateTest extends TestUtil {

    private JdbcTemplate jdbcTemplate = null;

    @Before
    public void before(){
        super.before();
        jdbcTemplate =  (JdbcTemplate) Context.getBean("jdbcTemplate");
    }

    /**
     * 获取单个列的值, 或做统计查询
     * 使用 queryForObject(String sql, Class<Long> requiredType)
     */
    @Test
    public void testCount(){
        String sql ="select count(*) from tbl_hbm_operation_log";

        Long count = jdbcTemplate.queryForObject(sql,Long.class);

        System.out.println("业务日志数:"+count);

    }

    /**
     * 查到实体类的集合
     * 注意调用的不是 queryForList 方法
     */
    @Test
    public void testQueryForList(){
        String sql = "SELECT \n" +
                "    ID,\n" +
                "    USERNAME,\n" +
                "    ADDRESS,\n" +
                "    START_TIME,\n" +
                "    END_TIME,\n" +
                "    URI,\n" +
                "    OPERATION_TYPE,\n" +
                "    OPERATION_NAME,\n" +
                "    OPERATION_PARAM,\n" +
                "    RESULT,\n" +
                "    MSG\n" +
                "FROM tbl_hbm_operation_log t where t.id > ?";


        RowMapper<BusinessLog> rowMapper = new BeanPropertyRowMapper<>(BusinessLog.class);
        List<BusinessLog> list = jdbcTemplate.query(
                sql,
                rowMapper,
                2);

        System.out.println(list);
    }




    /**
     * 执行批量更新: 批量的 INSERT, UPDATE, DELETE
     * 最后一个参数是 Object[] 的 List 类型: 因为修改一条记录需要一个 Object 的数组, 那么多条不就需要多个 Object 的数组
     */
    @Test
    public void testBatchUpdate(){
        String sql = "INSERT INTO tbl_hbm_user " +
                "(userid,\n" +
                "username,\n" +
                "email,\n" +
                "password)\n" +
                "VALUES\n" +
                "(?," +
                "?," +
                "?," +
                "?);";

        List<Object[]> batchArgs = new ArrayList<>();

        batchArgs.add(new Object[]{11,"AA","aa@atguigu.com", 1});
        batchArgs.add(new Object[]{22,"BB", "bb@atguigu.com", 2});
        batchArgs.add(new Object[]{33,"CC", "cc@atguigu.com", 3});
        batchArgs.add(new Object[]{44,"DD", "dd@atguigu.com", 3});
        batchArgs.add(new Object[]{55,"EE", "ee@atguigu.com", 2});

        jdbcTemplate.batchUpdate(
                sql,
                batchArgs);
    }

    /**
     * 执行 INSERT, UPDATE, DELETE
     */
    @Test
    public void testUpdate(){


        String sql = "UPDATE tbl_hbm_user SET username = ? WHERE userid = ?";


        jdbcTemplate.update(
                sql,
                "Jack",
                11);
    }
}
