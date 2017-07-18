package generateCode;

import freemarker.template.TemplateException;
import generateCode.generate.DeleteCode;
import generateCode.generate.GenerateCode;
import org.junit.Test;


import java.io.IOException;

/**
 * 代码生成器
 */
public class main {

    public static String entriesName ="Blog";



    @Test
    public void generateCode() throws IOException, TemplateException {
        //生成代码
        GenerateCode.generateCode(entriesName);
    }


    @Test
    public void deleteCode(){
        //删除代码
        DeleteCode.deleteCode(entriesName);
    }

}
