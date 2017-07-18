package builder.generate;

import com.opslab.FileUtil;

import java.io.File;

public class DeleteCode {

    public static void deleteCode(String packageName,String entityName){

        String BASE_PATH = (System.getProperty("user.dir")+"/src/"+packageName.replaceAll("\\.","/"))
                .replaceAll("\\\\","/")+"/";

        String CONF_PATH = (System.getProperty("user.dir")+"/conf/hbm")
                .replaceAll("\\\\", "/")+"/";

        String entries_file = BASE_PATH+"entity/"+entityName+".java";
        if(FileUtil.deleteFile(new File(entries_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + entries_file);
        }


        String entries_hbm_file = CONF_PATH + entityName+".hbm.xml";
        if(FileUtil.deleteFile(new File(entries_hbm_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + entries_hbm_file);
        }

        String dao_file =BASE_PATH+"dao/"+entityName+"Dao.java";
        if(FileUtil.deleteFile(new File(dao_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + dao_file);
        }

        String daoimpl_file = BASE_PATH+"dao/impl/"+entityName+"DaoImpl.java";
        if(FileUtil.deleteFile(new File(daoimpl_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + daoimpl_file);
        }

        String service_file = BASE_PATH+"service/"+entityName+"Service.java";
        if(FileUtil.deleteFile(new File(service_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + service_file);
        }

        String serviceImpl_file = BASE_PATH+"service/impl"+entityName+"ServiceImpl.java";
        if(FileUtil.deleteFile(new File(serviceImpl_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + serviceImpl_file);
        }

        String struts_file = BASE_PATH+"struts/action/"+entityName+"/Action.java";
        if(FileUtil.deleteFile(new File(struts_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + struts_file);
        }


    }
}
