package chap02;


class ExtendThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread Ŭ������ ���");
	}
}
public class ExtendThreadTest {
	public static void main(String[] args) {
		Thread thread = new ExtendThread();
		thread.start();
	}
}

