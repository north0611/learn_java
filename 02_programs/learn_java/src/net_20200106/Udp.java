package net_20200106;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
 * receive是阻塞接口
 * connet可以绑定对象，绑定后，可以send无地址信息的datagrampacket。
 * 
 * 发送出的datagrampacket可以设定发送对象的地址和端口，和udpsend配合使用。
 * 接收到的datagrampacket可以获得发送对象的地址和端口。
 * 
 * receive可以设置超时
 */
public class Udp {
	public DatagramSocket datagramsocket1;
	public DatagramSocket datagramsocket2;
	public DatagramSocket datagramsocket3;
	public DatagramSocket datagramsocket4;

	public Udp() {
		
		try {
			datagramsocket1 = new DatagramSocket();
			datagramsocket2 = new DatagramSocket(9991);
			datagramsocket3 = new DatagramSocket(9992, InetAddress.getLocalHost());
			datagramsocket4 = new DatagramSocket(new InetSocketAddress(9993));
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Udp udp = new Udp();
		
		try {
			udp.datagramsocket1.connect(InetAddress.getLocalHost(), 8881);
			
			System.out.println("isBound() " + udp.datagramsocket1.isBound() );
			System.out.println("isClosed() " + udp.datagramsocket1.isClosed() );
			System.out.println("isConnected()  " + udp.datagramsocket1.isConnected() );
			System.out.println("isBound() " + udp.datagramsocket1.isBound() );
			
			byte[] buf = new byte[1024];
			
			DatagramPacket datagrampacket = new DatagramPacket(buf, 1024);
			datagrampacket.setData("this is boy.".getBytes());
			
			udp.datagramsocket1.send(datagrampacket);
			
			System.out.println("1======================================>1");
			
			byte[] buf1 = new byte[1024];
			DatagramPacket datagrampacket1 = new DatagramPacket(buf1, 1024);
			udp.datagramsocket1.receive(datagrampacket1);
			System.out.println(new String(datagrampacket1.getData()));
			
			System.out.println(datagrampacket1.getSocketAddress());
			System.out.println("1======================================>2");
			
			byte[] buf2 = new byte[1024];
			DatagramPacket datagrampacket2 = new DatagramPacket(buf2, 1024);
			datagrampacket2.setAddress(InetAddress.getByName("localhost"));
			datagrampacket2.setPort(8881);
			datagrampacket2.setData("this is girl.".getBytes());
			udp.datagramsocket2.send(datagrampacket2);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
