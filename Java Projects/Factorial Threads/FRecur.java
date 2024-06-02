public class FRecur extends Factorial {
	private int auxValue;
	
	public FRecur() {
		super();
		auxValue = value;
	}
	
	public FRecur(final int value) {
		super(value);
		auxValue = value;
	}
	
	public void run() {
		auxValue = value + 1;
		long t1 = Time();
		double result = recur();
		long t2 = Time();
		long tf = t2- t1;
		System.out.println("FRecursive(): Result = " + result + " - Time = " + tf + " - Input: " + value);
	}
	
	public final double recur() {
		--auxValue;
		if (auxValue == 1)
			return 1;
		return auxValue * recur();
	}
	
	
}