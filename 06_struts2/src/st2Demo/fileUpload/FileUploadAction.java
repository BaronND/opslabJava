package st2Demo.fileUpload;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	private static final long serialVersionUID = -5928577435825071568L;
	
	//表单的file字段的name值
	private  File file;
	
	//获取上传文件的contentType属性
	private  String fileContentType;
	
	//获取上传文件的名字
	private  String fileFileName;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}


	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	@Override
	public String toString() {
		return "FileUploadAction [file=" + file + ", fileContentType=" + fileContentType + ", fileFileName=" + fileFileName + "]";
	}

	@Override
	public String execute() throws Exception {
		//在action中可以通过file对象将文件写入到指定的目录
		System.out.println(this);
		return SUCCESS;
	}

}
