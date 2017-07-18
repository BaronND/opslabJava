package jvm.classload.classLoader;

import java.io.*;

/**
 * 演示自动以的类加载器 
 *
 */
public class FileSystemClassLoader extends ClassLoader {
	
	//类路径
	private String rootDir;
	
	public FileSystemClassLoader(String rootDir){
		this.rootDir = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getClassData(name);
		if(classData == null){
			throw new ClassNotFoundException();
		}else{
			return defineClass(name,classData,0,classData.length);
		}
	}
	
	public byte[] getClassData(String className){
		String path = classNameToPath(className);
		try{
			InputStream ins = new FileInputStream(path);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];
			int byteNumRead = 0;
			while((byteNumRead = ins.read(buffer))!= -1){
				baos.write(buffer,0,byteNumRead);
			}
			return baos.toByteArray();
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String classNameToPath(String className){
		return rootDir + File.separatorChar + className.replace(".", File.separatorChar+".class");
	}
}
