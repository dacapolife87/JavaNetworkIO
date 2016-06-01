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
		super("��Ƽĳ��Ʈ ��۱�");
		socket =  new DatagramSocket(port);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String msg = "��Ƽĳ��Ʈ ����� �� �鸮�ó���?";
		byte[] b = new byte[100];
		while (onAir) {
			try {
				b = msg.getBytes();
				channel = InetAddress.getByName(addresss);
				packet = new DatagramPacket(b, b.length, channel, port);
				socket.send(packet);
				try {
					sleep(500);
					System.out.println("����� �Դϴ�");
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
