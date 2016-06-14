package chap12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NonBuffer {
	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();
			
			copy("c://java//1.pdf","2.pdf");
			long endTime = System.currentTimeMillis();
			
			System.out.println("NonBuffer 처리시간 : "+(endTime-startTime) + " milli senconds");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	public static void copy(String fileFrom, String fileTo) throws IOException{
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(fileFrom);
			out = new FileOutputStream(fileTo);
			
			while (true) {
				int bytedata = in.read();
				
				if (bytedata == -1) {
					break;
				}
				out.write(bytedata);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
