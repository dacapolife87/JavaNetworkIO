
public class DaemonThreadTest {
	public static void main(String[] args) {
		Thread t = new Thread(){
			public void run(){
				try {
					Thread.sleep(5000);
					System.out.println("mythread ����");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		};
		
		t.setDaemon(true);
		
		t.start();
		System.out.println("main() ����");
	}
}

