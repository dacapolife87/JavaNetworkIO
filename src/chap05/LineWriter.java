package chap05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LineWriter {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("사용법 : java LineWriter 파일명");
			System.exit(0);
		}
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(new BufferedWriter(new FileWriter(args[0])));
			
			String line = null;
			
			while ((line = br.readLine()) != null ) {
				System.out.println("읽어들인 문자열 : "+line);
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
