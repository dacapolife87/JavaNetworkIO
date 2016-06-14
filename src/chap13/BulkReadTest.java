package chap13;

import java.nio.ByteBuffer;
import java.util.Iterator;

public class BulkReadTest {
	public static void main(String[] args) {
		ByteBuffer buf = ByteBuffer.allocate(10);
		buf.put((byte)0).put((byte)1).put((byte)2).put((byte)3).put((byte)4);
		buf.mark();
		buf.put((byte)5).put((byte)6).put((byte)7).put((byte)8).put((byte)9);
		buf.reset();
		
		byte[] b = new byte[15];
		
		int size = buf.remaining();
		System.out.println(size); // buf 의 남은 크기  5, b의 길이는 15
		if(b.length < size){
			size = b.length;	// 
		}
		
		buf.get(b, 0, size);
		
		System.out.println("Position : "+buf.position()+ ", Limit : "+buf.limit());
		
		doSomething(b,size);
		buf.reset();
		System.out.println("Position : "+buf.position()+ ", Limit : "+buf.limit());
	}
	
	public static void doSomething(byte[] b, int size){
		for (int i = 0; i<size; i++) {
			System.out.println("byte = "+b[i]);
		}
	}
}
