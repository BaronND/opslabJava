package com.opslab;

import com.opslab.util.ConfigUtil;

/**
 * 一些系统的常量
 */
public final class APP {
    public static String CONFIG_PROPERTIES = "db.properties";

    public static String ACTIVEMQ_CONNECTION = ConfigUtil.loadProperties(CONFIG_PROPERTIES,"ACTIVIEMQ_CONNECTION");
}
