package FreeMarker;

import FreeMarker.model.Product;
import app.APP;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * <h6>Description:<h6>
 * <p>使用Freemaker的一般实例</p>
 */
public class UseFreemarkerDemo {

    @Test
    public void test() throws IOException, TemplateException {
        //1.创建配置实例
        //2.创建数据模型
        //3.获得模板
        //4.合并模板和数据模型

        //创建配置实例
        Configuration freemarkercfg = new Configuration();
        //设置Freemarker的模板目录
        freemarkercfg.setDirectoryForTemplateLoading(new File(APP.FREEMAKER_RESOURCE_PATH));
        //设置检索数据的模式
        freemarkercfg.setObjectWrapper(new DefaultObjectWrapper());


        //创建数据模型
        Map root = new HashMap();

        String title = "FreeMaker test";
        root.put("title", title);


        String user = "FreeMaker's user";
        root.put("user", user);

        Product product = new Product("FreeMaker test", "http://freemarker.org/");
        root.put("product", product);

        //获取模板
        Template template = freemarkercfg.getTemplate("FreemarkerDemo1.ftl");

        //合并模板和数据模型
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Writer out = new OutputStreamWriter(baos);
        template.process(root, out);
        out.flush();
        out.close();
        String result = baos.toString();
        System.out.println(result);
    }

    /**
     * 一些主要为性能测试
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException, TemplateException {
        //1.创建配置实例
        //2.创建数据模型
        //3.获得模板
        //4.合并模板和数据模型

        //创建配置实例
        Configuration freemarkercfg = new Configuration();
        //设置Freemarker的模板目录
        freemarkercfg.setDirectoryForTemplateLoading(new File(APP.FREEMAKER_RESOURCE_PATH));
        //设置检索数据的模式
        freemarkercfg.setObjectWrapper(new DefaultObjectWrapper());


        for (int i = 0; i < 100000; i++) {
            //创建数据模型
            Map root = new HashMap();

            String title = "FreeMaker test";
            root.put("title", title);


            String user = "FreeMaker's user";
            root.put("user", user);

            Product product = new Product("FreeMaker test", "http://freemarker.org/");
            root.put("product", product);

            //获取模板
            Template template = freemarkercfg.getTemplate("FreemarkerDemo1.ftl");

            //合并模板和数据模型
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Writer out = new OutputStreamWriter(baos);
            template.process(root, out);
            out.flush();
            String result = baos.toString();
            System.out.println(result);
        }

    }

}
