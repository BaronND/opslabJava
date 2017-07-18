package generateCode.generate;

import evilp0s.FileUtil;

import java.io.File;

public class DeleteCode {
    public static String BASE_PATH = System.getProperty("user.dir")+"/src/app/";

    public static String CONF_PATH = System.getProperty("user.dir")+"/conf/";


    public static void deleteCode(String entriesName){

        String entries_file = BASE_PATH+"entries/"+entriesName+".java";
        if(FileUtil.deleteFile(new File(entries_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + entries_file);
        }


        String entries_hbm_file = CONF_PATH+"hbm/"+entriesName+".hbm.xml";
        if(FileUtil.deleteFile(new File(entries_hbm_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + entries_hbm_file);
        }

        String dao_file =BASE_PATH+"dao/"+entriesName+"Dao.java";
        if(FileUtil.deleteFile(new File(dao_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + dao_file);
        }

        String daoimpl_file = BASE_PATH+"dao/impl/"+entriesName+"DaoImpl.java";
        if(FileUtil.deleteFile(new File(daoimpl_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + daoimpl_file);
        }

        String service_file = BASE_PATH+"service/"+entriesName+"Service.java";
        if(FileUtil.deleteFile(new File(service_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + service_file);
        }

        String serviceImpl_file = BASE_PATH+"service/impl"+entriesName+"ServiceImpl.java";
        if(FileUtil.deleteFile(new File(serviceImpl_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + serviceImpl_file);
        }

        String struts_file = BASE_PATH+"struts/action/"+entriesName+"/Action.java";
        if(FileUtil.deleteFile(new File(struts_file))){
            System.out.println("删除文件成功[ok]\n\t\t" + struts_file);
        }


    }
}
