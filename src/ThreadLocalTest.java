import java.util.Random;

public class ThreadLocalTest {
	static volatile int counter = 0;
	
	static Random random = new Random();
	
	private static class ThreadLocalObject extends ThreadLocal {
		Random random = new Random();
		
		protected Object initialValue(){
			return new Integer(random.nextInt(1000));
		}
	}
	
	static ThreadLocal threadlocal = new ThreadLocalObject();
	
	private static void displayValues() {
		System.out.println("Thread Nam : "
				+ Thread.currentThread().getName()
				+ ", initalValut : "
				+ threadlocal.get()
				+ ", counter : "
				+ counter);
	}
	
	
	public static void main(String[] args) {
		displayValues();
		
		Runnable runner = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (ThreadLocalTest.class) {
					counter++;
				}
				displayValues();
				
				try {
					Thread.sleep(((Integer)threadlocal.get()).intValue());
					displayValues();
					
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		};
		
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(runner);
			t.start();
		}
	}
}
