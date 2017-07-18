package com.opslab.imagemanager.service;

import com.opslab.imagemanager.SuperServiceTest;
import com.opslab.imagemanager.domain.UploadGroup;
import com.opslab.imagemanager.util.JacksonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UplaodGroupServiceTest extends SuperServiceTest{
    @Autowired
    private UploadGroupService service;

    @Test
    public void imageGroup(){
        UploadGroup imageGroup = service.imageGroup(1111);
        String json = JacksonUtil.toJSON(imageGroup);
        System.out.println(json);

        List<UploadGroup> list = service.list();
        json = JacksonUtil.toJSON(list );
        System.out.println(json);

    }

}