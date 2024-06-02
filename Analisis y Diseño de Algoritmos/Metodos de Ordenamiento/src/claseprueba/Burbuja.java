package claseprueba;

public class Burbuja 
{
    
    public Burbuja()
    {
        
    }
    
    public void metodoBurbuja(int arreglo[])
    {
        
        for(int i = 0; i < arreglo.length - 1; i++)
        {
            
            for(int j = 0; j < arreglo.length - 1; j++)
            { 
                if (arreglo[j] < arreglo[j + 1])
                {
                    int tmp = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }    
    }
}