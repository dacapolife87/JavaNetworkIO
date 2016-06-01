class AdvancedStopTread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println("Thread is alive..");
				//Thread.sleep(500);
				while (true) {
					System.out.println("Thread is alive..");
					//Thread.sleep(500);
				}
			}
		} finally {
			System.out.println("Thread is dead..");
		}
	}
	
}
public class AdvancedStopThreadTest {
	public static void main(String[] args) {
		System.out.println("# start advancedstopThreadTest.java");
		AdvancedStopThreadTest astt = new AdvancedStopThreadTest();
		astt.process();
	}
	public void process(){
		AdvancedStopTread ast = new AdvancedStopTread();
		
		Thread thread = new Thread(ast);
		thread.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		thread.interrupt();
	}
}
