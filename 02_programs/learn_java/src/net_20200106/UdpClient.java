package net_20200106;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Properties;


/**
 * （1）receive是阻塞接口，receive可以设置超时，<br>
 * connet可以绑定对象，绑定后，可以send无地址信息的datagrampacket。<br>
 * 且只能向connect socket发送消息。<br>
 * 被connect方，可以从data中获取ip和port，即使connect方未设定。<br>
 * 
 * （2）发送出的datagrampacket可以设定发送对象的地址和端口，和udpsend配合使用。<br>
 * 接收到的datagrampacket可以获得发送对象的地址和端口。<br>
 * 
 * （3）udp绑定，已经使用中的端口（其他UDP已经绑定）会抛出异常。<br>
 * 
 * （4）UdpSocket可以给多人发，接收多份消息。一个server可以被多个client connect。<br>
 * 
 * （5）native方法<br>
 * 本地方法，其他语言库提供
 */
public class UdpClient {
	private DatagramSocket datagramsocket;
	private int port;
	
	public UdpClient() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("conf.properties"));

		port = Integer.parseInt(properties.getProperty("port-client"));
		
		datagramsocket = new DatagramSocket(port);
	}
	
	public void connect() throws NumberFormatException, FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("conf.properties"));
		
		datagramsocket.connect(InetAddress.getLocalHost(), Integer.parseInt(properties.getProperty("port-server")));

		System.out.println("isBound() " + datagramsocket.isBound() );
		System.out.println("isClosed() " + datagramsocket.isClosed() );
		System.out.println("isConnected()  " + datagramsocket.isConnected() );
	}
	
	public void send() throws IOException {
		byte[] buf = new byte[1024];
		
		DatagramPacket datagrampacket = new DatagramPacket(buf, 1024);
		datagrampacket.setData("this is boy.".getBytes());
		
		datagramsocket.send(datagrampacket);
		System.out.println("Send data : " + new String(datagrampacket.getData()));
	}
	
	public void send(int port) throws IOException {
		byte[] buf = new byte[1024];
		
		DatagramPacket datagrampacket = new DatagramPacket(buf, 1024);
		datagrampacket.setData("this is boy(port).".getBytes());
		datagrampacket.setPort(port);
		datagrampacket.setAddress(InetAddress.getLocalHost());
		
		datagramsocket.send(datagrampacket);
		System.out.println("Send data(port) : " + new String(datagrampacket.getData()));
	}
	
	public void receive() throws IOException {
		byte[] buf = new byte[1024];
		
		DatagramPacket datagrampacket = new DatagramPacket(buf, 1024);
		datagramsocket.receive(datagrampacket);
		
		System.out.println("Receive data: " + new String(datagrampacket.getData()));
		System.out.println("Receive addr: " + datagrampacket.getAddress());
		System.out.println("Receive port: " + datagrampacket.getPort());
	}
	
	public static void main(String[] args) {
		
		try {
			UdpClient udp = new UdpClient();
			
			//connect多连接测试
			udp.connect();
			Thread.sleep(10000);
			udp.send(9999);
			
//			udp.send(9999 - 2);
//			//普通多连接测试
//			udp.receive();
//			udp.receive();
			
			//udp.send(9999);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
