package chap10;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLGET {
	public static void main(String[] args) {
		URL url = null;
		URLConnection urlconn = null;
		FileOutputStream fos = null;
		
		String urladdr = "http://localhost:8080/WebExample/Msg";
		String msg = "get msg temp WebServer!";
		try {
			msg = URLEncoder.encode(msg);
			String query = "?msg="+msg;
			
			url = new URL(urladdr+query);
			
			urlconn = url.openConnection();
			String contentType = urlconn.getContentType();
			
			fos = new FileOutputStream("GetFile.html");
			
			//BufferedReader in = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
			InputStream in = urlconn.getInputStream();
			String inputLine = null;
			
			byte[] buffer = new byte[512];
			int readcount = 0;
			System.out.println("읽어오기 시작합니다");
			while ((readcount = in.read(buffer)) != -1) {
				fos.write(buffer, 0, readcount);
			}
			System.out.println("파일에 모두 저장했습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}finally {
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
