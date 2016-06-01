package chap09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
	public static void main(String[] args) {
		//String ip = args[0];
		
		int port = 1234;
		String ip = "127.0.0.1";
		
//		try {
//			port =  Integer.parseInt(args[1]);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		InetAddress inetAddr = null;
		
		try {
			inetAddr = InetAddress.getByName(ip);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		DatagramSocket dsock = null;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			dsock = new DatagramSocket();
			String line = null;
			
			while ((line = br.readLine())!=null) {
				DatagramPacket sendPacket = new DatagramPacket(
						line.getBytes(), line.getBytes().length, inetAddr, port);
				dsock.send(sendPacket);
				
				if (line.equals("quit")) {
					break;
				}
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
