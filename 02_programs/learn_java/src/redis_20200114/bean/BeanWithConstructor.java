package redis_20200114.bean;

import java.io.Serializable;

public class BeanWithConstructor implements Serializable {

	private static final long serialVersionUID = 3L;
	
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

	public BeanWithConstructor(int privateInt, String privateString) {
		this.privateInt = privateInt;
		this.privateString = privateString;
	}
	
	@Override
	public String toString() {
	return "BeanWithConstructor [privateInt=" + privateInt + ", privateString=" + privateString + ", serialVersionUID="
	+ serialVersionUID + "]";
	}
}
