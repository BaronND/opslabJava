package com.opslab.workflow.util;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 0opslab
 */
public class RegUtilTest {
    @Test
    public void testReg(){
        String hql ="select mate \n" +
                "from Cat as cat \n" +
                "    inner join cat.mate as mate";


        Pattern pattern = Pattern.compile("\\sFROM\\s",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hql);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
