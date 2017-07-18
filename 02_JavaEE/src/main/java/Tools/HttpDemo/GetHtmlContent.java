package Tools.HttpDemo;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class GetHtmlContent {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://127.0.0.1:8080/TBPWeb/products/productsTree.jsp");
//		InputStream input = url.openStream();
//		Scanner scan = new Scanner(input);
//		scan.useDelimiter("\n");
//		StringBuffer sbuf = new StringBuffer();
//		while(scan.hasNext()){
//			sbuf.append(scan.next());
//		}
//		System.out.println(sbuf.toString());
		
		URLConnection urlCon = url.openConnection();
		
		System.out.println(urlCon.getContentLength());
		System.out.println(urlCon.getContentType());
		
		
		urlCon.connect();
//		Map<String, List<String>> req_pro = urlCon.getRequestProperties();
//		Set<Map.Entry<String,List<String>>> set = req_pro.entrySet();
//		Iterator<Map.Entry<String,List<String>>> iter = set.iterator();
//		
//		while(iter.hasNext()){
//			Map.Entry<String, List<String>> temp = iter.next();
//			System.out.println(temp.getKey()+"---->"+temp.getValue());
//		}
		
	}

}
