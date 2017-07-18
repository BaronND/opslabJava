package st2Demo.convert.ActionTest.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {
	
	public DateConverter() {
		System.out.println("DateConverter is call....");
	}
	
	private  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 该方法是在将参数从字符串转为引用类型是调用，此处以Date类型为例子
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toclass) {
		System.out.println("convertFromString..");
		Date date = null;
		if(values != null && values.length >0){
			try {
				date =  sdf.parse(values[0]);
			} catch (ParseException e) {
				e.printStackTrace();
				date = null;
			}
		}
		System.out.println("convertFromString :"+date);
		return date;
	}

	
	/**
	 * 该方法是在将参数从引用类型转为字符串类型时候调用
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map arg0, Object arg1) {
		System.out.println("convertToString...");
		String result=null;
		if(arg1 instanceof Date){
			Date date = (Date)arg1;
			result = sdf.format(date);
		}
		System.out.println("convertToString :"+result);
		return result;
	}

}
