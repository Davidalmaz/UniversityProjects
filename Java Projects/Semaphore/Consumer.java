public final class Consumer implements Runnable {
	private Queue q;
	
	Consumer(final Queue q, final int i) {
		this.q = q;
		new Thread(this, "Consumer " + i).start();
	}
	
	public void run() {
		for (int i = 0; i < 4; ++i)
			q.get();
		/*for (int i = 0; q.SemCon.getQueuedLength != 0; ++i) {
			q.get();
		}*/
	}
}