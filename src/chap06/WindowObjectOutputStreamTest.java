package chap06;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WindowObjectOutputStreamTest {
	public static void main(String[] args) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		
		HelloWindow hwin = new HelloWindow();
		
		try {
			fout = new FileOutputStream("hwin.dat");
			oos = new ObjectOutputStream(fout);
			
			oos.writeObject(hwin);
			oos.reset();
			
			System.out.println("저장되었습니다");
			hwin.setVisible(true);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				oos.close();
				fout.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
