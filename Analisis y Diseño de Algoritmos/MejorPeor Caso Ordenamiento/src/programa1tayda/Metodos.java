package programa1tayda;


public class Metodos {
    
    public double[] burbuja(double []x,double cantidad){
        for(int i = 0; i < cantidad - 1; i++)
        {
            for(int j = 0; j < cantidad - 1; j++)
            {
                if (x[j] > x[j + 1])
                {
                    double tmp = x[j+1];
                    x[j+1] = x[j];
                    x[j] = tmp;
                }
            }
        }
        return x;
    }
    public double[] insercion(double []x,double cantidad){
        double aux;
        for (int p = 1; p < cantidad; p++){ 
              aux = x[p]; 
              int j = p - 1; 
              while ((j >= 0) && (aux < x[j])){ 
                                                                    
                             x[j + 1] = x[j];       
                             j--;                   
              }
              x[j + 1] = aux; 
        }
        return x;
    }
    
    public double[] seleccion(double [] x,double cantidad){
         int  pos;
         double menor,tmp;
          for (int i = 0; i < cantidad - 1; i++) { 
                menor = x[i]; 
                pos = i; 
                for (int j = i + 1; j < cantidad; j++){ 
                      if (x[j] < menor) { 
                          menor = x[j]; 
                          pos = j;
                      }
                }
                if (pos != i){ 
                    tmp = x[i];
                    x[i] = x[pos];
                    x[pos] = tmp;
                }
          }
          return x;
    }
    public double[] selecciond(double [] x,double cantidad){
         int  pos;
         double mayor,tmp;
          for (int i = 0; i < cantidad - 1; i++) { 
                mayor = x[i]; 
                pos = i; 
                for (int j = i + 1; j < cantidad; j++){ 
                      if (x[j] > mayor) { 
                          mayor = x[j]; 
                          pos = j;
                      }
                }
                if (pos != i){ 
                    tmp = x[i];
                    x[i] = x[pos];
                    x[pos] = tmp;
                }
          }
          return x;
    }
    public double[] insercionp(double []x,double cantidad){
        double aux;
        for (int i = 1; i < cantidad; i++){ 
              aux = x[i]; 
              int j = i - 1; 
              while ((j >= 0) && (aux < x[j])){ 
                                                                    
                             x[j + 1] = x[j];       
                             j--;                   
              }
              x[j + 1] = aux;
              if(i+1==cantidad/2){
                  break;
              }
        }
        return x;
    }
}
