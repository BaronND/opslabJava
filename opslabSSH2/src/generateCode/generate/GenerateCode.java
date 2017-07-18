package generateCode.generate;


import com.google.common.collect.ImmutableMap;
import evilp0s.CharsetUtil;
import evilp0s.FileUtil;
import evilp0s.StringUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class GenerateCode {
    public static String BASE_PATH = System.getProperty("user.dir")+"/src/app/";

    public static String CONF_PATH = System.getProperty("user.dir")+"/conf/";
    /**
     * 产生通用的代码模板
     *
     *
     * @param entriesName 业务尸体名字
     */
    public static void generateCode(String entriesName) throws IOException, TemplateException {


        System.out.println("==========生成通用的代码模板===========");

        Configuration freemarkercfg = FreeMarkerFactory.getFreemarkercfg();

        //生成业务实体类
        Map<Object,Object> entriesMap =  ImmutableMap.builder().put("entries", entriesName).build();
        Template template = freemarkercfg.getTemplate("entries.ftl");
        String entriesStr = FreeMarkerFactory.handleTemplate(template, entriesMap);
        String entriesFile = BASE_PATH+"entries/"+entriesName+".java";
        if(FileUtil.write(new File(entriesFile), entriesStr, CharsetUtil.UTF_8)){
            System.out.println("生成业务实体:[ok]\n\t\t" + entriesFile);
        }

        //Hibernate配置文件模板
        Map<Object,Object> entriesHBMMap = ImmutableMap.builder().put("entries",entriesName).build();
        Template template1 = freemarkercfg.getTemplate("entries.hbm.ftl");
        String entriesHBMStr = FreeMarkerFactory.handleTemplate(template1, entriesHBMMap);
        String entriesHBMFile = CONF_PATH+"hbm/"+entriesName+".hbm.xml";
        if(FileUtil.write(new File(entriesHBMFile),entriesHBMStr,CharsetUtil.UTF_8)){
            System.out.println("生成业务实体Hibernate配置文件:[ok]\n\t\t"+entriesHBMFile);
        }

        //Dao模板
        Map<Object,Object> entriesDao = ImmutableMap.builder().put("entries",entriesName).build();
        Template template2 = freemarkercfg.getTemplate("dao.ftl");
        String daoStr = FreeMarkerFactory.handleTemplate(template2, entriesDao);
        String daoFile = BASE_PATH+"dao/"+entriesName+"Dao.java";
        if(FileUtil.write(new File(daoFile),daoStr,CharsetUtil.UTF_8)){
            System.out.println("生成业务Dao:[ok]\n\t\t"+daoFile);
        }

        //DaoImpl模板
        Map<Object,Object> entriesDaoImpl = ImmutableMap.builder().put("entries", entriesName)
                .put("entriesDao", StringUtil.lowerFirstChar(entriesName) + "Dao").build();
        Template template3 = freemarkercfg.getTemplate("daoImpl.ftl");
        String daoImplStr = FreeMarkerFactory.handleTemplate(template3, entriesDaoImpl);
        String daoImplFile = BASE_PATH+"dao/impl/"+entriesName+"DaoImpl.java";
        if(FileUtil.write(new File(daoImplFile),daoImplStr,CharsetUtil.UTF_8)){
            System.out.println("生成业务DaoImpl:[ok]\n\t\t"+daoImplFile);
        }

        //service模板
        Map<Object,Object> entriesService = ImmutableMap.builder().put("entries", entriesName).build();
        Template template4 = freemarkercfg.getTemplate("service.ftl");
        String serviceStr = FreeMarkerFactory.handleTemplate(template4, entriesService);
        String serviceFile = BASE_PATH+"service/"+entriesName+"Service.java";
        if(FileUtil.write(new File(serviceFile),serviceStr,CharsetUtil.UTF_8)){
            System.out.println("生成业务Service:[ok]\n\t\t"+serviceFile);
        }

        //serviceImpl模板
        Map<Object,Object> entriesServiceImpl = ImmutableMap.builder().put("entries", entriesName)
                .put("entriesDao", StringUtil.lowerFirstChar(entriesName) + "Dao")
                .put("entriesService",StringUtil.lowerFirstChar(entriesName)+"Service").build();
        Template template5 = freemarkercfg.getTemplate("serviceImpl.ftl");
        String serviceImplStr = FreeMarkerFactory.handleTemplate(template5, entriesServiceImpl);
        String serviceImplFile = BASE_PATH+"service/impl/"+entriesName+"ServiceImpl.java";
        if(FileUtil.write(new File(serviceImplFile),serviceImplStr,CharsetUtil.UTF_8)){
            System.out.println("生成业务ServiceImpl:[ok]\n\t\t"+serviceImplFile);
        }

        //strcutAction
        Map<Object,Object> entriesAction = ImmutableMap.builder().put("entries", entriesName)
                .put("entriesAction", StringUtil.lowerFirstChar(entriesName) + "Action")
                .put("entriesService",StringUtil.lowerFirstChar(entriesName)+"Service").build();
        Template template6 = freemarkercfg.getTemplate("strutsAction.ftl");
        String structsStr = FreeMarkerFactory.handleTemplate(template6, entriesAction);
        String structsFile = BASE_PATH+"struts/action/"+entriesName+"Action.java";
        if(FileUtil.write(new File(structsFile),structsStr,CharsetUtil.UTF_8)){
            System.out.println("生成业务Action:[ok]\n\t\t"+structsFile);
        }
    }
}
