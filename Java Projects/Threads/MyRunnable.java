public final class MyRunnable implements Runnable {
	private static int id = 0;
	
	public MyRunnable() {
		new Thread(this, "Thread " + id++).start();
	}
	
	public void run() {
		System.out.println("I'm in MyRunnable" + "(" + Thread.currentThread().getName() + ")");
	}
}