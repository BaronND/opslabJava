package jvm.classload.classLoader;

public class ClassLoaderStruct {
	public static void main(String[] args) {
		// Launcher and bootstrap classloader
		System.out.println("Launcher's classLoader -> " + sun.misc.Launcher.getLauncher().getClass().getClassLoader());
	}
}

