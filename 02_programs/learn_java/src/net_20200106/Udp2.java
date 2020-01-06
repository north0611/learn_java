package net_20200106;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Udp2 {
	public DatagramSocket datagramsocket1;
	public DatagramSocket datagramsocket2;
	public DatagramSocket datagramsocket3;
	public DatagramSocket datagramsocket4;

	public Udp2() {
		
		try {
//			datagramsocket1 = new DatagramSocket();
			datagramsocket2 = new DatagramSocket(8881);
//			datagramsocket3 = new DatagramSocket(9992, InetAddress.getLocalHost());
//			datagramsocket4 = new DatagramSocket(new InetSocketAddress(9993));
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Udp2 udp = new Udp2();
		byte[] buf = new byte[1024];
		
		DatagramPacket datagrampacket = new DatagramPacket(buf, 1024);
		
		while(true) {
			try {
				udp.datagramsocket2.setSoTimeout(5000);
				udp.datagramsocket2.receive(datagrampacket);
				System.out.println(new String(datagrampacket.getData()));
				System.out.println(datagrampacket.getSocketAddress());
				System.out.println("2======================================>1");
				
				udp.datagramsocket2.send(datagrampacket);
				
				System.out.println("2======================================>2");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Thread.sleep(1000);
		}
		
	}

}
