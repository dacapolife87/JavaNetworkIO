package chap13;

import java.nio.ByteBuffer;

public class RelativeBufferTest {
	public static void main(String[] args) {
		ByteBuffer buf = ByteBuffer.allocate(10);
		
		System.out.print("Init position : "+ buf.position());
		System.out.print(",  Init Limit : "+ buf.limit());
		System.out.println(", Init Capacity : "+buf.capacity());
		
		buf.mark();
		
		buf.put((byte)10).put((byte)11).put((byte)12);
		
		buf.reset();
		
		System.out.println("Value : "+buf.get() +", Position : "+buf.position());
		buf.mark();
		System.out.println("Value : "+buf.get() +", Position : "+buf.position());
		System.out.println("Value : "+buf.get() +", Position : "+buf.position());
		
		System.out.println("Value : "+buf.get() +", Position : "+buf.position());
		
		buf.put(1, (byte)3);
		buf.reset();
		System.out.println("Value : "+buf.get() +", Position : "+buf.position());
	}
}
