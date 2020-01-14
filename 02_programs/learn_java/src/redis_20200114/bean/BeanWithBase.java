package redis_20200114.bean;

import java.io.Serializable;

public class BeanWithBase extends BeanSimple implements Serializable {

	private static final long serialVersionUID = 2L;
	
	private int privateIntSon;
	private String privateStringSon;
	
	public String getPrivateStringSon() {
		return privateStringSon;
	}
	public void setPrivateStringSon(String privateString) {
		this.privateStringSon = privateString;
	}
	
	public int getPrivateIntSon() {
		return privateIntSon;
	}
	public void setPrivateIntSon(int privateInt) {
		this.privateIntSon = privateInt;
	}

	@Override
	public String toString() {
	return "BeanWithBase [privateIntSon=" + privateIntSon + ", privateStringSon=" + privateStringSon + ", serialVersionUID="
	+ serialVersionUID + "BeanSimple [privateInt=" + super.privateInt + ", privateString=" + super.privateString + "]";
	}
}
