package com.opslab.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.opslab.util.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by 0opslab
 *  凡是被Spring管理的类，实现接口 EnvironmentAware 重写方法 setEnvironment 可以在工程启动时
 *  获取到系统环境变量和application配置文件中的变量。 还有一种方式是采用注解的方式获取 @value("${变量的key值}")
 *  获取application配置文件中的变量。 这里采用第一种要方便些
 */

@Configuration
@ConditionalOnClass(com.alibaba.druid.pool.DruidDataSource.class)
@ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.alibaba.druid.pool.DruidDataSource", matchIfMissing = true)
@ServletComponentScan("com.opslab.filters")
public class DruidDataSourceConfiguration implements EnvironmentAware {

    private Logger logger = LoggerFactory.getLogger(DruidDataSourceConfiguration.class);

    private RelaxedPropertyResolver dbProperties;
    private RelaxedPropertyResolver druidProperties;

    @Override
    public void setEnvironment(Environment environment) {
        this.dbProperties = new RelaxedPropertyResolver(environment, "spring.datasource.");
        this.druidProperties = new RelaxedPropertyResolver(environment, "spring.datasource.druid.");
        logger.info("loading application properties");
    }


    @Bean     //声明其为Bean实例
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(dbProperties.getProperty("url"));
        datasource.setUsername(dbProperties.getProperty("username"));
        datasource.setPassword(dbProperties.getProperty("password"));
        datasource.setDriverClassName(dbProperties.getProperty("driverClassName"));

        datasource.setInitialSize(Integer.parseInt(druidProperties.getProperty("initialSize")));
        datasource.setMinIdle(Integer.parseInt(druidProperties.getProperty("minIdle")));
        datasource.setMaxActive(Integer.parseInt(druidProperties.getProperty("maxActive")));
        // 配置获取连接等待超时的时间
        datasource.setMaxWait(Integer.parseInt(druidProperties.getProperty("maxWait")));
        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        datasource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(druidProperties.getProperty("timeBetweenEvictionRunsMillis")));
        // 配置一个连接在池中最小生存的时间，单位是毫秒
        datasource.setMinEvictableIdleTimeMillis(Integer.parseInt(druidProperties.getProperty("minEvictableIdleTimeMillis")));
        datasource.setValidationQuery(druidProperties.getProperty("validationQuery"));
        datasource.setTestWhileIdle(Boolean.parseBoolean(druidProperties.getProperty("testWhileIdle")));
        datasource.setTestOnBorrow(Boolean.parseBoolean(druidProperties.getProperty("testOnBorrow")));
        datasource.setTestOnReturn(Boolean.parseBoolean(druidProperties.getProperty("testOnReturn")));
        datasource.setPoolPreparedStatements(Boolean.parseBoolean(druidProperties.getProperty("poolPreparedStatements")));
        datasource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(druidProperties.getProperty("maxPoolPreparedStatementPerConnectionSize")));
        datasource.setUseGlobalDataSourceStat(Boolean.parseBoolean(druidProperties.getProperty("useGlobalDataSourceStat")));
        try {
            datasource.setFilters(druidProperties.getProperty("filters"));
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(druidProperties.getProperty("connectionProperties"));

        return datasource;
    }



}
