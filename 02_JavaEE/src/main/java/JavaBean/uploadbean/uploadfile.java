package JavaBean.uploadbean;

import java.io.*; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletInputStream;

public class uploadfile {
	public void doUpload(HttpServletRequest request) throws IOException {
		
		//--将request对象的内容写入到一个文件中
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("c:\\Demo.out")));
		ServletInputStream in = request.getInputStream();
		int i = in.read();
		while (i != -1) {
			pw.print((char) i);
				i = in.read();
			}
			pw.close();
		}
}
