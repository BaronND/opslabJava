package webServices.base.client;

import java.util.List;

import webServices.base.client.demo03.ArrayOfString;
import webServices.base.client.demo03.WeatherWebService;
import webServices.base.client.demo03.WeatherWebServiceSoap;

public class weather {
	public static void main(String[] args){
		
		/**
		 * 从这个地址获取天气信息
		 * http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl
		 */
		
		/**
		 * 此处的工厂类的名字是wsdl文档中的service部分的内容
		 * 例如： <wsdl:service name="WeatherWebService">
		 * 则工厂类就是WeatherWebService
		 */
		WeatherWebService ser = new  WeatherWebService();
		WeatherWebServiceSoap soap = ser.getWeatherWebServiceSoap();
		ArrayOfString weather = soap.getWeatherbyCityName("西宁");
		List<String> res = weather.getString();
		System.out.println(res);
	}
}
