package chap10;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLEX {
	public static void main(String[] args) {
		
		String urladdr = "https://search.naver.com/search.naver?&query=%ED%95%9C%EA%B8%80";
		URL url = null;
		try {
			url = new URL(urladdr);			
		} catch (MalformedURLException e) {
			// TODO: handle exception
		}

		System.out.println("프로토콜      url.getProtocol(): "+ url.getProtocol());
		System.out.println("호스트명      url.getHost()    : "+ url.getHost());
		System.out.println("포트번호      url.getPort()    : "+ url.getPort());
		System.out.println("파일명         url.getPath()    : "+ url.getPath());
		System.out.println("사용자 쿼리  url.getQuery()   : "+ url.getQuery());
		
	}
}
