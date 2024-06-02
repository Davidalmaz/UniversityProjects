public final class MonicaAndRyanJob implements Runnable {
	private BankAccount account = new BankAccount();
	private int maxAmount;
	
	public MonicaAndRyanJob() {
		new Thread(this, "Ryan").start();
		new Thread(this, "Monica").start();
		maxAmount = 5;
	}
	
	public MonicaAndRyanJob(final int amount) {
		if (amount < 0)
			throw new IllegalArgumentException("Maximum Amount must be more than 0");
		this.maxAmount = amount;
	}
	
	public void run() {
		while(true) {
			if (account.getBalance() <= 0) {
				System.out.println("Overdrawn");
				break;
			}
			makeWidthdrawal((int)Math.floor(Math.random() * maxAmount) + 1);
			//makeWidthdrawal(amount);
			/*try {
				System.out.println(Thread.currentThread().getName() + " is about to sleep");
				Thread.sleep(10);
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}*/
			//System.out.println(Thread.currentThread().getName() + " woke up");
		}
	}
	
	public synchronized void makeWidthdrawal(final int amount) {
		String tName = Thread.currentThread().getName();
		if (account.getBalance() >= amount) {
			System.out.println(tName + " is about to withdraw " + amount + " from account");
			/*try {
				System.out.println(Thread.currentThread().getName() + " is about to sleep");
				Thread.sleep(10);
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}*/
			//System.out.println(Thread.currentThread().getName() + " woke up");
			account.withdraw(amount);
			System.out.println(tName + " completes the withdrawl - Account balance: " + account.getBalance());
		}
		else
			System.out.println("Sorry, not enough for " + tName + " - Amount requested: " + amount);
	}
	
	public static void main(String[] args) {
		try {
			MonicaAndRyanJob job = new MonicaAndRyanJob();
			//Thread one = new Thread(job, "Ryan").start();	//Ryan
			//Thread two = new Thread(job, "Monica").start();	//Monica
		}
		catch(IllegalArgumentException iae) {
			System.err.println(iae.getMessage());
		}
		
	}
}