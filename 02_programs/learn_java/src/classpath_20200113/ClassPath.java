package classpath_20200113;

import java.net.URL;
import java.net.URLClassLoader;


/**
 * 
 * 获取class path的方法:
 * 当前class路径 ： Class.getgetResource("");
 * 所有classpath ： this.getClassLoader().getURLs();
 * 
 */
public class ClassPath {

	public static void clazzPath(String className) {
		try {
			Class clazz = Class.forName(className);
			System.out.println(className + ".class : " + clazz.getResource(""));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void classPath() {
		URL[] urls = ((URLClassLoader)ClassPath.class.getClassLoader()).getURLs();
		int length = urls.length;
		for (int i=0; i<length; i++) {
			System.out.println(urls[i]);
		}
	}
	
	public static void main(String[] args) {
		clazzPath("org.slf4j.LoggerFactory");
		clazzPath("classpath_20200113.ClassPath");
		classPath();
	}

}
