package chap07;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class NSLoockupLocal {
	public static void main(String[] args) {
		InetAddress inetaddr = null;
		
		try {
			inetaddr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO: handle exception
		}
		
		System.out.println(inetaddr.getHostName());
		System.out.println(inetaddr.getHostAddress());
		
		System.out.println("byte[] ������ ip�ּҰ��� ���");
		
		byte[] ip = inetaddr.getAddress();
		for (int i = 0; i < ip.length; i++) {
			System.out.println((int)ip[i]);
			if (i != ip.length -1) {
				System.out.println(".");
			}
		}
	}
}
