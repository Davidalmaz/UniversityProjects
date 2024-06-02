public class Barber implements Runnable {
	private SemaphoresQueue sq;
	
	public Barber(final SemaphoresQueue sq) {
		this.sq = sq;
		new Thread(this).start();
	}
	
	public void run() {
		sq.barber();
	}
}
