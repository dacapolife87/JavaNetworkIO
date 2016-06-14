package chap11;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {
	MulticastSocket receiver = null;
	DatagramPacket packet = null;
	InetAddress channel = null;
	int port = 9999;
	String address =  "239.0.0.1";
	byte[] b = new byte[100];
	
	public MulticastClient() {
		// TODO Auto-generated constructor stub
		try {

			receiver = new MulticastSocket(port);

			
			channel = InetAddress.getByName(address);
			packet = new DatagramPacket(b, b.length);
			receiver.joinGroup(channel);
			for (int i = 0; i < 3; i++) {
				receiver.receive(packet);
				String notice = new String(packet.getData());
				System.out.println(notice);
			}
			receiver.leaveGroup(channel);
			receiver.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MulticastClient();
	}
}
