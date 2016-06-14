package chap13;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
 
public class DirectBufferCapacityExample {
 
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        System.out.println("byte 저장 용량: " + byteBuffer.capacity());
 
        CharBuffer charBuffer = ByteBuffer.allocateDirect(100).asCharBuffer();
        System.out.println("char 저장 용량: " + charBuffer.capacity());
        
        IntBuffer intBuffer = ByteBuffer.allocateDirect(100).asIntBuffer();
        System.out.println("int 저장 용량: " + intBuffer.capacity());
        byteBuffer.order(ByteOrder.nativeOrder());
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        
    }
 
}