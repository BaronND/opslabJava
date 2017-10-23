package com.opslab.serviceimpl;

import com.mysql.jdbc.log.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;

import javax.annotation.Resource;

/**
 * Created by 0opslab
 */
public class SuperService {
    /**
     * 此处直接注入Mybatis的SqlSession能超级灵活的使用mybatis
     * 也可以将SQL完全充代码中隔离出来。（全部在Mapper文件中）
     */
//    @Resource(name = "sqlSession")
//    protected SqlSession session;

    /**
     * 返回Mapper配置的包命名
     * @param t
     * @return
     */
    public static String mapperPackage(Class t,String method){
        return t.getName()+".";
    }

}
