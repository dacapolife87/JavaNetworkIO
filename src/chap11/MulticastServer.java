package chap11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.MalformedInputException;

public class MulticastServer extends Thread{
	DatagramSocket socket = null;
	DatagramPacket packet = null;
	InetAddress channel = null;
	int port =  20001;
	String addresss = "239.0.0.1";
	boolean onAir = true;
	
	public MulticastServer() throws IOException{
		// TODO Auto-generated constructor stub
		super("멀티캐스트 방송국");
		socket =  new DatagramSocket(port);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String msg = "멀티캐스트 방송이 잘 들리시나요?";
		byte[] b = new byte[100];
		while (onAir) {
			try {
				b = msg.getBytes();
				channel = InetAddress.getByName(addresss);
				packet = new DatagramPacket(b, b.length, channel, port);
				socket.send(packet);
				try {
					sleep(500);
					System.out.println("방송중 입니다");
				} catch (Exception e) {
					// TODO: handle exception
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		socket.close();
		
	}
	public static void main(String[] args) throws IOException {
		new MulticastServer().start();
	}
}
