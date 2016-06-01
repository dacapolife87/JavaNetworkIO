package chap04;

import java.io.FileInputStream;

public class FIleView2 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("사용법 : java FileView 파일명");
			System.exit(0);
		}
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(args[0]);
			int readcount = 0;
			byte[] buffer = new byte[512];
			while ((readcount = fis.read(buffer)) != -1) {
				System.out.write(buffer, 0, readcount);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
