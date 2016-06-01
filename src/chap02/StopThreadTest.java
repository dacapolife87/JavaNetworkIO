package chap02;



class StopThread implements Runnable {
	private boolean stopped = false;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!stopped) {

		}
	}
	public void stop() {
		stopped = true;
	}
}
public class StopThreadTest {
	public static void main(String[] args) {
		
	}
}
