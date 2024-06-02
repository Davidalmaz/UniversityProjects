import java.util.Random;

public class Matriz {
	private int t1, t2;
	private char letter;
	private int m[][];
	
	public Matriz(final int t, final char letter, final boolean fill) {
		if (t1 < 0 || t2 < 0)
			throw new IllegalArgumentException("public Matriz(int t, char letter) - t debe ser mayor que cero");
		this.t1 = t;
		this.t2 = t;
		this.letter = letter;
		m = new int[t][t];
		if (fill)
			fillMatriz();
	}
	
	public Matriz(final int t1, final int t2, final char letter, final boolean fill) {
		if (t1 < 0 || t2 < 0)
			throw new IllegalArgumentException("public Matriz(int t1, int t2, char letter) - t1 o t2 deben ser mayores que cero");
		this.t1 = t1;	
		this.t2 = t2;
		this.letter = letter;
		m = new int[t1][t2];
		if (fill)
			fillMatriz();
	}
	
	public final void fillMatriz() {
		for (int i = 0; i < t1; ++i)
			for (int j = 0; j < t2; ++j)
				m[i][j] = new Random().nextInt(100) + 0;
	}
	
	public Matriz multiplicar(final Matriz B) {
		//Desactivado por efectos de pruebas de comparación con el hilo. El hilo realiza esta condición en su constructor
		/*if (B.getT1() != t2)
			throw new IllegalArgumentException("public Matriz multiplicar(Matriz B) - " +
			"El número de filas de la matriz " + letter + " no son iguales al número de columnas de la matriz " + B.getLetter());*/
		
		Matriz newMatriz = new Matriz(t1, B.getT2(), 'C', false);
		
		for (int i = 0; i < t1; ++i)
			for (int j = 0; j < B.getT2(); ++j) {
				int suma = 0;
				for (int k = 0; k < t2; ++k)
					suma += m[i][k] * B.getElement(k, j);
				newMatriz.setElement(i, j, suma);
			}
			
		return newMatriz;
	}
	
	public final int getT1() {
		return t1;
	}
	
	public final int getT2() {
		return t2;
	}
	
	public final int getElement(final int i, final int j) {
		return m[i][j];
	}
	
	public final char getLetter() {
		return letter;
	}
	
	public final void setElement(final int i, final int j, final int value) {
		if (i < 0 || j < 0)
			throw new IllegalArgumentException("Subindices \'i\' y \'j\' deben ser mayores que cero");
		if (i >= t1 || j >= t2)
			throw new IllegalArgumentException("Subindices \'i\' y \'j\' deben ser menores que \'n\' (" + t1 + ") y \'m\' (" + t2 + ")");
		m[i][j] = value;
	}
	
	public String toString() {
		String s = "Matriz " + letter + ": \n";
		for (int v[] : m) {
			for (int valor : v)
				s = s.concat(valor + "  ");
			s = s.concat("\n");
		}
		return s;
	}
}
