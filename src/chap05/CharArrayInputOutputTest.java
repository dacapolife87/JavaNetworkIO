package chap05;

import java.io.BufferedWriter;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class CharArrayInputOutputTest {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("���� : java CharArrayInputOutputTest ���ϸ�");
			System.exit(0);
		}

		FileReader fis = null;

		CharArrayReader bais = null;
		CharArrayWriter baos = null;

		try {
			fis = new FileReader(args[0]);
			baos = new CharArrayWriter();
			char[] buffer = new char[512];
			int readcount = 0;

			while ((readcount = fis.read(buffer)) != -1 ) {
				baos.write(buffer, 0 ,readcount);
			}

			char[] fileArray = baos.toCharArray();
			System.out.println("������ ������ ��� �о�鿩 Char[] �� ��������ϴ�.");
			System.out.println("�о���� char�� �� : "+fileArray.length);

			bais = new CharArrayReader(fileArray);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			OutputStreamWriter osw = new OutputStreamWriter(System.out);
			while ((readcount = bais.read(buffer)) != -1) {
				osw.write(buffer, 0, readcount);
				osw.flush();
				//bw.write(buffer, 0, readcount);
				//bw.flush();
			}
			System.out.println("\n\n");
			System.out.println("�о���� ������ ��� ����߽��ϴ�.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				fis.close();
				bais.close();
				baos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
