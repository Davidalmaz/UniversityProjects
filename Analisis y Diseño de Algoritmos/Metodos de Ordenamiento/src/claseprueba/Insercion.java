package claseprueba;

public class Insercion 
{
	public Insercion()
	{
	
	}
	
	public void metodoInsercion(int arreglo[], int cantidad, int inicio)
	{
		int x, temp;

	    for (int i = inicio; i < cantidad; i++)
	    {
	        x = i;

	        while (x > 0 && arreglo[x] < arreglo[x - 1])
	        {
	            temp = arreglo[x];
	            arreglo[x] = arreglo[x - 1];
	            arreglo[x - 1] = temp;
	            x--;
	        }
	    }
	}
}
