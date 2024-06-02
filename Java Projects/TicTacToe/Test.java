import java.io.*;
public final class Test {
	
	public static BufferedReader read() {
		BufferedReader b = new BufferedReader (new InputStreamReader (System.in));
		return b;
	}
	
	public static Byte readByte() {
		byte number = 0;
		boolean error = false;
		do {
			error = false;
			try {
				number = Byte.parseByte(read().readLine());
			}
			catch (NumberFormatException nfe) {
				System.err.print("Non-number character entered. Try again: ");
				error = true;
			}
			catch (IOException ie) {
				System.err.print("Inavlid value. Try again.");
				error = true;
			}
		} while(error);
		return number;
	}
	
	public static void main(String[] args) {
		TicTacToe t;
		byte opc = 0;
		
		try {
			System.out.print("Enter table size (Only odd numbers): ");
			byte size = readByte();
			t = new TicTacToe(size);
		}
		catch (IllegalArgumentException iae) {
			System.err.println("Please enter odd numbers.\nSetting default value");
			t = new TicTacToe();
		}
		
		System.out.println(t.getSize() + "x" + t.getSize() + " TicTacToe");
		System.out.println(t.toString());
		
		/*do {
			System.out.println(t.getSize() + "x" + t.getSize() + " TicTacToe");
			System.out.println("1 - Player vs AI\n2 - Player vs Player\n3 - Exit");
			opc = readByte();
			
			switch(opc) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					System.err.println("Invalid input. Try again.");
			}
		}
		while (opc != 3);	*/
	}
	
}