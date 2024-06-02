public final class TestDrive {
	
	public static void main(String[] args) {
		Queue q = new Queue();
		Producer p = new Producer(q, 1);
		Producer p2 = new Producer(q, 2);
		
		Consumer c = new Consumer(q, 1);
		Consumer c2 = new Consumer(q, 2);
		Consumer c3 = new Consumer(q, 3);
		Consumer c4 = new Consumer(q, 4);
		Consumer c5 = new Consumer(q, 5);
		
	}
}