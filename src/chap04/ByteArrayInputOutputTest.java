package chap04;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteArrayInputOutputTest {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("사용법 : java ByteArrayInputOutputTest 파일명");
			System.exit(0);
		}
		
		FileInputStream fis = null;
		ByteArrayInputStream bais = null;
		ByteArrayOutputStream baos = null;
		
		try {
			fis = new FileInputStream(args[0]);
			baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[512];
			int readcount = 0;
			
			while ((readcount = fis.read(buffer)) != -1) {  //  파일로부터 읽어들임
				baos.write(buffer, 0, readcount);			// 바이트어레이아웃펏스트림으로 읽어들인 내용 내보냄
			}
			
			byte[] fileArray = baos.toByteArray();
			System.out.println("파일의 내용을 모두 읽어 들여 byte[]로 만들었습니다.");
			System.out.println("읽어들인 byte의 수 : "+fileArray.length);
			
			bais = new ByteArrayInputStream(fileArray);
			
			while ((readcount = bais.read(buffer)) != -1) {
				System.out.write(buffer, 0, readcount);
				
			}
			System.out.println("\n\n");
			System.out.println("읽어들인 내용을 모두 출력했습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				fis.close();
				bais.close();
				baos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
