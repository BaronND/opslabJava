package webServices.base.client;

import webServices.base.client.demo2.SystemInfo;
import webServices.base.client.demo2.SystemInfoImplService;

public class wsclient2 {
	public static void main(String[] args){
		SystemInfoImplService factory = new SystemInfoImplService();
		SystemInfo sts = factory.getSystemInfoImplPort();
		System.out.println(sts.time("yyyy-MM-dd HH:mm:ss"));
		System.out.println(sts.network());
		System.out.println(sts.mem());
	}
}
