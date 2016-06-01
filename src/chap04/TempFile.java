package chap04;

import java.io.File;
import java.io.IOException;

public class TempFile {
	public static void main(String[] args) {
		try {
			File f = File.createTempFile("tmp_", ".dat");

			System.out.println("60√  µøæ» ∏ÿ√Á¿÷Ω¿¥œ¥Ÿ.");
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			f.deleteOnExit();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
