public final class Producer implements Runnable {
	private Queue q;
	
	Producer(final Queue q, final int i) {
		this.q = q;
		new Thread(this, "Producer " + i).start();
	}
	
	public void run() {
		for (int i = 0; i < 10; ++i)
			q.put(i);
	}
}