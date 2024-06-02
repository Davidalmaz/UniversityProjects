import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DateFormat;

public class Factorial extends Thread implements Time, Date {
	protected int value;
	
	public Factorial() {
		value = 1;
	}
	
	public Factorial(final int value) {
		if (value < 1)
			throw new IllegalArgumentException("Value less than 1. Try again.");
		this.value = value;
	}
	
	public final long time() {
		return System.nanoTime();
	}
	
	public final String date() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		return df.format(cal.getTime());
	}
}