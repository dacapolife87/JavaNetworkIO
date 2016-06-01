package chap02;


class ExtendThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread 클래스를 상속");
	}
}
public class ExtendThreadTest {
	public static void main(String[] args) {
		Thread thread = new ExtendThread();
		thread.start();
	}
}

