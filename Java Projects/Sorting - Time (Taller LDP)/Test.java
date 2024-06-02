import java.util.Random;

public final class Test {
	private static int max = 500000;
	private static int min = 5000;
	
	public static int[] createArray(final int n) {
		Random r = new Random();
		int array[] = new int[n];
		for (int i = 0; i < array.length; ++i)
			array[i] = r.nextInt(max) + min;
		return array;
	}
	
	public static double nsToSeg(final long number) {
		return (double) number * Math.pow(10, -9);
	}
	
    public static void main(String[] args) {
        long t1, t2, difference;
		//100k+ Elementos.
		Random r = new Random();
		int n = r.nextInt(max) + min;
		
		System.out.println("n is = " + n);
		
        InsertSort is = new InsertSort();
        SelectSort ss = new SelectSort();
		
        t1 = is.time();
        is.sort(createArray(n));
        t2 = is.time();
		difference = t2 - t1;
        System.out.println("Insert Sort = " + difference + " ns (" + nsToSeg(difference) + " seg)");
		
        t1 = ss.time();
        ss.sort(createArray(n));
        t2 = ss.time();
		difference = t2 - t1;
        System.out.println("Select Sort = " + difference + " ns (" + nsToSeg(difference) + " seg)");
    }
}
