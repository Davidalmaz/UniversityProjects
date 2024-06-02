import java.util.concurrent.Semaphore;

public class Queue {
	private int value;
	static Semaphore SemCon = new Semaphore(0);
	static Semaphore SemPro = new Semaphore(1);
	//static Semaphore SemLeft = new Semaphore(6);
	
	void get() {
		try {
			SemCon.acquire();	//wait()
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " tomó: " + value);
		SemPro.release();		//signal();
		//SemLeft.release();
	}
	
	void put(final int n) {
		/*try {
			SemLeft.acquire();
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}*/
		try {
			SemPro.acquire();	//wait()
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		value = n;
		System.out.println(Thread.currentThread().getName() + " agregó: " + n);
		SemCon.release();		//signal()	
	}
}