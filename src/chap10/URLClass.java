package chap10;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLClass {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String strEncoding = URLEncoder.encode("�ڵ���", "utf-8");
		String strDecoding = URLDecoder.decode(strEncoding, "utf-8");

		System.out.println("�ڵ���");
		System.out.println("���ڵ��� ���ڿ�:"+strEncoding);
		System.out.println("���ڵ��� ���ڿ�:"+strDecoding);
	}
}
