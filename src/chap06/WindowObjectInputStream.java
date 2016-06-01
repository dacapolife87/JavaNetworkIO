package chap06;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class WindowObjectInputStream {
	public static void main(String[] args) {
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		
		try {
			fin = new FileInputStream("hwin.dat");
			ois = new ObjectInputStream(fin);
			
			HelloWindow hwin = (HelloWindow)ois.readObject();
			hwin.setVisible(true);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ois.close();
				fin.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
