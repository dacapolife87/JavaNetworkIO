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

		System.out.println("��������      url.getProtocol(): "+ url.getProtocol());
		System.out.println("ȣ��Ʈ��      url.getHost()    : "+ url.getHost());
		System.out.println("��Ʈ��ȣ      url.getPort()    : "+ url.getPort());
		System.out.println("���ϸ�         url.getPath()    : "+ url.getPath());
		System.out.println("����� ����  url.getQuery()   : "+ url.getQuery());
		
	}
}
