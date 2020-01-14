package redis_20200114.bean;

import java.io.Serializable;

public class BeanSimple implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected int privateInt;
	protected String privateString;
	
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
	return "BeanSimple [privateInt=" + privateInt + ", privateString=" + privateString + ", serialVersionUID="
	+ serialVersionUID + "]";
	}

}
