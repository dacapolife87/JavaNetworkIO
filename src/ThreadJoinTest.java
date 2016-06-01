
public class ThreadJoinTest {
	public static void main(String[] args) {
		Thread t = new Thread(){
			public void run(){
				try {
					Thread.sleep(2000);
					System.out.println("my thread 종료");
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		};
		t.start();
		
		try {
			t.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("main() 종료");
	}
}
