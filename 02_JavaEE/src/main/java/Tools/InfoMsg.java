package Tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InfoMsg {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HH:mm:ss");

	private static boolean debug = true;

	private static boolean error = true;

	public static void debug(String msg) {
		if (debug)
			System.out.println(sdf.format(new Date()) + " debug:" + msg);
	}

	public static void error(String msg) {
		if (error)
			System.out.println(sdf.format(new Date()) + " debug:" + msg);
	}

	public static void list(List<?> list) {
		if (debug) {
			System.out.println("==============================");
			Iterator<?> iter = list.iterator();
			while (iter.hasNext()) {
				System.out.println(iter.next());
			}
			System.out.println("==============================");
		}
	}

	public static void map(Map<?, ?> map) {
		if (debug) {
			System.out.println("==============================");
			for (Object key : map.keySet()) {
				System.out.println(key + "=>" + map.get(key));
			}
			System.out.println("==============================");
		}
	}
}
