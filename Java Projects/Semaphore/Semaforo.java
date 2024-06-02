public class Semaforo {
	private int contador, c, e;
	private Semaforo cola[];
	
	public Semaforo() {
		contador = 1;
		cola = new Semaforo[10];
	}
	
	public Semaforo(final int x) {
		if (x < 1)
			throw new IllegalArgumentException("Argument in Semaforo(int) must be >= 1");
		contador = 1;
		cola = new Semaforo[x];
	}
	
	public void push(final Semaforo s) {
		cola[c] = s;
		c++;
	}
	
	public Semaforo pop() {
		Semaforo s = cola[e];
		e++;
		return s;
	}
}