package com.opslab.framework.base.dao.impl;

import org.springframework.stereotype.Repository;

import com.opslab.framework.base.dao.TaskLogDao;
import com.opslab.framework.base.entity.TaskLog;


/**
 * @author 0opslab
 */
@Repository("taskLogDao")
public class TaskLogDaoImpl  extends SupportDaoImpl<TaskLog,String>  implements TaskLogDao {
}
