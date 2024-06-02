package mudanza;

import java.util.ArrayList;
import sorting.HeapSort;

public class Mudanza {
    
    private static final byte  MIN_N = 4;
    private static final short MAX_N = (short)10000;
    
    //private Camión c1, c2;
    private ArrayList<Pertenencia> belongings;
    private short n;
    private HeapSort sort = new HeapSort();
    
    public Mudanza(final short n, final ArrayList<Pertenencia> pertenencia) {
        if (n % 2 != 0)
            throw new IllegalArgumentException("N debe ser un número par");
            
        if (n < MIN_N|| n > MAX_N)
            throw new IllegalArgumentException("N debe ser mayor o igual a " + MIN_N + ""
                                                 + " y menor o igual a " + MAX_N);
        
        if (pertenencia.size() < n)
                throw new IllegalArgumentException("La cantidad de pertenencias "
                                                    + "es menor que n(" + n + ")");
        
        this.belongings = pertenencia;
        this.n = n;
    }
    
    public String distributeBelongings() {
       sort.heapSort(belongings);
       int camión_1  = belongings.get(n - 1).getWeight(),   //útlimo
           camión_2  = belongings.get(n - 2).getWeight();   //Penúltimo
       
       short total = (byte) (n - 3);   //aux de n. Nuevo último.
       
       short elementsPerTruck1; 
       short elementsPerTruck2;
       elementsPerTruck1 = elementsPerTruck2 = (short)((n / 2) - 1);
       
       /*for (short i = elementsPerTruck; i > 0; --i, --total)
           camión_2 += belongings.get(total).getWeight();
       
       for (short i = elementsPerTruck; i > 0; --i, --total)
           camión_1 += belongings.get(total).getWeight();*/
       
       for (short i = total; i >= 0; --i) {
           int elemento = belongings.get(i).getWeight();
           
           if (elementsPerTruck2 > 0)
               if (elementsPerTruck1 > 0) {
                   if (camión_2 <= camión_1) {
                       camión_2 += elemento;
                       elementsPerTruck2--;  
                   }
                   else {
                       camión_1 += elemento;
                       elementsPerTruck1--;  
                   }    
               }
               else
                   camión_2 += elemento;
           else
               camión_1 += elemento;
       }
                       
           
          /* if (elementsPerTruck2 > 0 && camión_2 <= camión_1) {
                  camión_2 += elemento;
                  elementsPerTruck2--;  
           }
           else
               if (elementsPerTruck1 > 0 && camión_2 >= camión_1) {
                  camión_1 += elemento;
                  elementsPerTruck1--;
               }
       }*/
       
       /*c1 = new Camión(totalWeight);
       c2 = new Camión(totalWeight2);*/
       
       return camión_1 + " " + camión_2;
    }
    
    /*public final Camión getCamión(final byte number) {
        return (number == 1) ? c1 : c2;
    }*/
    
    public final int getPertenenciasSize() {
        return belongings.size();
    }
    
    public final int getN() {
        return n;
    }
     
    
}
