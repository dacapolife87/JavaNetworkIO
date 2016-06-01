package chap04;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamTest {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("data.bin");
			dos = new DataOutputStream(fos);
			dos.writeBoolean(true);
			dos.writeByte((byte)5);
			dos.writeInt(100);
			dos.writeDouble(200.5);
			dos.writeUTF("hello world");
			System.out.println("저장 했습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}finally {
			try {
				fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
				try {
					dos.close();
				} catch (Exception e3) {
					// TODO: handle exception
				}
			}
		}
	}
}
