package com.opslab.mybatis;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class App {
    public static String CONFIG_FILE =
            System.getProperty("user.dir") + "/src/main/resources/mybatis.xml";

    protected SqlSession session;

    @Before
    public void before() throws FileNotFoundException {
        InputStream is = new FileInputStream(new File(App.CONFIG_FILE));

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        session = factory.openSession();
    }

    @After
    public void after() {
        if (session != null) {
            session.commit();
            session.close();
        }
    }
}
