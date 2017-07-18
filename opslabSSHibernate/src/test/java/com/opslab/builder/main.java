package com.opslab.builder;


import com.google.common.collect.ImmutableMap;
import com.opslab.util.CharsetUtil;
import com.opslab.util.FileUtil;
import com.opslab.util.StringUtil;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.util.Map;

/**
 * 代码生成�?
 */
public class main {

    public static String TEMPLATE_PATH = System.getProperty("user.dir") + "/src/test/resource/template/codetemplate";

    public static String entityName = "Menu";

    public static String entityKey = "String";

    public static String packageName = "com.opslab.framework.base";

    public static String tableName = "ops_re_menus";

    @Test
    @Ignore
    public void generateCode() throws IOException, TemplateException {
        //生成代码
        generateCode(packageName, entityName, entityKey, tableName);
    }


    @Test
    @Ignore
    public void deleteCode() {
        //删除代码
        deleteCode(packageName, entityName);
    }


    public static Configuration getFreemarkercfg() throws IOException {
        //1.创建配置实例
        //2.创建数据模型
        //3.获得模板
        //4.合并模板和数据模型

        //创建配置实例
        Configuration freemarkercfg = new Configuration();
        //设置Freemaker的模板目录
        freemarkercfg.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
        //设置检索数据的模式
        freemarkercfg.setObjectWrapper(new DefaultObjectWrapper());

        return freemarkercfg;
    }

    public static String handleTemplate(Template template, Map root) throws IOException, TemplateException {
        //合并模板和数据模型
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Writer out = new OutputStreamWriter(baos);
        template.process(root, out);
        out.flush();
        return baos.toString();
    }


    public static void deleteCode(String packageName, String entityName) {

        String BASE_PATH = (System.getProperty("user.dir") + "/src/" + packageName.replaceAll("\\.", "/"))
                .replaceAll("\\\\", "/") + "/";

        String CONF_PATH = (System.getProperty("user.dir") + "/conf/hbm")
                .replaceAll("\\\\", "/") + "/";

        String entries_file = BASE_PATH + "entity/" + entityName + ".java";
        if (FileUtil.deleteFile(new File(entries_file))) {
            System.out.println("删除文件成功[ok]\n\t\t" + entries_file);
        }


        String entries_hbm_file = CONF_PATH + entityName + ".hbm.xml";
        if (FileUtil.deleteFile(new File(entries_hbm_file))) {
            System.out.println("删除文件成功[ok]\n\t\t" + entries_hbm_file);
        }

        String dao_file = BASE_PATH + "dao/" + entityName + "Dao.java";
        if (FileUtil.deleteFile(new File(dao_file))) {
            System.out.println("删除文件成功[ok]\n\t\t" + dao_file);
        }

        String daoimpl_file = BASE_PATH + "dao/impl/" + entityName + "DaoImpl.java";
        if (FileUtil.deleteFile(new File(daoimpl_file))) {
            System.out.println("删除文件成功[ok]\n\t\t" + daoimpl_file);
        }

        String service_file = BASE_PATH + "service/" + entityName + "Service.java";
        if (FileUtil.deleteFile(new File(service_file))) {
            System.out.println("删除文件成功[ok]\n\t\t" + service_file);
        }

        String serviceImpl_file = BASE_PATH + "service/impl" + entityName + "ServiceImpl.java";
        if (FileUtil.deleteFile(new File(serviceImpl_file))) {
            System.out.println("删除文件成功[ok]\n\t\t" + serviceImpl_file);
        }

        String struts_file = BASE_PATH + "struts/action/" + entityName + "/Action.java";
        if (FileUtil.deleteFile(new File(struts_file))) {
            System.out.println("删除文件成功[ok]\n\t\t" + struts_file);
        }


    }

