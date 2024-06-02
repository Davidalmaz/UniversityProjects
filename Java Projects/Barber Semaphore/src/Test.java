public class Test {

	public static void main(String[] args) {
		SemaphoresQueue q = new SemaphoresQueue();
		Customer cust = new Customer(q);
		Barber b = new Barber(q);
		Cashier ca = new Cashier(q);
	}

}
