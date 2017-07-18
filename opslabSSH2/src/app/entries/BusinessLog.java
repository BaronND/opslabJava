package app.entries;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @summary: 业务层的日志
 */
public class BusinessLog {

	@Getter @Setter private Long id;

	@Getter @Setter private String uri;

	@Getter @Setter private String userName;

	@Getter @Setter private String address;

	@Getter @Setter private Date startTime = new Date();
	
	@Getter @Setter private Date endTime = new Date();

	@Getter @Setter private String operationName;

	@Getter @Setter private String operationParam;
	
	@Getter @Setter private String type;

	@Getter @Setter private String result;

	@Getter @Setter private String msg;

	@Override
	public String toString() {
		return " ["+(endTime.getTime() - startTime.getTime())+" - "+ result+"] -> "+operationName+"("+operationParam+")";
	}

}
