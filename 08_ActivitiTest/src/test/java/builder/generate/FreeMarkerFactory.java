package builder.generate;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerFactory {

    public static String  TEMPLATE_PATH =System.getProperty("user.dir")+"/coder/builder/template/";

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

    public static String handleTemplate(Template template,Map root) throws IOException, TemplateException {
        //合并模板和数据模型
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Writer out = new OutputStreamWriter(baos);
        template.process(root, out);
        out.flush();
        return baos.toString();
    }


}
