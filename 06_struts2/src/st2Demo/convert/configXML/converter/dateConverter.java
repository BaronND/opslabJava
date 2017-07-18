package st2Demo.convert.configXML.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.StrutsTypeConverter;
/**
 *	@summary：
 *		通过读取web.xml文件的配置信息生成转换器 
 *
 */
@SuppressWarnings("unused")
public class dateConverter extends StrutsTypeConverter {
	
	private SimpleDateFormat sdf;
	

	public dateConverter() {
		System.out.println("dateConverter is constrator....");
	}
	
	/**
	 * 注意此处，如果直接写在构造函数中，因启动实例化顺序不同，导致读取不到web.xml的配置项
	 * @return
	 */
	public SimpleDateFormat getSdf(){
		SimpleDateFormat obj = null;
		ServletContext context = ServletActionContext.getServletContext();
		String pattern = context.getInitParameter("datePattern");
		obj = new SimpleDateFormat(pattern);
		return obj;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString( Map context, String[] values, Class toClass) {
		System.out.println("convertFromString is call ...!");
		Date date = null;
		if(values != null && values.length >0){
			try {
				date =  getSdf().parse(values[0]);
			} catch (ParseException e) {
				date = null;
				System.out.println("类型转换异常:"+e.getMessage());
			}
		}
		return date;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object o) {
		System.out.println("convertToString is call ...!");
		String result = null;
		if( o instanceof Date){
			result = getSdf().format((Date)o);
		}
		return result;
	}

}
