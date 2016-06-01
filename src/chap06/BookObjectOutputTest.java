package chap06;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class BookObjectOutputTest {
	public static void main(String[] args) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		
		ArrayList list = new ArrayList();
		Book b1 = new Book("a0001", "자바완성", "홍길동", 10000);
		Book b2 = new Book("a0002", "스트럿츠", "김유신", 20000);
		Book b3 = new Book("a0003", "기초 EJB", "김성박", 25000);
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		ArrayList list2 = new ArrayList();
		try {
			fout = new FileOutputStream("booklist.dat");
			oos = new ObjectOutputStream(fout);
			
			oos.writeObject(list);
			//oos.reset();
			
			tempObj tt = new tempObj("테스트객체");
			list.add(tt);
			oos.writeObject(list);
			System.out.println("저장되었습니다");
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				oos.close();
				fout.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}

class tempObj implements Serializable{
	private String title;
	
	public tempObj(String title){
		this.title = title;
	}
	
	
}
