package keyword_20200107;


public class KeyWord {
	/**
	 * Java平台有个用户和本地C代码进行互操作的API，称为Java Native Interface (Java本地接口)。
	 * 
	 * 使用native关键字说明这个方法是原生函数，也就是这个方法是用C/C++语言实现的，并且被编译成了DLL，由java去调用。
	 * 对于不同的平台它们也是不同的。这也是java的底层机制，实际上java就是在不同的平台上调用不同的native方法实现对操作系统的访问的。
	 * 
	 * native的意思就是通知操作系统，这个函数你必须给我实现，因为我要使用。
	 * 所以native关键字的函数都是操作系统实现的，java只能调用。
	 * 
	 * java是跨平台的语言，既然是跨了平台，所付出的代价就是牺牲一些对底层的控制，
	 * 而java要实现对底层的控制，就需要一些其他语言的帮助，这个就是native的作用了.
	 * 
	 * Java不是完美的，Java的不足除了体现在运行速度上要比传统的C++慢许多之外，Java无法直接访问到操作系统底层（如系统硬件等)，
	 * 为此Java使用native方法来扩展Java程序的功能。
	 * 
	 * 
	 * 可以将native方法比作Java程序同Ｃ程序的接口，其实现步骤：
	 * １、在Java中声明native()方法，然后编译；
	 * ２、用javah产生一个.h文件；
	 * ３、写一个.cpp文件实现native导出方法，其中需要包含第二步产生的.h文件（注意其中又包含了JDK带的jni.h文件）；
	 * ４、将第三步的.cpp文件编译成动态链接库文件；
	 * ５、在Java中用System.loadLibrary()方法加载第四步产生的动态链接库文件，这个native()方法就可以在Java中被访问了。
	 * 
	 * JAVA本地方法适用的情况 
	 * 1.为了使用底层的主机平台的某个特性，而这个特性不能通过JAVA API访问
	 * 2.为了访问一个老的系统或者使用一个已有的库，而这个系统或这个库不是用JAVA编写的
	 * 3.为了加快程序的性能，而将一段时间敏感的代码作为本地方法实现。
	 * 
	 */
	
	public static native String callNativeMothod();
	
	public static void main(String[] args) {
		/**
		 * java.lang.UnsatisfiedLinkError(未实现时)
		 */
		KeyWord.callNativeMothod();
	}

}
