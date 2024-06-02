import java.util.concurrent.Semaphore;
import java.util.*;

public class SemaphoresQueue {
	static Semaphore mutex1, mutex2;
	static Semaphore sofa;
	static Semaphore max_size;
	static Semaphore barber_chair, coord;
	static Semaphore cust_ready;
	static Semaphore leave_b_chair;
	static Semaphore finished[];
	static Semaphore payment;
	static Semaphore receipt;
	private Queue<Integer> customersList = new LinkedList<Integer>();
	
	private int max_capacity = 50;
	private int count = 0;
	
	public SemaphoresQueue() {
		mutex1 = new Semaphore(1);
		mutex2 = new Semaphore(1);
		sofa = new Semaphore(4);
		max_size = new Semaphore(20);
		barber_chair = new Semaphore(3);
		coord = new Semaphore(3);
		leave_b_chair = new Semaphore(0);
		cust_ready = new Semaphore(0);
		payment = new Semaphore(0);
		receipt = new Semaphore(0);
		finished = new Semaphore[max_capacity];
		for (int i = 0; i < max_capacity; ++i)
			finished[i] = new Semaphore(0);
	}
	
	public void customer() {
		int customerNumber = 0;
		try {
			max_size.acquire();
			System.out.println("A customer enters the barber shop...");
			mutex1.acquire();
			customerNumber = count;
			count++;
			System.out.println("It's identified as customer: " + customerNumber);
			mutex1.release();
			sofa.acquire();
			System.out.println("Customer " + customerNumber + " sat on the sofa");
			barber_chair.acquire();
			System.out.println("Barber chair free...");
			System.out.println("Customer " + customerNumber + " got up from the sofa");
			sofa.release();
			System.out.println("Customer " + customerNumber + " sat on the barber chair");
			mutex2.acquire();
			customersList.add(customerNumber);
			System.out.println("Customer " + customerNumber + " is ready");
			cust_ready.release();
			mutex2.release();
			finished[customerNumber].acquire();
			System.out.println("Customer " + customerNumber + " got up from the barber chair");
			leave_b_chair.release();
			System.out.println("Customer " + customerNumber + " made a payment");
			payment.release();
			receipt.acquire();
			System.out.println("Customer " + customerNumber + " is leaving the barber shop");
			max_size.release();	
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	public void barber() {
		try {
			int custNumber = 0;
			cust_ready.acquire();
			mutex2.acquire();
			custNumber = customersList.remove();
			mutex2.release();
			coord.acquire();
			System.out.println("Barber is cutting hair to customer " + custNumber + " now");
			coord.acquire();
			System.out.println("Barber is done with customer " + custNumber);
			finished[custNumber].release();
			leave_b_chair.acquire();
			barber_chair.release();
		}
		catch (NoSuchElementException nsee) {
			nsee.printStackTrace();
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	
	public void cashier() {
		try {
			payment.acquire();
			coord.acquire();
			System.out.println("Cashier accepted payment a payment");
			coord.release();
			receipt.release();
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
