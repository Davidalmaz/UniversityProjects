import java.util.concurrent.Semaphore;

public final class Queue {
	private TicTacToe table;
	static Semaphore semX;
	static Semaphore semY;
	
	public Queue(final TicTacToe table) {
		this.table = table;
		semX = new Semaphore(0);
		semY = new Semaphore(1);
	}
	
	public void putX() {
		try {
			semX.acquire();
			//semY.acquire();
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		if (table.getRemaining() > 0) {
			table.markSpace(Thread.currentThread().getName().charAt(0), (byte)0, (byte)0);
			System.out.println(table.toString());
		}
		semY.release();
	}
	
	public void putY() {
		try {
			//semX.acquire();
			semY.acquire();
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		if (table.getRemaining() > 0) {
			table.markSpace(Thread.currentThread().getName().charAt(0), (byte)0, (byte)0);
			System.out.println(table.toString());
		}
		semX.release();
	}
	
}