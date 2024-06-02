public class PlayerAI implements Runnable {
	private TicTacToe table;
	//private char letter;
	private static byte number = 0;
	private Queue queue;
	
	public PlayerAI(final TicTacToe table, final Queue queue) {
		this.table = table;
		this.queue = queue;
		/*this.letter = toUpperCase(letter);
		if (letter != 'X' && letter != Y)
			throw new IllegalArgumentException("Letter must be 'X' or 'Y'");*/
		char letter = (char) (88 - (number * 9));
		number++;
		new Thread(this, Character.toString(letter)).start();
	}
	
	public void run() {
		while(true) {
			if (table.getRemaining() != 0) {
				if (Thread.currentThread().getName().equals("X")) 
					queue.putX(); 
				else
					queue.putY();
			}	
			else
				break;
		}
	}
	
}