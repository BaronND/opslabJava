package com.opslab.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

/**
 * 获取Hibernate的session
 */
public class SuperTest  {
    public Configuration configuration ;

    public SessionFactory sessionFactory;

    public Session session;

    public Transaction tx;

    @Before
    public void before(){
        configuration  = new Configuration().configure();

        sessionFactory = configuration.buildSessionFactory();

        session = sessionFactory.openSession();

        tx = session.beginTransaction();

    }

    @After
    public void after(){
        tx.commit();

        session.close();

        sessionFactory.close();
    }
}
