package chap11;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastChatClient extends Frame implements ActionListener{
	private TextField idTF = null;
	private TextField input = null;
	private TextArea display = null;
	private CardLayout cardlayout = null;
	
	DatagramSocket socket = null;
	DatagramPacket spacket = null;
	InetAddress schannel = null;
	int sport = 20005;
	String saddress = "239.0.0.1";
	boolean onAir = true;
	String id = "";
	
	public MulticastChatClient() {
		// TODO Auto-generated constructor stub
		super("ä��Ŭ���̾�Ʈ");
		cardlayout =  new CardLayout();
		setLayout(cardlayout);
		
		Panel loginPannel = new Panel();
		loginPannel.setLayout(new BorderLayout());
		loginPannel.add("North", new Label("���̵� �Է��� �ֽ��� ����Ű�� �Է��� �ּ���"));
		idTF = new TextField(20);
		idTF.addActionListener(this);
		Panel c = new Panel();
		c.add(idTF);
		loginPannel.add("Center", c);
		add("login",loginPannel);
		
		Panel main = new Panel();
		main.setLayout(new BorderLayout());
		input = new TextField();
		input.addActionListener(this);
		display = new TextArea();
		display.setEditable(false);
		main.add("Center", display);
		main.add("South", input);
		add("main", main);
		
		try {
			socket = new DatagramSocket(sport);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		setSize(500, 500);
		cardlayout.show(this, "login");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����մϴ�.");
				sendMsg(id+"���� �����մϴ�");
				try {
					socket.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		setVisible(true);
	}
	public static void main(String[] args) {
		new MulticastChatClient();
	}
	
	public void sendMsg(String msg){
		byte[] b = new byte[2000];
		try {
			b = msg.getBytes();
			schannel = InetAddress.getByName(saddress);
			spacket = new DatagramPacket(b, b.length, schannel, sport);
			System.out.println("b : "+b+"/ b.lenth : "+b.length+" / schannel : "+schannel+"/sport : "+sport);
			socket.send(spacket);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == idTF){
			id = idTF.getText();
			if (id== null || id.trim().equals("")) {
				System.out.println("���̵� �ٽ� �Է��ؼ� �ּ���");
				return;
			}
			System.out.println("id : "+id);
			sendMsg(id + " ���� �����߽��ϴ�\n");
			
			WinInputMulticastThread wit = new WinInputMulticastThread();
			wit.start();
			cardlayout.show(this, "main");
			input.requestFocus();
		}else if (e.getSource() == input) {
			String msg = input.getText();
			sendMsg(id + ":"+msg+"\n");
			if (msg.equals("/quit")) {
				try {
					socket.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			input.setText("");
			input.requestFocus();
		}
	}
	
	class WinInputMulticastThread extends Thread{
		MulticastSocket receiver = null;
		DatagramPacket packet = null;
		InetAddress channel = null;
		int port = 20005;
		String address = "239.0.0.1";
		
		public WinInputMulticastThread() {
			// TODO Auto-generated constructor stub
			try {
				receiver = new MulticastSocket(port);
				channel = InetAddress.getByName(address);
				receiver.joinGroup(channel);

			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		public void run(){
			try {
				while (true) {
					byte[] b = new byte[2000];
					packet = new DatagramPacket(b, b.length);
					receiver.receive(packet);
					String msg = new String(packet.getData());
					if (msg.equals("/quit")) {
						break;
					}
					display.append(msg);
				}
				receiver.leaveGroup(channel);
				receiver.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
