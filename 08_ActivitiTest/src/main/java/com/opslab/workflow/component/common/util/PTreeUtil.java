package com.opslab.workflow.component.common.util;

import java.util.ArrayList;
import java.util.List;

import com.opslab.workflow.framework.entity.view.UiPTree;

/**
 * 父子节点包含JSON数据相关的工具类
 * @author 0opslab
 * @date on 2016/4/21 0021.
 */
public class PTreeUtil {
    public static List<UiPTree> packListForJson(List<UiPTree> pList, List<UiPTree> cList){
        List<UiPTree> r = new ArrayList<UiPTree>();
        List<UiPTree> t = new ArrayList<UiPTree>();
        if(pList != null && pList.size() > 0){
            for(UiPTree p:pList){
                r.add(p);
                for(UiPTree pp:pList){
                    if(p.getId().equals(pp.getpId())){
                        p.addChild(pp);
                    }
                }
                for(UiPTree c:cList){
                    if(p.getId().toString().equals(c.getpId())){
                        p.addChild(c);
                    }
                }
            }
        }
        r.removeAll(t);
        return r;
    }
}
