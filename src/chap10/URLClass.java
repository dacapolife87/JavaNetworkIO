package chap10;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLClass {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String strEncoding = URLEncoder.encode("자동차", "utf-8");
		String strDecoding = URLDecoder.decode(strEncoding, "utf-8");

		System.out.println("자동차");
		System.out.println("인코딩된 문자열:"+strEncoding);
		System.out.println("디코딩된 문자열:"+strDecoding);
	}
}
