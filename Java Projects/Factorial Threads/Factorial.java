
public class Factorial extends Thread implements Time {
	protected int value;
	
	public Factorial() {
		value = 1;
	}
	
	public Factorial(final int value) {
		if (value < 1)
			throw new IllegalArgumentException("Value less than 1. Try again.");
		this.value = value;
	}
	
	public final long Time() {
		return System.nanoTime();
	}
}