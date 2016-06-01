package chap10;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class WebSpider {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("사용법 :  java WebSpider URL filename");
			System.exit(1);
		}
		
		URL url = null;
		try {
			url = new URL(args[0]);
		} catch (MalformedURLException e) {
			// TODO: handle exception
			System.out.println("잘못된 URL형식 입니다.");
			System.out.println(e);
			System.exit(1);
		}
		
		FileOutputStream fos = null;
		
		try {
			InputStream in = url.openStream();
			fos = new FileOutputStream(args[1]);
			
			byte[] buffer = new byte[512];
			int readcount = 0;
			
			System.out.println("읽어오기 시작합니다.");
			
			while ((readcount = in.read(buffer)) != -1) {
				fos.write(buffer, 0, readcount);
			}
			
			System.out.println(args[1] + " 파일을 모두 저장했습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				if(fos != null){
					fos.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
