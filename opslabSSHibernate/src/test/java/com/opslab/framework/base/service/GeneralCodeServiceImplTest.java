package com.opslab.framework.base.service;

import com.opslab.framework.SpringTest;
import com.opslab.framework.base.entity.GeneralCode;
import com.opslab.util.DateUtil;
import com.opslab.util.JacksonUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author 0opslab
 * @date on 2016/6/28 0028.
 */
public class GeneralCodeServiceImplTest extends SpringTest{
    private GeneralCodeService  service;

    @Before
    public void before(){
        super.before();
        service = (GeneralCodeService) Context.getBean("generalCodeService");
    }

    @Test
    public void testcodeTypeList(){
        List<GeneralCode> user_type = service.codeTypeList("USER_TYPE");
        System.out.println(JacksonUtil.toJSON(user_type));
    }

    @Test
    public void testCodeSave(){
        GeneralCode code = new GeneralCode();
        code.setCodeId("USER_TYPE_04");
        code.setCodeName("VIP用户");
        code.setCodeType("USER_TYPE");
        code.setOrderId(String.valueOf(4));
        code.setMemo("开通VIP的用户");
        code.setValid("1");
        code.setTree("COMMON");
        code.setCreateTime(DateUtil.currentDateTime());

        service.save(code);
    }
}