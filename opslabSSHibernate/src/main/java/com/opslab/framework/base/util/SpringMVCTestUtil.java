package com.opslab.framework.base.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 用于spring mvc测试的一些工具类
 */
public class SpringMVCTestUtil {

    public static String toString(OutputStream out){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            out.write(baos.toByteArray());
        }catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toString();
    }
}
