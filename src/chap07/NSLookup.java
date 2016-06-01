package chap07;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("ip 주소나 도메인 주소를 이자로 지정하세요");
			System.exit(0);
		}
		
		InetAddress inetadddr[] = null;
		
		try {
			inetadddr = InetAddress.getAllByName(args[0]);
		} catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		for (int i = 0; i < inetadddr.length; i++) {
			System.out.println(inetadddr[i].getHostName());
			System.out.println(inetadddr[i].getHostAddress());
			System.out.println(inetadddr[i].toString());
			System.out.println("-------------------------");
		}
	}
}
