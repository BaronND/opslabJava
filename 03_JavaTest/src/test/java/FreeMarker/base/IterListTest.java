package FreeMarker.base;


import app.APP;
import com.google.common.collect.Lists;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h6>Description:<h6>
 * <p>测试Freemaker的List遍历</p>
 *
 * @date 2015-06-18.
 */
public class IterListTest {
    @org.junit.Test
    public void testList() throws IOException, TemplateException {
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
        List<String> list = Lists.newArrayList("Java", "Javascript", "sql", "python", "shell");
        root.put("skills", list);

        //获取模板
        Template template = freemarkercfg.getTemplate("FreemarkerList.ftl");

        //合并模板和数据模型
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Writer out = new OutputStreamWriter(baos);
        template.process(root, out);
        out.flush();

        String result = baos.toString();
        System.out.println(result);
    }
}
