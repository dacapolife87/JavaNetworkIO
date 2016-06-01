package chap04;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("data.bin");
			dis = new DataInputStream(fis);
			
			boolean b = dis.readBoolean();
			byte b2 = dis.readByte();
			int i = dis.readInt();
			double d = dis.readDouble();
			String s = dis.readUTF();
			
			System.out.println("boolean : "+b);
			System.out.println("byte : "+b2);
			System.out.println("int : "+i);
			System.out.println("double : "+d);
			System.out.println("String : "+s);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}finally {
			try {
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
				try {
					dis.close();
				} catch (Exception e3) {
					// TODO: handle exception
				}
			}
		}
	}
}
