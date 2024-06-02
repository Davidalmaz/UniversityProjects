public class Customer implements Runnable {
	private SemaphoresQueue sq;
	
	public Customer(final SemaphoresQueue sq) {
		this.sq = sq;
		new Thread(this).start();
	}
	
	public void run() {
		sq.customer();
	}
}
