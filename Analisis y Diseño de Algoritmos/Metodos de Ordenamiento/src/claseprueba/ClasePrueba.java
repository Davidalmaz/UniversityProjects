package claseprueba;

import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.jfree.ui.RefineryUtilities;

public class ClasePrueba 
{
	public static final short cantidadMaxima = 500;
	
	public static String random(int cant, byte num)
	{
		String nombreArchivo = "Archivo" + num + ".txt";
		
		File out = new File(nombreArchivo);
		FileWriter fw = null;
		
		int n = cant;
		
		try
		{
			fw = new FileWriter(out);
			
			BufferedWriter writer = new BufferedWriter(fw);
			
			int line = 0;
			
			Random random = new Random();
			
			while (n > 0)
			{
				line = random.nextInt(1000);
				writer.write(String.valueOf(line));
				writer.newLine();
				n--;
			}
			
			writer.close();
		}
		
		catch (IOException e)
		{
			System.out.println("Ha ocurrido un error intentando abrir el archivo");
		}
		
		return nombreArchivo;
	}
	
	public static void leerArchivo(String nombreArchivo, int cantidadArreglo, int arreglo[]) throws IOException
	{
		String linea = null;
		
		short cant = 0;
		
		String arr[] = new String[cantidadArreglo];
		
		try
		{
			FileReader fl = new FileReader(nombreArchivo);
			
			BufferedReader br = new BufferedReader(fl);
			
			while ((linea = br.readLine()) != null)
			{
				arr = linea.split(" ");
				
				arreglo[cant++] = Integer.parseInt(arr[0]);
			}
			
			br.close();
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("El árchivo no se encuentra. \n");
		}
		
		int arregloFinal[] = new int[cant];
		
		for (short d = 0; d < cant; d++)
			arregloFinal[d] = arreglo[d];
		
		arreglo = arregloFinal;
		
		//arregloFinal = null;
	}
	
	public static void mejorCaso(int arreglo[], int cantidadArreglo)
	{
		Insercion i = new Insercion();
		
		i.metodoInsercion(arreglo, cantidadArreglo, 0);
	}
	
	public static void casoPromedio(int arreglo[], int cantidadArreglo)
	{
		Insercion i = new Insercion();
		
		int cant = cantidadArreglo / 2;
		
		i.metodoInsercion(arreglo, cant, 0);
		i.metodoInsercion(arreglo, cantidadArreglo, cant);
	}
	
