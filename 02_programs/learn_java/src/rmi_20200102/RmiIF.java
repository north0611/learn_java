package rmi_20200102;

import java.rmi.Remote;
import java.util.Properties;

public interface RmiIF extends Remote{
	public Properties getProperties();
}
