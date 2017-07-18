package com.opslab.framework.base.service.impl;

import com.opslab.framework.base.entity.TaskLog;
import com.opslab.framework.base.service.TaskLogService;
import org.springframework.stereotype.Service;

/**
 * @author 0opslab
 */
@Service("taskLogService")
public class TaskServiceImpl extends SupportServiceImpl<TaskLog,String> implements TaskLogService {

}
