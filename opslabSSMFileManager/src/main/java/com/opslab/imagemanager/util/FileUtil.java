package com.opslab.imagemanager.util;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.UUID;


/**
 * 文件路径相关的工具类
 */
public final class FileUtil {
    /**
     * 整理文件路径
     * 例如将 c:/tmp/uploadfile\header\crop20 整理为 c:/tmp/uploadfile/header/crop20
     * 将 c:/tmp//uploadfile\header\\crop20 整理为 c:/tmp/uploadfile/header/crop20
     *
     * @param path
     * @return
     */
    public static String path(String path) {
        return path.replaceAll("\\\\{1,}", "/").replaceAll("\\/{2,}", "/");
    }


    /**
     * 返回大写的uuid字符串
     *
     * @return
     */
    public static String UUID() {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        String temp = s.substring(0, 8) + s.substring(9, 13) +
                s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
        return temp.toUpperCase();
    }


    /**
     * 获取文件后缀
     *
     * @param fileName
     * @return
     */
    public static String suffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".")+1);
    }

    /**
     * 判断文件的后缀是否合法
     * @param suffixs
     * @param fileName
     * @return
     */
    public static boolean isLegalSuffix(String suffixs,String fileName){
        String file_suffix = suffix(fileName);
        if(suffixs != null){
            String[] tt = suffixs.split(",");
            for(int i=0;i<tt.length;i++){
                if(file_suffix.equalsIgnoreCase(tt[i].trim())){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 判断是否为图片文件
     * @param input
     * @return
     */
    public static boolean isImage(InputStream input){
        try (ImageInputStream iis = ImageIO.createImageInputStream(input)) {
            Iterator iter = ImageIO.getImageReaders(iis);
            if (iter.hasNext()) {
                return true;
            }
            return false;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }
    /**
     * 判断一个文件是否为图片文件
     * @param file
     * @return
     */
    public static boolean isImage(String file) {

        try (ImageInputStream iis = ImageIO.createImageInputStream(new File(file))) {
            Iterator iter = ImageIO.getImageReaders(iis);
            if (iter.hasNext()) {
                return true;
            }
            return false;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    /**
     * 获取文件的hash值
     * hashType的值："MD5"，"SHA1"，"SHA-256"，"SHA-384"，"SHA-512"
     */
    private static String fileHash(String fileName, String hashType)  {
        try(InputStream fis = new FileInputStream(fileName)){
            inputHash(fis,hashType);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String inputHash(InputStream input,String hashType){
        try{
            byte buffer[] = new byte[1024];
            MessageDigest md5 = MessageDigest.getInstance(hashType);
            for(int numRead = 0; (numRead = input.read(buffer)) > 0;) {
                md5.update(buffer, 0, numRead);
            }
            return StringUtil.bytesToHexString(md5.digest());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(path("c:/tmp/uploadfile\\header\\crop20"));
        System.out.println(path("c:/tmp//uploadfile\\header\\\\crop20"));

        System.out.println(suffix("Spring Cloud.exe.docx"));
        System.out.println(suffix("Spring Cloud.docx"));


        System.out.println(isImage("C:/Users/Administrator/Desktop/th.jpg"));
        System.out.println(isImage("C:/Users/Administrator/Desktop/2B7Q0K3HR92K.jpg"));
        System.out.println(isImage("C:/Users/Administrator/Desktop/Spring Cloud.docx"));

        System.out.println(fileHash("C:/Users/Administrator/Desktop/th.jpg","MD5"));
        System.out.println(fileHash("C:/Users/Administrator/Desktop/2B7Q0K3HR92K.jpg","MD5"));
        System.out.println(fileHash("C:/Users/Administrator/Desktop/Spring Cloud.docx","MD5"));

        System.out.println(fileHash("C:/Users/Administrator/Desktop/th.jpg","SHA-256"));
        System.out.println(fileHash("C:/Users/Administrator/Desktop/2B7Q0K3HR92K.jpg","SHA-256"));
        System.out.println(fileHash("C:/Users/Administrator/Desktop/Spring Cloud.docx","SHA-256"));

        System.out.println(fileHash("C:/Users/Administrator/Desktop/th.jpg","SHA-384"));
        System.out.println(fileHash("C:/Users/Administrator/Desktop/2B7Q0K3HR92K.jpg","SHA-384"));
        System.out.println(fileHash("C:/Users/Administrator/Desktop/Spring Cloud.docx","SHA-384"));

    }


}
