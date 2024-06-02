public final class RunThreads implements Runnable {
	public static void main(String args[]) {
		RunThreads r = new RunThreads();	//Runnable
		Thread alpha = new Thread(r);		//Thread 1
		Thread beta = new Thread(r);		//Thread 2
		alpha.setName("Alpha");
		beta.setName("Beta");
		alpha.start();
		beta.start();
	}
	
	public void run() {
		for (int i = 0; i < 5; ++i) {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " is running");
		}		
	}
		
}