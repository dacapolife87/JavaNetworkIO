package chap14;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;

public class SCConnectionTest {
	private static int PORT = 80;
	
	public static void main(String[] args) throws Exception {
		InetAddress ia = InetAddress.getLocalHost();
		InetSocketAddress isa = new InetSocketAddress(ia, PORT);
		
		SocketChannel sc = SocketChannel.open();
		sc.configureBlocking(false);
		System.out.println("Is connectionPending 1 : "+ sc.isConnectionPending());
		sc.connect(isa);
		System.out.println("Is connectionPending 2 : "+ sc.isConnectionPending());
		sc.finishConnect();
		System.out.println("Is connectionPending 3 : "+ sc.isConnectionPending());
		
		System.out.println("IS connected : "+sc.isConnected());
		System.out.println("IS Blocking Mode : "+sc.isBlocking());
	}
}
