package com.opslab.framework.base.scheduler;

import org.springframework.stereotype.Service;

import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.annotation.ServiceType;


@Service("jobTask")
public class JobTask {
	@ServiceMethod(type=ServiceType.TASK_NONE,value="定时任务测试")
	public void task(){
		System.out.println("Spring Task实现定时任务....");
	}
}
