public class Collatz {
	private int n, numbers[];
	
	public Collatz(final int n) {
		this.n = Math.abs(n);
		numbers = new int[this.n];
	}
	
	public void sort() {
		for (int i = 1; i <= n; ++i) {
			int steps = 0;
			int x = i;
			do {
				if (x % 2 == 0)
					x /= 2;
				else
					x = x * 3 + 1;
				steps++;
			} while (x > 1);
			numbers[i-1] = steps;
		}
	}
	
	public String toString() {
		String s = "";
		for (int i = 1; i <= n; ++i)
			s = s.concat("For " + i + ": " + numbers[i-1] + "\n");
		return s;
	}
	
	public String ascendentOrder() {
		int aux[] = numbers; 
		String s = "";
		boolean allMinusOne;
		do {
			int minorIndex = 0;
			int minorNumber = 300000000;
			allMinusOne = true;
			for (int i = 0; i < n; ++i) {
				if (aux[i] == -1)
					continue;
				else {
					allMinusOne = false;
					if (minorNumber > aux[i]) {
						minorIndex = i;
						minorNumber = aux[i];
					}
				}
			}
			if (allMinusOne == false) {
				s = s.concat("For " + (minorIndex + 1) + ": " + aux[minorIndex] + "\n");
				aux[minorIndex] = -1;
			}
		} while (!allMinusOne);
		
		return s;
	}

}