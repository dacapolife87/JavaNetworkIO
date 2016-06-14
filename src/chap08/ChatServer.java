package chap08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.security.auth.PrivateCredentialPermission;

public class ChatServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			System.out.println("������ ��ٸ��ϴ�.");
			HashMap hm = new HashMap();
			
			while (true) {
				Socket sock = server.accept();
				ChatThread chatthread = new ChatThread(sock,hm);
				chatthread.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}


class ChatThread extends Thread{
	private Socket sock;
	private String id;
	private BufferedReader br;
	private HashMap hm;
	private boolean initFlag = false;
	public ChatThread(Socket sock, HashMap hm){
		this.sock = sock;
		this.hm = hm;
		
		try {
			PrintWriter pw = new PrintWriter(
					new OutputStreamWriter(sock.getOutputStream()));
			
			br = new BufferedReader(
					new InputStreamReader(sock.getInputStream()));
			
			id = br.readLine();
			
			broadcast(id+"���� �����߽��ϴ�.");
			System.out.println("������ ������� ���̵�� "+id+ " �Դϴ�.");
			synchronized (hm) {
				hm.put(this.id, pw);
			}
			
			initFlag = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String line = null;
			while ((line =  br.readLine()) != null) {
				if(line.equals("/quit"))
					break;
				if(line.indexOf("/to ") == 0){
					sendmsg(line);
				}else{
					broadcast(id + ":"+line);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			synchronized (hm) {
				hm.remove(id);
			}
			broadcast(id+ "���� ���������Ͽ����ϴ�	");
			try {
				if(sock != null)
					sock.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public void sendmsg(String msg){
		int start = msg.indexOf(" ")+1;
		int end = msg.indexOf(" ",start);
		
		if(end != -1){
			String to = msg.substring(start, end);
			String msg2 = msg.substring(end+1);
			
			Object obj = hm.get(to);
			
			if(obj != null){
				PrintWriter pw = (PrintWriter) obj;
				pw.println(id + "���� ������ �ӼӸ��� �����̽��ϴ�. : "+msg2);
				pw.flush();
			}
		}
	}
	public void broadcast(String msg){
		synchronized (hm) {
			Collection collection = hm.values();
			Iterator iter = collection.iterator();
			
			while (iter.hasNext()) {
				PrintWriter pw = (PrintWriter) iter.next();
				pw.println(msg);
				pw.flush();
			}
		}
	}
}
