package st2Demo.convert.instanceDemo.converter;
/**
 * @summary:
 * 	 为类st2Demo.convert.instanceDemo.model.User提供类型转换器
 * 
 * 
 * @warning:
 * 	此处还暂时未测试成功猜想
 * 		将多个字段转换成一个对象貌似不需要这样做转换
 * 
 * 	猜想：
 * 		此处是一个字符串或一个字符串数组转换成一个对象或一组对象
 * 	例如:
 * 		客户端提交如下数据：
 * 			id:username:password:role:birth
 * 		然后此处可以通过values[index]获取然后split然后new成一个对象返回
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.StrutsTypeConverter;

import st2Demo.convert.instanceDemo.model.User;


@SuppressWarnings("rawtypes")
public class UserConverter extends StrutsTypeConverter {

	public UserConverter() {
		System.out.println("UserConverter is construtor...");
	}
	
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		System.out.println("UserConverter::convertFromString is call ");
		if(toClass == User.class){
			ServletContext  contexts= ServletActionContext.getServletContext();
			String pattern = contexts.getInitParameter("datePattern");
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			User user = new User();
			try {
				String[] arr = values[0].split(":");
				user.setId(Integer.parseInt(arr[0]));
				user.setUsername(arr[1]);
				user.setPassword(arr[2]);
				user.setRole(arr[3]);
				user.setBirth(sdf.parse(arr[4]));
			} catch (ParseException e) {
				user = null;
				e.printStackTrace();
			}
			return user;
		}else{
			//"目标类型不是：st2Demo.convert.instanceDemo.model.User"
			return null;
		}
	}

	@Override
	public String convertToString(Map context, Object o) {
		System.out.println("UserConverter::convertToString is call...");
		if(o instanceof User){
			return ((User)o).toString();
		}
		return (String) o;
	}

}
