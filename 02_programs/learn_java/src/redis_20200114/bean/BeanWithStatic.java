package redis_20200114.bean;

import java.io.Serializable;

public class BeanWithStatic implements Serializable {

	private static final long serialVersionUID = 4L;
	
	public static int privateStaticInt = 110;
	public static String privateStaticString = new String("BeanWithStatic");
	private int privateInt;
	private String privateString;
	
	public String getPrivateString() {
		return privateString;
	}
	public void setPrivateString(String privateString) {
		this.privateString = privateString;
	}
	
	public int getPrivateInt() {
		return privateInt;
	}
	public void setPrivateInt(int privateInt) {
		this.privateInt = privateInt;
	}

	@Override
	public String toString() {
	return "BeanWithConstructor [privateInt=" + privateInt + ", privateString=" + privateString + ", serialVersionUID="
	+ serialVersionUID + "privateStaticInt=" + privateStaticInt + ", privateStaticString=" + privateStaticString + ", serialVersionUID="
			+ serialVersionUID + "]";
	}
}
