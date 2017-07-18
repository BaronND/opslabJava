package com.opslab.framework.base.util;

import com.opslab.util.RandomUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * 自动的主键生成策略
 */
public class IDGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SessionImplementor sessionImplementor, Object o) throws HibernateException {
        return RandomUtil.squid();
    }
}
