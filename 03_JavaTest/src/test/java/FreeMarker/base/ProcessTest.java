package FreeMarker.base;


import app.APP;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * <h6>Description:<h6>
 * <p>测试Freemaker的流程控制</p>
 *
 * @date 2015-06-18.
 */
public class ProcessTest {
    @org.junit.Test
    public void testProcess() throws IOException, TemplateException {
        //1.创建配置实例
        //2.创建数据模型
        //3.获得模板
        //4.合并模板和数据模型

        //创建配置实例
        Configuration freemarkercfg = new Configuration();
        //设置Freemaker的模板目录
        freemarkercfg.setDirectoryForTemplateLoading(new File(APP.FREEMAKER_RESOURCE_PATH));
        //设置检索数据的模式
        freemarkercfg.setObjectWrapper(new DefaultObjectWrapper());


        //创建数据模型
        Map root = new HashMap();
        int pirce = (int) (Math.random() * 20000);
        root.put("pirce", pirce);

        //获取模板
        Template template = freemarkercfg.getTemplate("FreemarkerIFELSE.ftl");

        //合并模板和数据模型
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Writer out = new OutputStreamWriter(baos);
        template.process(root, out);
        out.flush();

        String result = baos.toString();
        System.out.println(result);
    }
}
