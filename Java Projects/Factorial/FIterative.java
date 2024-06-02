public final class FIterative extends Factorial {
	
	public FIterative() {
		super();
	}
	
	public FIterative(final int value) {
		super(value);
	}
	
	public void run() {
		long t1 = time();
		double result = iter();
		long t2 = time();
		long tf = t2- t1;
		String f = date();
		System.out.println("Fiterative(): Result = " + result + " - Time = " + tf + " - " + f + " - Input: " + value);
	}
	
	public final double iter() {
		int suma = 1;
		for (int i = value; i > 1; --i)
			suma *= i;
		return suma;
	}
}