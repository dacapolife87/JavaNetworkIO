package chap06;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;

public class HelloWindow extends Frame implements Serializable{
	public HelloWindow() {
		// TODO Auto-generated constructor stub
		super("hello window");
		setLayout(new BorderLayout());
		
		add("Center", new Label("hello window"));
		addWindowListener(new WindowEventHandler());
		
		setSize(200, 200);
	}
	
	class WindowEventHandler extends WindowAdapter implements Serializable{
		public void windowClosing(WindowEvent e){
			System.out.println("윈도우를 종료합니다");
			System.exit(0);
		}
	}
}