	public static void peorCaso(int arreglo[], int cantidadArreglo)
	{
		int temp = 0;
		
		for (int d = 0; d < cantidadArreglo; d++)
		{
			for (int k = 1; k < cantidadArreglo - 1; k++)
			{
				if (arreglo[k - 1] < arreglo[k])
				{
					temp = arreglo[k - 1];
					arreglo[k - 1] = arreglo[k];
					arreglo[k] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException 
	{
		String nombreArchivo = "";
		
		double duracion[] = new double[9];
		
		int arreglo[] = new int[cantidadMaxima];
		int arreglo2[] = new int[cantidadMaxima * 2];
		int arreglo3[] = new int [cantidadMaxima * 4];
		
		byte num = 1;
		
		// Generar primer árchivo
		
		nombreArchivo = random(cantidadMaxima, num);
		
		leerArchivo(nombreArchivo, arreglo.length, arreglo);
		
		peorCaso(arreglo, arreglo.length);
		
		// Generar segundo árchivo
		
		nombreArchivo = "";
		
		num++;
		
		nombreArchivo = random(cantidadMaxima, num);
		
		leerArchivo(nombreArchivo, arreglo2.length, arreglo2);
		
		peorCaso(arreglo2, arreglo2.length);
		
		// Generar tercer árchivo
		
		nombreArchivo = "";
		
		num++;
		
		nombreArchivo = random(cantidadMaxima, num);
		
		leerArchivo(nombreArchivo, arreglo3.length, arreglo3);
		
		peorCaso(arreglo3, arreglo3.length);
		
		// Arreglo 1
		
		// Método de inserción
		
		Insercion i = new Insercion();
		
		double inicio, fin;
		inicio =  fin = 0;
		
		inicio = System.nanoTime();
		
		i.metodoInsercion(arreglo, arreglo.length, 0);
		
		fin = System.nanoTime();
		
		duracion[0] = (fin - inicio) / 1000000000;
		
		System.out.println("N = " + arreglo.length + " - " + duracion[0] + " (Método de Inserción)");
		
		// Método Selección
		
		inicio = fin = 0;
		
		inicio = System.nanoTime(); 
		
		Seleccion s = new Seleccion();
		
		s.metodoSeleccion(arreglo);
		
		fin = System.nanoTime();
		
		duracion[1] = (fin - inicio) / 1000000000;
		
		System.out.println("N = " + arreglo.length + " - " + duracion[1] + " (Método de Selección)");
                
                //Método Burbuja
                
                inicio=fin=0;
                
                inicio= System.nanoTime();
                
                Burbuja b = new Burbuja();
                
                b.metodoBurbuja(arreglo);
                
                fin= System.nanoTime();
                
                duracion[2] = (fin - inicio) / 1000000000;
                
                System.out.println("N = " + arreglo.length + " - " + duracion[2] + " (Método Burbuja)");
		
		// Arreglo 2
		
		inicio = fin = 0;
		
		inicio = System.nanoTime();
		
		i.metodoInsercion(arreglo2, arreglo2.length, 0);
		
		fin = System.nanoTime();
		
		duracion[3] = (fin - inicio) / 1000000000;
		
		System.out.println("N = " + arreglo2.length + " - " + duracion[3] + " (Método de Selección)");
		
		// Método Selección
		
		inicio = fin = 0;
		
		inicio = System.nanoTime(); 
		
		s.metodoSeleccion(arreglo2);
		
		fin = System.nanoTime();
		
		duracion[4] = (fin - inicio) / 1000000000;
		
		System.out.println("N = " + arreglo2.length + " - " + duracion[4] + " (Método de Selección)");
                
                //Método Burbuja
                
                inicio=fin=0;
                
                inicio= System.nanoTime();
                
                b.metodoBurbuja(arreglo2);
                
                fin= System.nanoTime();
                
                duracion[5] = (fin - inicio) / 1000000000;
                
                System.out.println("N = " + arreglo2.length + " - " + duracion[5] + " (Método Burbuja)");
		
		// Arreglo 3
		
		inicio = fin = 0;
		
		inicio = System.nanoTime();
		
		i.metodoInsercion(arreglo3, arreglo3.length, 0);
		
		fin = System.nanoTime();
		
		duracion[6] = (fin - inicio) / 1000000000;
		
		System.out.println("N = " + arreglo3.length + " - " + duracion[6] + " (Método de Inserción)");
		
		// Método Selección
		
		inicio = fin = 0;
		
		inicio = System.nanoTime(); 
		
		s.metodoSeleccion(arreglo3);
		
		fin = System.nanoTime();
		
		duracion[7] = (fin - inicio) / 1000000000;
		
		System.out.println("N = " + arreglo3.length + " - " + duracion[7] + " (Método de Selección)");
                
                //Método Burbuja
                
                inicio=fin=0;
                
                inicio= System.nanoTime();
                
                b.metodoBurbuja(arreglo3);
                
                fin= System.nanoTime();
                
                duracion[8] = (fin - inicio) / 1000000000;
                
                System.out.println("N = " + arreglo3.length + " - " + duracion[8] + " (Método Burbuja)");
                
                //Graficar
		
                //Inserción
                
		final Grafica g1 = new Grafica("Peor caso (Insercion)", arreglo.length, arreglo2.length, arreglo3.length, duracion[0], duracion[3], duracion[6]);
		
		g1.pack();
		
		RefineryUtilities.centerFrameOnScreen(g1);
		g1.setVisible(true);
                
                //Selección
		
		final Grafica g2 = new Grafica("Peor caso (Selección)", arreglo.length, arreglo2.length, arreglo3.length, duracion[1], duracion[4], duracion[7]);
		
		g2.pack();
		
		RefineryUtilities.centerFrameOnScreen(g2);
		g2.setVisible(true);
                
                //Burbuja
                
                final Grafica g3 = new Grafica("Peor caso (Burbuja)", arreglo.length, arreglo2.length, arreglo3.length, duracion[2], duracion[5], duracion[8]);
		
		g3.pack();
		
		RefineryUtilities.centerFrameOnScreen(g3);
		g3.setVisible(true);
	}

}
