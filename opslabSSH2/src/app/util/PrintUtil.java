package app.util;

import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author admins
 * @Intro 在控制台打印一些信息，方便调试 
 */
public class PrintUtil {
	public static boolean debug = true;
	
	public static void print(Object str){
		if(debug){
			System.out.println(str);
		}
	}
	
	public static void printList(List<?> list){
		Iterator<?> iterator = list.iterator();
		while(iterator.hasNext()){
			print(iterator.next());
		}
	}
}
