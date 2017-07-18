package st2Demo.fileUpload;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	//下面的属性是下载文件是需要的几个属性，需要定义并设置getter方法
	private String contentType;
	private long contentLength;
	private String contentDisposition;
	private InputStream inputStream;
	
	public String getContentType() {
		return contentType;
	}
	public long getContentLength() {
		return contentLength;
	}
	public String getContentDisposition() {
		return contentDisposition;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	
	@Override
	public String execute() throws Exception {
		contentType = "text/xml";
		contentDisposition = "attachment;filename=web.xml";
		ServletContext servletContext =  ServletActionContext.getServletContext();
		String fileName = servletContext.getRealPath("/WEB-INF/web.xml");
		inputStream = new FileInputStream(fileName);
		contentLength = inputStream.available();
		return super.execute();
	}
}
