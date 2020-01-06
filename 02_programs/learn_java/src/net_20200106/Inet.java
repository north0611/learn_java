package net_20200106;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * localhost
 * localhost其实是域名，一般windows系统默认将localhost指向127.0.0.1，
 * 但是localhost并不等于127.0.0.1，localhost指向的IP地址是可以配置的
 */

/**
 * 127.0.0.1
 * 首先我们要先知道一个概念，凡是以127开头的IP地址，都是回环地址（Loop back address），
 * 其所在的回环接口一般被理解为虚拟网卡，并不是真正的路由器接口。
 * 
 * 所谓的回环地址，通俗的讲，就是我们在主机上发送给127开头的IP地址的数据包会被发送的主机自己接收，
 * 根本传不出去，外部设备也无法通过回环地址访问到本机。
 * 
 * 正常的数据包会从IP层进入链路层，然后发送到网络上；而给回环地址发送数据包，
 * 数据包会直接被发送主机的IP层获取，后面就没有链路层他们啥事了。
 */

/**
 * 0.0.0.0
 * 首先，0.0.0.0是不能被ping通的。在服务器中，0.0.0.0并不是一个真实的的IP地址，
 * 它表示本机中所有的IPV4地址。监听0.0.0.0的端口，就是监听本机中所有IP的端口。
 */

/**
 * 本机IP
 * 本机IP通常仅指在同一个局域网内，能同时被外部设备访问和本机访问的那些IP地址（可能不止一个）。
 * 像127.0.0.1这种一般是不被当作本机IP的。本机IP是与具体的网络接口绑定的，比如以太网卡、无线网卡
 * 或者PPP/PPPoE拨号网络的虚拟网卡，想要正常工作都要绑定一个地址，否则其他设备就不知道如何访问它。
 */

/**
 * 小例子
 * 现在有两台pc在同一个局域网内，分别为pc1与pc2，pc1上有一个网卡，IP地址为192.168.10.128
 * pc1中sever监听127.0.0.1，则pc1中的client可以连上127.0.0.1，192.168.10.128连不上；而pc2中client都连不上。
 * pc1中sever监听192.168.10.128，则pc1中的client可以连上192.168.10.128，127.0.0.1连不上；而pc2中client能连上192.168.10.128。
 * pc1中sever监听0.0.0.0，则pc1中的client可以连上127.0.0.1和192.168.10.128，pc2中的client能连上192.168.10.128。
 *
 */

public class Inet {
	public InetAddress[] inetaddress;
	
	public InetSocketAddress inetsocketaddress1;
	public InetSocketAddress inetsocketaddress2;
	public InetSocketAddress inetsocketaddress3;

	public Inet() {
		try {
			inetaddress = InetAddress.getAllByName("localhost");
			System.out.println("InetAddress " + inetaddress.length);
			System.out.println("InetAddress " + inetaddress[0]);
			System.out.println("InetAddress " + inetaddress[1]);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		inetsocketaddress1 = new InetSocketAddress(9999);
		inetsocketaddress2 = new InetSocketAddress("localhost", 9999);
		inetsocketaddress3 = new InetSocketAddress(inetaddress[0], 9999);
	}
	
	public static void main(String[] args) {
		
		Inet inet = new Inet();
		System.out.println("InetSocketAddress " + inet.inetsocketaddress1);
		System.out.println("InetSocketAddress " + inet.inetsocketaddress2);
		System.out.println("InetSocketAddress " + inet.inetsocketaddress3);
	}

}
