package com.opslab.framework.base.entity.util;

import com.opslab.framework.base.entity.view.UiPTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 0opslab
 * @date on 2016/6/15 0015.
 */
public class PTreeUtil {

    /**
     * 父子节点包含JSON数据相关的工具类
     * @param pList
     * @param cList
     * @return
     */
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
