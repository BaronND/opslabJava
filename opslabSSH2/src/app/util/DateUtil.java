package app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import app.constant.constant;

public class DateUtil {
	private static final SimpleDateFormat DATE_DAYTIME = new SimpleDateFormat(constant.DATE_DAYTIME);
	private static final SimpleDateFormat DATE_YEARMONTH = new SimpleDateFormat(constant.DATE_YEARMONTH);
	private static final SimpleDateFormat DATE_YEARDAY = new SimpleDateFormat(constant.DATE_YEARDAY);
	private static final SimpleDateFormat DATE_YEAR = new SimpleDateFormat(constant.DATE_YEAR);
	private static final SimpleDateFormat DATE_TIME = new SimpleDateFormat(constant.DATE_TIME);
	
	/**
	 * DATE_FORMAT方式返回字符串的时间表示
	 */
	public static String getDateTime(Date date){
		return DATE_DAYTIME.format(date);
	}
	
	/**
	 * DATE_YEARMONTH方式返回时间串
	 */
	public static String getYearMonth(Date date){
		return DATE_YEARMONTH.format(date);
	}
	
	/**
	 * DATE_YEARDAY方式返回时间串
	 */
	public static String getYearDay(Date date){
		return DATE_YEARDAY.format(date);
	}
	
	public static String getYear(Date date){
		return DATE_YEAR.format(date);
	}
	
	public static String getTime(Date date){
		return DATE_TIME.format(date);
	}
}
