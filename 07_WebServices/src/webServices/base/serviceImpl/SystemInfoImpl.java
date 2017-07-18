package webServices.base.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import webServices.base.service.SystemInfo;

public class SystemInfoImpl  implements SystemInfo{

	@Override
	public String time(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	@Override
	public String network() {
		return "你想要撒network：Ip:0.0.0.0";
	}

	@Override
	public String mem() {
		return "服务器内存大小0okb";
	}

}
