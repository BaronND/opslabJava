package com.opslab.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 获取配置信息相关的类
 */
public class ConfigUtil {

    private static Logger logger = Logger.getLogger(ConfigUtil.class);

    /**
     * 获取配置文件资源
     *
     * @return
     */
    public static URL findAsResource(final String path) {
        URL url = null;

        ClassLoader contextClassLoader = ClassUtil.getContextClassLoader();
        if (contextClassLoader != null) {
            url = contextClassLoader.getResource(path);
        }
        if (url != null)
            return url;

        url = ConfigUtil.class.getClassLoader().getResource(path);
        if (url != null)
            return url;

        url = ClassLoader.getSystemClassLoader().getResource(path);

        return url;
    }

    /**
     * @param path
     * @return
     */
    public static String resourcePath(final String path) {
        URL asResource = findAsResource(path);
        return new File(asResource.getFile()).getPath();
    }


    private static InputStream getConfigStream(final String path) throws RuntimeException {
        try {
            URL url = new URL(path);
            return url.openStream();
        } catch (IOException e) {
            throw new RuntimeException("Unable to open config file: " + path);
        }
    }

    /**
     * 获取资源流
     *
     * @param path
     * @return
     * @throws IOException
     */
    private static InputStream resourceStream(final String path) throws IOException {
        URL asResource = findAsResource(path);
        return asResource.openStream();
    }

    /**
     * 获取资源属性
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static Properties getConfigProperties(String path) throws IOException {
        Properties properties = new Properties();
        properties.load(resourceStream(path));
        return properties;
    }


    /**
     * 从系统属性文件中获取相应的值
     *
     * @param key key
     * @return 返回value
     */
    public final static String SystemPropertiesKey(String key) {
        return System.getProperty(key);
    }

    /**
     * 根据Key读取Value
     *
     * @param filePath 属性文件
     * @param key      需要读取的属性
     */
    public final static String GetValueByKey(String filePath, String key) {
        Properties pps = new Properties();
        try (InputStream in = new BufferedInputStream(new FileInputStream(filePath))) {
            pps.load(in);
            return pps.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final static Map<String,String> properties(InputStream in){
        Map<String,String> map = new HashMap<>();
        Properties pps = new Properties();
        try {
            pps.load(in);
        } catch (IOException e) {
            logger.error("load properties error:"+e.getMessage());
        }
        Enumeration en = pps.propertyNames();
        while (en.hasMoreElements()) {
            String strKey = (String) en.nextElement();
            String strValue = pps.getProperty(strKey);
            map.put(strKey,strValue);
        }
        return map;
    }
    /**
     * 读取Properties的全部信息
     *
     * @param filePath 读取的属性文件
     * @return 返回所有的属性 key:value<>key:value
     */
    public final static Map<String,String> GetAllProperties(String filePath) throws IOException {
        Map<String,String> map = new HashMap<>();
        Properties pps = new Properties();
        try (InputStream in = new BufferedInputStream(new FileInputStream(filePath))) {
            return properties(in);
        }catch (IOException e){
            logger.error("load properties error");
        }
        return map;
    }

    /**
     * 从properties文件中读取一个属性
     * @param filePath
     * @param key
     * @return
     */
    public static String loadProperties(String filePath,String key){
        Map<String,String> map = new HashMap<>();

        try (InputStream in = new BufferedInputStream(resourceStream(filePath))) {
            map = properties(in);
        }catch (IOException e){
            logger.error("load properties error");
        }
        return map.get(key);
    }

    /**
     * 写入Properties信息
     *
     * @param filePath 写入的属性文件
     * @param pKey     属性名称
     * @param pValue   属性值
     */
    public final static void WriteProperties(String filePath, String pKey, String pValue) throws IOException {
        Properties props = new Properties();

        props.load(new FileInputStream(filePath));
        // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
        // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
        OutputStream fos = new FileOutputStream(filePath);
        props.setProperty(pKey, pValue);
        // 以适合使用 load 方法加载到 Properties 表中的格式，
        // 将此 Properties 表中的属性列表（键和元素对）写入输出流
        props.store(fos, "Update '" + pKey + "' value");

    }

}
