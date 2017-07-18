package com.opslab.framework.cache.impl;

import com.opslab.framework.base.entity.Deptments;
import com.opslab.framework.base.entity.GeneralCode;
import com.opslab.framework.base.entity.UserInfo;
import com.opslab.framework.base.service.DeptmentsService;
import com.opslab.framework.base.service.GeneralCodeService;
import com.opslab.framework.base.service.UserInfoService;
import com.opslab.framework.cache.CommonCache;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 简单的以集合对象做缓存
 *
 */
@Component("commonCache")
public class CommonCacheImpl implements CommonCache,ApplicationListener {

    private static final Map<String, GeneralCode> codes = new HashMap<>();

    private static final Map<String,String> depts= new HashMap<>();

    private static  ApplicationContext applicationContext;

    @Override
    public String deptName(String detpId) {
        String deptName = depts.get(detpId);
        if(deptName == null )
            return "";
        return deptName;
    }

    @Override
    public String codeName(String codeType, String codeId) {
        GeneralCode code = codes.get(codeType + "::" + codeId);
        if(code != null){
            return code.getCodeName();
        }
        return "";
    }


    @Override
    public String userName(String userId) {
        UserInfoService userService = (UserInfoService) applicationContext.getBean("userService");
        UserInfo userInfo = userService.get(userId);
        if(userInfo != null){
            return userInfo.getUserName();
        }
        return "";
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent != null && applicationEvent instanceof ContextRefreshedEvent) {
            if (((XmlWebApplicationContext) applicationEvent.getSource())
                    .getDisplayName()
                    .equals("Root WebApplicationContext")) {
                //应用程序初始化的时候讲需要缓存的东西加载进来
                applicationContext =
                        ((ContextRefreshedEvent) applicationEvent).getApplicationContext();

                GeneralCodeService generalCodeService =
                        (GeneralCodeService) applicationContext.getBean("generalCodeService");
                List<GeneralCode> list = generalCodeService.getGeneralList();
                if (list != null && list.size() > 0) {
                    for (Object obj : list) {
                        GeneralCode code = (GeneralCode) obj;
                        codes.put(code.getCodeType() + "::" + code.getCodeId(), code);
                    }
                }

                DeptmentsService deptmentsService =
                        (DeptmentsService) applicationContext.getBean("deptmentsService");
                List<Deptments> deptmentses = deptmentsService.deptList();
                if(deptmentses != null && deptmentses.size() > 0){
                    for(Deptments dept:deptmentses){
                        depts.put(dept.getDeptId(),dept.getDetpName());
                    }
                }

            }
        }
    }
}
