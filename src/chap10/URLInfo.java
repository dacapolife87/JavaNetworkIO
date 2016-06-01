package chap10;

import java.net.MalformedURLException;
import java.net.URL;

public class URLInfo {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("사용법 :  java WebSpider URL");
			System.exit(0);
		}
		
		URL url = null;
		try {
			url = new URL(args[0]);
		} catch (MalformedURLException e) {
			// TODO: handle exception
			System.out.println("잘못된 URL형식 입니다.");
			System.out.println(e);
			System.exit(0);
		}
		
		System.out.println("프로토콜 : "+ url.getProtocol());
		System.out.println("호스트명 : "+ url.getHost());
		System.out.println("포트번호 : "+ url.getPort());
		System.out.println("파일명 : "+ url.getPath());
		System.out.println("사용자 쿼리 : "+ url.getQuery());
	}
}
