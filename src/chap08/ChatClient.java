package chap08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
	public static void main(String[] args) {
		Socket sock = null;
		String id="test";
		BufferedReader br = null;
		PrintWriter pw = null;
		boolean endflag = false;
		
		try {
			sock = new Socket("127.0.0.1", 10001);
			pw=new PrintWriter( new OutputStreamWriter(sock.getOutputStream()));
			
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			pw.println(id);
			pw.flush();
			
			InputThread it =  new InputThread(sock,br);
			it.start();
			String line = null;
			
			while ((line = keyboard.readLine()) != null) {
				pw.println(line);
				pw.flush();
				
				if(line.equals("/quit")){
					endflag = true;
					break;
				}
				
			}
			System.out.println("클라이언트의 접속을 종료합니다");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
	}
}

class InputThread extends Thread{
	private Socket sock = null;
	private BufferedReader br = null;
	
	public InputThread(Socket sock, BufferedReader br){
		this.sock = sock;
		this.br = br;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
