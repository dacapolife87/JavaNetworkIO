package chap14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StreamTest {
	static FileInputStream in =null;
	
	public static void main(String[] args) throws Exception {
		in = new FileInputStream("c://java//1.pdf");
		
		TestThread t =new TestThread(in);
		
		t.start();
		
		Thread.sleep(2000);
		
		System.out.println("in.available() : "+in.available());
		
		t.interrupt();
	}
	
	static class TestThread extends Thread{
		FileInputStream in = null;
		
		public TestThread(FileInputStream o){
			in = o;
		}
		
		public void run(){
			try {
				int v = 0;
				
				while((v=in.read())!= -1){
					System.out.println("Thread start...");
					System.out.println("v : "+v);
					Thread.sleep(10);
				}
				in.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Thread end...");
			}
		}
	}
}
