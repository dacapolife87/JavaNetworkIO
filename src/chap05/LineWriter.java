package chap05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LineWriter {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("���� : java LineWriter ���ϸ�");
			System.exit(0);
		}
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(new BufferedWriter(new FileWriter(args[0])));
			
			String line = null;
			
			while ((line = br.readLine()) != null ) {
				System.out.println("�о���� ���ڿ� : "+line);
				pw.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				pw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
