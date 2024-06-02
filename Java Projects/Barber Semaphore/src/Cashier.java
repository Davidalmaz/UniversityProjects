public class Cashier implements Runnable {
	private SemaphoresQueue sq;
	
	public Cashier(final SemaphoresQueue sq) {
		this.sq = sq;
		new Thread(this).start();
	}
	
	public void run() {
		sq.cashier();
	}
}
