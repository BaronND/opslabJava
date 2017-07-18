package app.entries;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class TaskLog {

	//业务记录主键
	@Getter  @Setter private Integer Id;
	
	//任务名称
	@Getter  @Setter private String  taskName;
	
	//业务类型
	@Getter  @Setter private String  taskType;
	
	//执行时间
	@Getter  @Setter private Date   startTime;
	
	//实现类及方法
	@Getter  @Setter private String  CodeId;
	
	//参数列表
	@Getter  @Setter private String  Params;
	
	//执行结果
	@Getter  @Setter private String  result;
	
	//附加信息
	@Getter  @Setter private String  msg;

	@Override
	public String toString() {
		return "TaskLog [Id=" + Id + "]";
	}

}
