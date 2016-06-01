package chap04;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileStreamCopy {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("���� : java FileSreamCopy ����1 ����2");
			System.exit(0);
		}
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(args[0]);
			fos = new FileOutputStream(args[1]);
			
			byte[] buffer = new byte[512];
			int readcount = 0;
			
			while ((readcount = fis.read(buffer)) != -1) {
				fos.write(buffer, 0 , readcount);
			}
			System.out.println("���簡 �Ϸ�Ǿ����ϴ�.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
				try {
					fos.close();
				} catch (Exception e3) {
					// TODO: handle exception
				}
			}
			
		}
	}
}
