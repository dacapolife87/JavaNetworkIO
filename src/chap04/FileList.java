package chap04;

import java.io.File;

public class FileList {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("���� : java FileList ���丮��");
			System.exit(0);
		}
		
		File f = new File(args[0]);
		if (!f.exists()) {
			System.out.println("���丮�� �������� �ʽ��ϴ�.");
			System.exit(0);
		}

		if (f.isDirectory()) {
			File[] fileList = f.listFiles();
			
			for (int i = 0; i < fileList.length; i++) {
				System.out.print(fileList[i].getName());
				System.out.print("\t");
				
				if (fileList[i].isDirectory()) {
					System.out.print("���丮");
				}else {
					System.out.print("����");
					System.out.print("\t");
					System.out.println(fileList[i].length());
				}
				
			}
		}else {
			System.out.println("���丮�� �ƴմϴ�.");
		}
	}
}
