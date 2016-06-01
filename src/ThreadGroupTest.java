class groupThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.currentThread().isInterrupted()) {
				//System.out.println("Thread is alive..");
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		} finally {
			//System.out.println("Thread is dead..");
		}
	}
	
}
public class ThreadGroupTest {
	public static void main(String[] args) {
		System.out.println("Thread group Test : "+Thread.currentThread());
		
		ThreadGroup tGroup1 = 
				new ThreadGroup(Thread.currentThread().getThreadGroup(), "threadgroup1");
		ThreadGroup tGroup2 = new ThreadGroup("ThreadGroup2");
		ThreadGroup tGroup3 = new ThreadGroup(tGroup1, " ThreadGroup3");
		
		Thread t1 = new Thread(tGroup1,new groupThread(),"Thread-1");
		Thread t2 = new Thread(tGroup2,new groupThread(),"Thread-2");
		Thread t3 = new Thread(tGroup3,new groupThread(),"Thread-3");
		
		System.out.println("   t1 : "+t1);
		System.out.println("   t2 : "+t2);
		System.out.println("   t3 : "+t3);
		
		
		t1.start();
		t2.start();
		t3.start();
		System.out.println("main 스레드 그룹 : "
				+ Thread.currentThread().getThreadGroup()
				+ ", 활동중인 스레드 갯수 : "
				+ Thread.currentThread().getThreadGroup().activeCount()
				+ ", 활동중인 스레드 그룹갯수 : "
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		
		Thread.currentThread().getThreadGroup().list();
	}
}
