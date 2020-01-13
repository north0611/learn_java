package rmi_20200102;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiCilent {

	public static void main(String[] args) {
		
		try {
			RmiIF rmiIf = (RmiIF)Naming.lookup("rmi://localhost:12342/properties");
			System.out.println(rmiIf.getProperties());
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

	}

}
