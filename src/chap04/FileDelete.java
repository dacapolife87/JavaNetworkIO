package chap04;

import java.io.File;

public class FileDelete {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("���� : java FileDelete ���ϸ�");
			System.exit(0);
		}
		
		File f = new File(args[0]);
		if (f.exists()) {
			boolean deleteflag = f.delete();
			
			if(deleteflag){
				System.out.println("���� ������ ���� �߽��ϴ�.");
			}else {
				System.out.println("���� ������ �����߽��ϴ�.");
			}
		}else {
			System.out.println("������ �������� �ʽ��ϴ�.");
		}
	}
}
