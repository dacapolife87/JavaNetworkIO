
public class Producer implements Runnable{
	private Queue queue = null;
	
	public Producer(Queue queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("[ Start Producer.. ]");
		try {
			int i = 0;
			while (!Thread.currentThread().isInterrupted()) {
				queue.put(Integer.toString(i++));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("[ End producer.. ]");
		}
	}
	
}
