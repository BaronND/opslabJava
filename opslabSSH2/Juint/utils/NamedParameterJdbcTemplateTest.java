package utils;

import app.entries.User;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import services.TestUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * <h6>Description:<h6>
 * <p>NamedParameterJdbcTemplate工具类测试</p>
 *
 * @date 2015-06-10.
 */
public class NamedParameterJdbcTemplateTest extends TestUtil {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;

    @Before
    public void before(){
        super.before();
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) Context.getBean("namedParameterJdbcTemplate");
    }


    /**
     * 可以为参数起名字.
     * 1. 好处: 若有多个参数, 则不用再去对应位置, 直接对应参数名, 便于维护
     * 2. 缺点: 较为麻烦.
     */
    @Test
    public void testNamedParameterJdbcTemplate(){
        String sql = "INSERT INTO tbl_hbm_user " +
                "(userid,\n" +
                "username,\n" +
                "email,\n" +
                "password)\n" +
                "VALUES\n" +
                "(:userid," +
                ":username," +
                ":emial," +
                ":password)";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userid", 111);
        paramMap.put("username", "paramName");
        paramMap.put("emial", "xx@email.com");
        paramMap.put(
                "password",
                "passw0rd");
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    /**
     * 使用具名参数时, 可以使用 update(String sql, SqlParameterSource paramSource) 方法进行更新操作
     * 1. SQL 语句中的参数名和类的属性一致!
     * 2. 使用 SqlParameterSource 的 BeanPropertySqlParameterSource 实现类作为参数.
     */
    @Test
    public void testNamedParameterJdbcTemplate2(){
        String sql = "INSERT INTO tbl_hbm_user " +
                "(userid,\n" +
                "username,\n" +
                "email,\n" +
                "password)\n" +
                "VALUES\n" +
                "(:id," +
                ":username," +
                ":email," +
                ":password)";

        User user = new User();
        user.setId(222);
        user.setUsername("XYZ");
        user.setEmail("xyz@sina.com");
        user.setPassword("1111");

        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(sql, paramSource);
    }
}
