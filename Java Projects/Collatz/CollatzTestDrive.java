import java.io.*;
public class CollatzTestDrive {
	
	public static BufferedReader readInput () {
		BufferedReader b = new BufferedReader (new InputStreamReader(System.in));
		return b;
	}
	
	public static int readInt (final String s) {
		int x = 1;
		do {
			try {
				System.out.print(s);
				x = Integer.parseInt(readInput().readLine());
				break;
			}
			catch (Exception e) {
				System.out.println("An input error has ocurred.");
			}
		} while (true);
		return x;
	}
	
	public static char readChar (final String s) {
		char c = '1';
		do {
			try {
				System.out.println(s);
				c = (char) readInput().read();
				break;
			}
			catch (Exception e) {
				System.out.println("An input error has ocurred.");
			}
		} while (true);
		return c;
	}
	
	public static void main(String args[]) {
		System.out.println("Collatz Theory\n");
		Collatz c = new Collatz(1);
		char opc = '1';
		do {
			opc = readChar("1 - Enter \'n\' value\n2 - View sorted ascendent order\n3 - Exit");
			switch (opc) {
			case '1':
				Collatz aux = new Collatz(readInt("Enter max. value for \'n\' (1 - n): "));
				c = aux;
				c.sort();
				System.out.println(c.toString());
				break;
			case '2':
				System.out.println(c.ascendentOrder());
				break;
			case '3':
				break;
			default:
				System.out.println("Invalid option");
			}
		} while (opc != '3');
	}
	
}