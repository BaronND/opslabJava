package com.opslab.framework.base.service.impl;

import org.springframework.stereotype.Service;

import com.opslab.framework.base.entity.Rights;
import com.opslab.framework.base.service.RightsService;

/**
 * @author 0opslab
 * 权限相关的操作
 */
@Service("rightsService")
@SuppressWarnings("rawtypes")
public class RightsServiceImpl extends SupportServiceImpl<Rights,Integer> implements RightsService{

}
