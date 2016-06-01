package chap06;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class ObjectStreamTest1 {
	public static void main(String[] args) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		
		Vector v = new Vector();
		Vector v1 = new Vector();
		Vector v2 = new Vector();
		Vector v3 = new Vector();
		
		v1.addElement(new String("data 1"));
		v1.addElement(new String("data 2"));
		v1.addElement(new String("data 3"));
		v2.addElement(new String("data 4"));
		
		v3.addElement(v2);
		
		v.addElement(v1);
		v.addElement(v3);
		
		try {
			fout = new FileOutputStream("object.dat");
			oos = new ObjectOutputStream(fout);
			
			oos.writeObject(v);
			oos.reset();
			System.out.println("������ �Ǿ����ϴ�");
			
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
