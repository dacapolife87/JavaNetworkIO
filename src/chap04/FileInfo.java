package chap04;

import java.io.File;
import java.io.IOException;

public class FileInfo {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("���� : java FileInfo ���ϸ�");
			System.exit(0);
		}
		File f = new File (args[0]);
		if(f.exists()){
			System.out.println("length : "+f.length());
			System.out.println("canRead : "+f.canRead());
			System.out.println("canwrith : "+f.canWrite());
			System.out.println("getAbsolutePath : "+f.getAbsolutePath());
			
			try {
				System.out.println("getCanonicalPath : "+f.getCanonicalPath());
			} catch (IOException e) {
				// TODO: handle exception
				System.out.println(e);
			}
			System.out.println("getName : "+f.getName());
			System.out.println("getParent : "+f.getParent());
			System.out.println("getPath : "+f.getPath());
		}else{
			System.out.println("������ �������� �Ƚ��ϴ�.");
		}
	}
}
