package rmi_20200102;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiServer {

	public static void main(String[] args) {
//		System.setProperty("java.rmi.server.hostname", "192.168.137.1");

		RmiIF rmiIf = new RmiImpl();
		
		try {
			//1.create.
			LocateRegistry.createRegistry(12342);
			
			//2.rebind
			Naming.rebind("rmi://localhost:12342/properties", rmiIf);
			
//			Naming.rebind("rmi://192.168.137.1:1234/properties", rmiIf);
			
			System.out.println("rmi://localhost:12342/properties");
			
			while(true)
			{
				Thread.sleep(1000);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
