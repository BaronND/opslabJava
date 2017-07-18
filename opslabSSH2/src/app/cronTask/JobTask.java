package app.cronTask;

import org.springframework.stereotype.Service;

import app.annotation.ServiceMethod;
import app.annotation.ServiceType;


@Service("jobTask")
public class JobTask {
	@ServiceMethod(type=ServiceType.TASK_NONE,name="定时任务测试")
	public void task(){
		System.out.println("Spring Task实现定时任务....");
	}
}
