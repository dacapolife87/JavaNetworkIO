package chap10;

import java.net.MalformedURLException;
import java.net.URL;

public class URLInfo {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("���� :  java WebSpider URL");
			System.exit(0);
		}
		
		URL url = null;
		try {
			url = new URL(args[0]);
		} catch (MalformedURLException e) {
			// TODO: handle exception
			System.out.println("�߸��� URL���� �Դϴ�.");
			System.out.println(e);
			System.exit(0);
		}
		
		System.out.println("�������� : "+ url.getProtocol());
		System.out.println("ȣ��Ʈ�� : "+ url.getHost());
		System.out.println("��Ʈ��ȣ : "+ url.getPort());
		System.out.println("���ϸ� : "+ url.getPath());
		System.out.println("����� ���� : "+ url.getQuery());
	}
}
