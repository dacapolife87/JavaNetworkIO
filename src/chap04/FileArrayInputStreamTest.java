package chap04;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileArrayInputStreamTest {
	public static void print(InputStream in){
		byte[] buffer = new byte[512];
		int readcount = 0;
		
		try {
			while ((readcount = in.read(buffer))!= -1) {
				System.out.write(buffer, 0, readcount);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("사용법 : java FileArrayInputStreamTest file/array");
			System.exit(0);
		}
		
		if (args[0].equals("file")) {
			FileInputStream fis = null;
			
			try {
				fis = new FileInputStream("file.dat");
				
				print(fis);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}finally {
				try {
					fis.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}else if (args[0].equals("array")) {
			byte[] abc = new byte[26];
			for(int i =0;i<26;i++){
				abc[i] = (byte)('a'+i);
			}
			ByteArrayInputStream bais = null;
			
			try {
				bais = new ByteArrayInputStream(abc);
				
				print(bais);
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					bais.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}else {
			System.out.println("사용법 : java FileArrayInputStreamTest file/array");
			System.exit(0);
		}
	}
	
	
}
