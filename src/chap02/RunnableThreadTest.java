package chap02;


class RunnableThread implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Runnable �������̽��� ����");
	}
	
}
public class RunnableThreadTest {
	public static void main(String[] args) {
		Thread t = new Thread(new RunnableThread());
		t.start();
	}
}


