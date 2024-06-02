public final class FactorialTestDrive {
	public static void main(String[] args) {
		final int testnumber = 5;
		Factorial fi = new FIterative(testnumber);
		Factorial fr = new FRecursive(testnumber);
		fi.start();
		fr.start();
	}
}