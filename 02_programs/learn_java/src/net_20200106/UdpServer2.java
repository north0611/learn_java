package net_20200106;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Properties;

public class UdpServer2 {
	public DatagramSocket datagramsocket;
	private int port;
	
	private int ackPort;
	private InetAddress ackInetAddress;
	
	public UdpServer2() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("conf.properties"));

		port = Integer.parseInt(properties.getProperty("port-server"));
		datagramsocket = new DatagramSocket(port-2);

	}

	public void receive() throws IOException {
		byte[] buf = new byte[1024];

		DatagramPacket datagrampacket = new DatagramPacket(buf, 1024);
		datagramsocket.receive(datagrampacket);

		ackPort = datagrampacket.getPort();
		ackInetAddress = datagrampacket.getAddress();
		
		System.out.println("Receive data: " + new String(datagrampacket.getData()));
		System.out.println("Receive addr: " + datagrampacket.getAddress());
		System.out.println("Receive port: " + datagrampacket.getPort());
	}

	public void send() throws IOException {
		byte[] buf = new byte[1024];

		DatagramPacket datagrampacket = new DatagramPacket(buf, 1024);
		datagrampacket.setData("ack server(port).".getBytes());
		datagrampacket.setAddress(ackInetAddress);
		datagrampacket.setPort(ackPort);
		datagramsocket.send(datagrampacket);

		System.out.println("Send data: " + new String(datagrampacket.getData()));
		System.out.println("Send addr: " + datagrampacket.getAddress());
		System.out.println("Send port: " + datagrampacket.getPort());
	}

	public static void main(String[] args) {
		UdpServer2 udp;
		try {
			udp = new UdpServer2();

			while(true) {
				udp.receive();
				
				udp.send();
			}
//			udp.send();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