    /**
     * 产生通用的代码模板
     *
     * @param packageName 基础包路径
     * @param entriesName 业务实体名字
     * @param ID          业务实体主键的类型
     * @throws IOException
     */
    public static void generateCode(String packageName, String entriesName, String ID, String tableName) throws IOException, TemplateException {
        String BASE_PATH = (System.getProperty("user.dir") + "/src/main/java/" + packageName.replaceAll("\\.", "/"))
                .replaceAll("\\\\", "/") + "/";

        String CONF_PATH = (System.getProperty("user.dir") + "/conf/hbm")
                .replaceAll("\\\\", "/") + "/";

        System.out.println("==========生成通用的代码模板===========");

        Configuration freemarkercfg = getFreemarkercfg();
        /*
        //生成业务实体类
        Map<Object,Object> entriesMap =  ImmutableMap.builder()
                .put("package", packageName)
                .put("entity",entriesName)
                .put("ID",ID)
                .build();
        Template template = freemarkercfg.getTemplate("entries.ftl");
        String entriesStr = FreeMarkerFactory.handleTemplate(template, entriesMap);
        String entriesFile = BASE_PATH+"entity/"+entriesName+".java";
        if(FileUtil.write(new File(entriesFile), entriesStr, CharsetUtil.UTF_8)){
            System.out.println("生成业务实体:[ok]\n\t\t" + entriesFile);
        }

        //Hibernate配置文件模板
        Map<Object,Object> entriesHBMMap = ImmutableMap.builder()
                .put("package", packageName)
                .put("entity",entriesName)
                .put("tableName",tableName)
                .put("ID",ID)
                .build();
        Template template1 = freemarkercfg.getTemplate("entries.hbm.ftl");
        String entriesHBMStr = FreeMarkerFactory.handleTemplate(template1, entriesHBMMap);
        String entriesHBMFile = CONF_PATH + entriesName+".hbm.xml";
        if(FileUtil.write(new File(entriesHBMFile),entriesHBMStr,CharsetUtil.UTF_8)){
            System.out.println("生成业务实体Hibernate配置文件:[ok]\n\t\t"+entriesHBMFile);
        }
        */
        //Dao模板
        Map<Object, Object> entriesDao = ImmutableMap.builder()
                .put("package", packageName)
                .put("entity", entriesName)
                .put("ID", ID)
                .build();
        Template template2 = freemarkercfg.getTemplate("dao.ftl");
        String daoStr = handleTemplate(template2, entriesDao);
        String daoFile = BASE_PATH + "dao/" + entriesName + "Dao.java";
        if (FileUtil.write(new File(daoFile), daoStr, CharsetUtil.UTF_8)) {
            System.out.println("生成业务Dao:[ok]\n\t\t" + daoFile);
        }

        //DaoImpl模板
        Map<Object, Object> entriesDaoImpl = ImmutableMap.builder()
                .put("package", packageName)
                .put("entity", entriesName)
                .put("dao", StringUtil.lowerFirstChar(entriesName) + "Dao")
                .put("ID", ID)
                .build();
        Template template3 = freemarkercfg.getTemplate("daoImpl.ftl");
        String daoImplStr = handleTemplate(template3, entriesDaoImpl);
        String daoImplFile = BASE_PATH + "dao/impl/" + entriesName + "DaoImpl.java";
        if (FileUtil.write(new File(daoImplFile), daoImplStr, CharsetUtil.UTF_8)) {
            System.out.println("生成业务DaoImpl:[ok]\n\t\t" + daoImplFile);
        }

        //service模板
        Map<Object, Object> entriesService = ImmutableMap.builder()
                .put("package", packageName)
                .put("entity", entriesName)
                .put("ID", ID)
                .build();
        Template template4 = freemarkercfg.getTemplate("service.ftl");
        String serviceStr = handleTemplate(template4, entriesService);
        String serviceFile = BASE_PATH + "service/" + entriesName + "Service.java";
        if (FileUtil.write(new File(serviceFile), serviceStr, CharsetUtil.UTF_8)) {
            System.out.println("生成业务Service:[ok]\n\t\t" + serviceFile);
        }

        //serviceImpl模板
        Map<Object, Object> entriesServiceImpl = ImmutableMap.builder()
                .put("package", packageName)
                .put("entity", entriesName)
                .put("ID", ID)
                .put("dao", StringUtil.lowerFirstChar(entriesName) + "Dao")
                .put("daoClass", entriesName + "Dao")
                .put("service", StringUtil.lowerFirstChar(entriesName) + "Service")
                .put("ServiceClass", entriesName + "Service")
                .build();
        Template template5 = freemarkercfg.getTemplate("serviceImpl.ftl");
        String serviceImplStr = handleTemplate(template5, entriesServiceImpl);
        String serviceImplFile = BASE_PATH + "service/impl/" + entriesName + "ServiceImpl.java";
        if (FileUtil.write(new File(serviceImplFile), serviceImplStr, CharsetUtil.UTF_8)) {
            System.out.println("生成业务ServiceImpl:[ok]\n\t\t" + serviceImplFile);
        }


    }

}


