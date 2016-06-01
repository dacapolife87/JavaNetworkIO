package chap02;

import javax.security.auth.login.AccountException;

public class SynchronizedTest {
	public void tempFunc(){
		Example ex = new Example();
		// 동기화 블록 사용
		synchronized (ex) {
			// 1. 작업1
			// 2. 작업2
		}
	}

	
	/*public synchronized void tempFunc(){
		// 메소드에 선언
		initSomething();
		// 1. 작업1
		// 2. 작업2
	}*/
	private void initSomething() {
		// TODO Auto-generated method stub
		
	}
}

class Example{
	
}

