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

public class PostConnection {
	public static void main(String[] args) {
//		if(args.length != 2	){
//			System.out.println("사용법 : java postconnection id pw");
//			System.exit(1);
//		}
		FileOutputStream fos = null;
		
		URL url = null;
		URLConnection urlconn = null;
		HttpURLConnection hurlc;
		String urladdr = "http://localhost:8080/WebExample/Login";
		try {
			String id = URLEncoder.encode("testid");
			String passwd = URLEncoder.encode("testpw");
			
			String query = "id="+id+"&passwd="+passwd;
			System.out.println(urladdr+query);
			url = new URL(urladdr);
			urlconn = url.openConnection();
			hurlc = (HttpURLConnection) urlconn;
			hurlc.setRequestMethod("POST");
			hurlc.setDoOutput(true);
			hurlc.setDoInput(true);
			hurlc.setUseCaches(false);
			hurlc.setDefaultUseCaches(false);
			
			PrintWriter out = new PrintWriter(hurlc.getOutputStream());
			out.println(query);
			out.close();
			
			OutputStream ops = hurlc.getOutputStream();
			ops.write(query.getBytes());
			ops.flush();
			ops.close();
			
//			BufferedReader in = new BufferedReader(new InputStreamReader(hurlc.getInputStream()));
//			String inputLine = null;
//			
//			while ((inputLine = in.readLine()) != null ) {
//				System.out.println(inputLine);
//			}
//			in.close();
			
			
			fos = new FileOutputStream("PostFile.html");
			InputStream ins = hurlc.getInputStream();

			
			byte[] buffer = new byte[512];
			int readcount = 0;
			System.out.println("읽어오기 시작합니다");
			while ((readcount = ins.read(buffer)) != -1) {
				fos.write(buffer, 0, readcount);
			}
			System.out.println("파일에 모두 저장했습니다.");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
