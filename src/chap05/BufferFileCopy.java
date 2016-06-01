package chap05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferFileCopy {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("사용법 : java BufferFileCopy 파일1 파일2");
			System.exit(0);
		}
		
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fr = new FileReader(args[0]);
			br = new BufferedReader(fr);
			fw = new FileWriter(args[1]);
			bw = new BufferedWriter(fw);
			
			char[] buffer = new char[512];
			int readcount = 0;
			
			while ((readcount = br.read(buffer)) != -1) {
				bw.write(buffer, 0, readcount);
			}
			System.out.println("파일을 복사하였습니다.");
			} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				br.close();
				bw.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
