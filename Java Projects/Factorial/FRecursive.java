public final class FRecursive extends Factorial {
	private int auxValue;
	
	public FRecursive() {
		super();
		auxValue = value;
	}
	
	public FRecursive(final int value) {
		super(value);
		auxValue = value;
	}
	
	public void run() {
		auxValue = value + 1;
		long t1 = time();
		double result = recur();
		long t2 = time();
		long tf = t2- t1;
		String f = date();
		System.out.println("FRecursive(): Result = " + result + " - Time = " + tf + " - " + f + " - Input: " + value);
	}
	
	public final double recur() {
		--auxValue;
		if (auxValue == 1)
			return 1;
		return auxValue * recur();
	}
}