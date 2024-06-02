public class Fiter extends Factorial {
	
	Fiter(final int value) {
		super(value);
	}
	
	Fiter() {
		super();
	}
	
	public void run() {
		long t1 = Time();
		double res = iter();
		long t2 = Time();
		long tf = t2-t1;
		System.out.println("FItere(): Result = " + res + " - Time = " + tf + " - Input: " + value);
	}
	
	public double iter() {
		int h = 1;
		for (int i = value; i > 0; --i) {
			h *= i;
		}
		return h;
	}
}