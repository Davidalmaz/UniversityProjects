import java.util.Random;

public class Test {
	//El tiempo transcurrido en el iterativo es menor que en los hilos si los valores son menores o igual a cinco
	private static int max = 12;
	private static int min = 7;
	private static long tiempo_ini = 0, tiempo_fin = 0;
	
	public static long nsToSeg(final long ns) {
		return ns * Math.pow(10, -9);	//1 Nanosegundo = 10^-9 segundos.
	}

	public static void main(String[] args) {
		
		final int tamano = new Random().nextInt(max + 1 - min) + min; 
		
		try {
			Matriz A = new Matriz(tamano, 'A', true);
			Matriz B = new Matriz(tamano, 'B', true);
		
			System.out.println("Tamaño es: " + tamano + '\n');
		
			System.out.println(A.toString() + '\n' + B.toString());
		
			tiempo_ini = System.nanoTime();
			Matriz C = A.multiplicar(B);
			tiempo_fin = System.nanoTime();
		
			System.out.println("Tiempo transcurrido: " + (tiempo_fin - tiempo_ini) + "ns\n");
			System.out.println(C.toString());
		
			//beg y end son en las filas. No es como lo quería el profesor, que era por número de elemento.
			System.out.println("Usando hilos. Dividiendo la matriz \'A\' en dos y multiplicando ambas por \'B\'\n");
		
			Thread1 D = new Thread1(A, B, 0, tamano/2);
			Thread1 E = new Thread1(A, B, tamano/2, tamano);
		
			tiempo_ini = System.nanoTime();
			D.start();
			E.start();
			tiempo_fin = System.nanoTime();
		
			System.out.println("Tiempo transcurrido: " + (tiempo_fin - tiempo_ini) + "ns (" + nsToSeg() + ")");
		}
		catch (IllegalArgumentException ie) {
			System.err.println(ie.getMessage());
			System.exit(1);
		}
	
	}
}
