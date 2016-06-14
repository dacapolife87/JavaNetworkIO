package chap12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SmallBuffer {
	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();
			
			copy("c://java//1.pdf","c://java//2.pdf");
			long endTime = System.currentTimeMillis();
			
			System.out.println("Buffer 처리시간 : "+(endTime-startTime) + " milli senconds");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void copy(String fileFrom, String fileTo) throws IOException{
		InputStream inBuffer = null;
		OutputStream outBuffer = null;
		
		try {
			InputStream in = new FileInputStream(fileFrom);
			inBuffer = new BufferedInputStream(in,2048);
			OutputStream out = new FileOutputStream(fileTo);
			outBuffer = new BufferedOutputStream(out, 2048);
			
			
			while (true) {
				int bytedata = inBuffer.read();
				
				if (bytedata == -1) {
					break;
				}
				out.write(bytedata);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (inBuffer != null) {
				inBuffer.close();
			}
			if (outBuffer != null) {
				outBuffer.close();
			}
		}
	}
}
