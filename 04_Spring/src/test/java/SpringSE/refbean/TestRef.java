package SpringSE.refbean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;

import SpringSE.Context;

public class TestRef {

	private String patter;
	
	private SimpleDateFormat sdf2;
	
	public SimpleDateFormat getSdf2() {
		return sdf2;
	}

	public void setSdf2(SimpleDateFormat sdf2) {
		this.sdf2 = sdf2;
	}

	public String getPatter() {
		return patter;
	}

	public void setPatter(String patter) {
		this.patter = patter;
	}
	
	public void info(){
		SimpleDateFormat sdf = new SimpleDateFormat(patter);
		System.out.println(sdf.format(new Date()));
		System.out.println(sdf2.format(new Date()));
	}

	public static void main(String[] args) {
		ApplicationContext ctx = Context.getAppContext();
		TestRef test = (TestRef)ctx.getBean("year");
		test.info();
		TestRef test1 =(TestRef) ctx.getBean("time");
		test1.info();
	}

}
