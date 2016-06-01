package chap10;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebSpiderWithURLConnection {
	public static void main(String[] args) {
//		if(args.length != 2	){
//			System.out.println("사용법 : java Websprider url filename");
//			System.exit(1);
//		}
//		
		String word = "사과";
		String query = "query="+URLEncoder.encode(word);
		String urladdr = "https://search.naver.com/search.naver?"+query;
		
		URL url = null;
		try {
			url = new URL(urladdr);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("잘못된 URL");
			System.out.println(e);
			System.exit(1);
		}
		
		FileOutputStream fos = null;
		
		try {
			URLConnection urlcon = url.openConnection();
			urlcon.setUseCaches(false);
			String contentType = urlcon.getContentType();
			long d1 = urlcon.getDate();
			java.util.Date d = new Date(d1);
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:aa a");
			String sdate = format.format(d);
			
			System.out.println("content type : "+contentType);
			System.out.println("content type : "+urlcon.getContent());
			System.out.println("content type : "+urlcon.getDate());
			System.out.println("content type : "+urlcon.getContentLength());
			System.out.println("읽어온 시간 : "+sdate);
			
			InputStream in = urlcon.getInputStream();
			fos = new FileOutputStream("testfile.html");
			
			byte[] buffer = new byte[512];
			int readcount = 0;
			System.out.println("읽어오기 시작합니다");
			while ((readcount = in.read(buffer)) != -1) {
				fos.write(buffer, 0, readcount);
			}
			
			System.out.println("파일에 모두 저장했습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
		}
	}
}
