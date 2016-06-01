package chap04;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteArrayInputOutputTest {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("���� : java ByteArrayInputOutputTest ���ϸ�");
			System.exit(0);
		}
		
		FileInputStream fis = null;
		ByteArrayInputStream bais = null;
		ByteArrayOutputStream baos = null;
		
		try {
			fis = new FileInputStream(args[0]);
			baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[512];
			int readcount = 0;
			
			while ((readcount = fis.read(buffer)) != -1) {  //  ���Ϸκ��� �о����
				baos.write(buffer, 0, readcount);			// ����Ʈ��̾ƿ��ὺƮ������ �о���� ���� ������
			}
			
			byte[] fileArray = baos.toByteArray();
			System.out.println("������ ������ ��� �о� �鿩 byte[]�� ��������ϴ�.");
			System.out.println("�о���� byte�� �� : "+fileArray.length);
			
			bais = new ByteArrayInputStream(fileArray);
			
			while ((readcount = bais.read(buffer)) != -1) {
				System.out.write(buffer, 0, readcount);
				
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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
