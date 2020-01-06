package learn_java._20200102_rmi;

import java.rmi.Remote;
import java.util.Properties;

public interface RmiIF extends Remote{
	public Properties getProperties();
}
