public final class TicTacToe {
	private char table[][];
	private byte data[][];	//Filas por Columnas
	private byte size = 3;
	private short remaining = 9;
	
	public TicTacToe() {
		table = new char[size][size];
		data = new byte[size + 1][2];	//La última fila es para diagonal y anti-diagonal
	}
	
	public TicTacToe(final byte number) {
		if (Math.abs(number) % 2 == 0)
			throw new IllegalArgumentException();
		size = (byte) Math.abs(number);
		table = new char[size][size];
		data = new byte[size+1][2];
		remaining = (short) Math.pow(remaining, 2);
	}
	
	public final String toString() {
		String tableString = "Current table:\n";
		for (byte i = 0; i < size; ++i)
			tableString = tableString.concat("______");
		tableString = tableString.concat("\n");
		for (char values[] : table) {
			for (byte i = 0; i < size; ++i)
				tableString = tableString.concat("     |");
			tableString = tableString.concat("\n");
			for (char value : values)
				tableString = tableString.concat("  " + value + "  |");
			tableString = tableString.concat("\n");
			for (byte i = 0; i < size; ++i)
				tableString = tableString.concat("_____|");
			tableString = tableString.concat("\n");
		}
		return tableString;
	}
	
	public void fillData(final char letter, final byte i, final byte j) {
		byte value = (letter == 'X') ? (byte)1 : (byte)-1;
		if (i == j)
			data[size][0] += value;
		else
			if (i + j == size - 1)
				data[size][1] += value;
		data[i][0] += value; 
		data[j][1] += value;
	}
	
	public void markSpace(final char letter, final byte i, final byte j) {
		if (table[i][j] == '\0')
			table[i][j] = letter;
		fillData(letter, i, j);
	}
	
	public bool playerWon(final byte i, final byte j) {
		return (data[i][j] == (size - 1));
	}
	
	public final byte getSize() {
		return size;
	}
	
	public final short getRemaining() {
		return remaining;
	}
	
}