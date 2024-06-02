package claseprueba;
public class Seleccion 
{	
	public Seleccion()
	{
		
	}
	
	public void metodoSeleccion(int arreglo[])
	{
            int pos,j,temp,low;
	 for (int i = 0; i < arreglo.length - 1; i++) {
                low = arreglo[i]; 
                pos = i; // y guardamos su posición
                for (j = i + 1; j < arreglo.length; j++){ // buscamos en el resto
                      if (arreglo[j] < low) { // del array algún elemento
                          low = arreglo[j]; // menor que el actual
                          pos = j;
                      }
                }
                if (pos != i){ // si hay alguno menor se intercambia
                    temp = arreglo[i];
                    arreglo[i] = arreglo[pos];
                    arreglo[pos] = temp;
                }
          }	
	}
}
