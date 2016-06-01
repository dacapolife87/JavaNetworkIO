package chap08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServerBasic {
	public static void main(String[] args) {
		Socket sock = null;
		BufferedReader br = null;
		
		try {
			ServerSocket ss = new ServerSocket(80);
			sock = ss.accept();
			
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			String line = null;
			
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if( br != null) {
					br.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			try {
				if (sock != null) {
					sock.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
