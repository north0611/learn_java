package learn_java._20200102_rmi;

import java.io.Serializable;
import java.util.Properties;

public class RmiImpl implements RmiIF, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Properties getProperties() {
		System.out.println("Called By Cilent.");
		return System.getProperties();
	}
}
