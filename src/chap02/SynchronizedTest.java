package chap02;

import javax.security.auth.login.AccountException;

public class SynchronizedTest {
	public void tempFunc(){
		Example ex = new Example();
		// ����ȭ ��� ���
		synchronized (ex) {
			// 1. �۾�1
			// 2. �۾�2
		}
	}

	
	/*public synchronized void tempFunc(){
		// �޼ҵ忡 ����
		initSomething();
		// 1. �۾�1
		// 2. �۾�2
	}*/
	private void initSomething() {
		// TODO Auto-generated method stub
		
	}
}

class Example{
	
}

