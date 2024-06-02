public final class BankAccount {
	private int balance;
	
	public BankAccount() {
		balance = 100;
	}
	
	public final int getBalance() {
		return balance;
	}
	
	public void withdraw(final int i) {
		balance -= i;
	}
}