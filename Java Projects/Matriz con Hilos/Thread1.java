public class Thread1 extends Thread {
	private Matriz A, B;
	private int beg, end;
	
	public Thread1 (final Matriz A, final Matriz B, final int beg, final int end) {
		if (B.getT1() != A.getT2())
			throw new IllegalArgumentException("Thread1(Matriz A, Matriz B, int beg, int end) - " +
			"El número de filas de la matriz " + A.getLetter() + " no son iguales al número de columnas de la matriz " + B.getLetter());
		if (beg < 0 || end < 0)
			throw new IllegalArgumentException("Thread1(Matriz A, Matriz B, int beg, int end) - beg deben ser mayor o igual a cero");
		if (beg == end)
			this.end = end + 1;
		this.A = A;
		this.B = B;
		this.beg = beg;
		this.end = end;
	}
	
	public Matriz multiplicar() {
		
		Matriz newMatriz = new Matriz(A.getT1(), B.getT2(), 'C', false);
	
		for (int i = beg; i < end; ++i)				//beg y end son en las filas. No es como lo quería el profesor, que era por número de elemento.
			for (int j = 0; j < B.getT2(); ++j) {
				int suma = 0;
				for (int k = 0; k < A.getT2(); ++k)
					suma += A.getElement(i, k) * B.getElement(k, j);
				newMatriz.setElement(i, j, suma);
			}
			
		return newMatriz;
	}
	
	public void run() {
		multiplicar();
	}
	
}
