
public class Consumer implements Runnable{
	private Queue queue = null;
	private String name = null;

	public Consumer(Queue queue, String index) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
		name =  "Consumer - "+index;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("[ start "+name+ "...]");
		try {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println(name + " : "+queue.pop().toString());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("[End "+name + "...]");
		}
	}
	
	
}
