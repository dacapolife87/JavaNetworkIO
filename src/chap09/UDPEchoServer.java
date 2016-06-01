package chap09;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("사용법 : java UDPEchoServer port");
			//System.exit(0);
		}
		
		int port =1234;
//		try {
//			port = Integer.parseInt(args[0]);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		DatagramSocket dsock = null;
		try {
			System.out.println("접속 대기 상태 입니다.");
			
			dsock = new DatagramSocket(port);
			String line = null;
			
			while (true) {
				byte[] buffer = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
				System.out.println("대기");
				dsock.receive(receivePacket);
				System.out.println("접속후 전송"+receivePacket.getData());
				String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
				
				System.out.println("전송받은 문자열 : "+msg);
				if (msg.equals("quit")) {
					break;
				}
				
				// 전송
				DatagramPacket sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getData().length,
						receivePacket.getAddress(), receivePacket.getPort());
				
				dsock.send(sendPacket);
			}
			
			System.out.println("UDPEchoServer를 종료합니다");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (dsock != null) {
				dsock.close();
			}
		}
	}
}
