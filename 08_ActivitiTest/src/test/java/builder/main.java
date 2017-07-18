package builder;

import builder.generate.DeleteCode;
import builder.generate.GenerateCode;
import freemarker.template.TemplateException;
import org.junit.Ignore;
import org.junit.Test;


import java.io.IOException;

/**
 * 代码生成器
 */
public class main {

    public static String entityName ="UserInfo";

    public static String entityKey ="String";

    public static String packageName ="app.core";

    public static String tableName ="tbl_hbm_userinfo";

    @Test
    @Ignore
    public void generateCode() throws IOException, TemplateException {
        //生成代码
        GenerateCode.generateCode(packageName,entityName,entityKey,tableName);
    }


    @Test
    @Ignore
    public void deleteCode(){
        //删除代码
        DeleteCode.deleteCode(packageName,entityName);
    }

}
