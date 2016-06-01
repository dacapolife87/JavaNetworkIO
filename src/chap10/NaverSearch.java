package chap10;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class NaverSearch {

	public static void main(String[] args) {
//		if(args.length != 2	){
//			System.out.println("���� : java NaverSearch keyword filename");
//			System.exit(1);
//		}
		
		try {
			String word = "���";
			String filename = "apple.html";
			String keyword = URLEncoder.encode(word);
			
			String query = "query="+keyword;
			String u = "https://search.naver.com/search.naver";
			//https://www.google.co.kr/search?q=%BB%E7%B0%FA&cad=h
			System.out.println("�˻� ������ : "+ u+query);
			
			URL url = new URL(u);
			URLConnection connection = url.openConnection();
			connection.setUseCaches(false);
			HttpURLConnection hurlc = (HttpURLConnection) connection;
			//connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setDefaultUseCaches(false);
			connection.setRequestProperty("User-Agent", "Mozilla/4.76");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
//			PrintWriter out = new PrintWriter(hurlc.getOutputStream());
//			System.out.println("check1");
//			out.println(query);
//			out.close();
			OutputStream output = hurlc.getOutputStream();
			output.write(query.getBytes());
			output.flush();
			output.close();
			
			
			System.out.println("check2");
			BufferedReader in = new BufferedReader(new InputStreamReader(hurlc.getInputStream()));
			System.out.println("check3");
			PrintWriter pw = new PrintWriter(new FileWriter(filename));
			System.out.println("check4");
			String inputLine = null;
			
			while ((inputLine = in.readLine()) != null) {
				pw.println(inputLine);
			}
			in.close();
			pw.close();
			System.out.println("�˻��� ����� "+args[1]+ "���Ͽ� ����Ǿ����ϴ�.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
