package chap05;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamReaderTest {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("���� : java StreamReaderTest ���ϸ�");
			System.exit(0);
		}
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		
		try {
			fis = new FileInputStream(args[0]);
			isr = new InputStreamReader(fis);
			osw = new OutputStreamWriter(System.out);
			
			char[] buffer = new char[512];
			
			int readcount = 0;
			
			while ((readcount = isr.read(buffer)) != -1) {
				osw.write(buffer,0,readcount);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				fis.close();
				isr.close();
				osw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
