package chap12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FullBuffer {
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
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(fileFrom);
			out = new FileOutputStream(fileTo);
			
			int availableLength = in.available();
			
			byte[] buffer = new byte[availableLength];
			
			
			int bytedata = in.read(buffer);
			
			out.write(buffer);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
