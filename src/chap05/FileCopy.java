package chap05;

import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("사용법 : java FileCopy 파일1 파일2");
			System.exit(0);
		}
		
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(args[0]);
			fw = new FileWriter(args[1]);
			char[] buffer = new char[512];
			int readcount = 0;
			while ((readcount = fr.read(buffer)) != -1) {
				fw.write(buffer, 0, readcount);
			}
			System.out.println("파일을 복사했습니다.");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
