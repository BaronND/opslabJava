package app.dao.impl;

import org.springframework.stereotype.Repository;

import app.dao.TaskLogDao;
import app.entries.TaskLog;

@Repository("taskLogDao")
public class TaskLogDaoImpl extends SupportDaoImpl<TaskLog> implements TaskLogDao {

}
