package rascacielos;

import java.util.ArrayList;
import sorting.HeapSort;

public class Centro {
    private final static short MAX_N = (short)99,
                               MIN_N = (short)1;
    private short n;
    private ArrayList<Rascacielo> rascacielos;
    private ArrayList<Silueta> siluetas = new ArrayList<>();
    private HeapSort sorting = new HeapSort();
    
    public Centro(final short n, ArrayList<Rascacielo> rascacielos) {
        if (n < MIN_N && n > MAX_N)
            throw new IllegalArgumentException("N debe ser entre " + MIN_N + " y " + MAX_N);
        if (rascacielos.size() < n)
            throw new IllegalArgumentException("La cantidad de rascacielos "
                                                    + "es menor que n(" + n + ")");
        this.rascacielos = rascacielos;
        this.n = n;
        sorting.heapSort(rascacielos);    //Ordenar de menor a mayor
    }
    
    public String getSiluetaString() {
        if (siluetas.size() == 0)
            siluetas = calcularSilueta();
        String s = "";
        for (Silueta c : siluetas)
            s = s.concat(c.toString() + '\n');
        return s; 
    }
    
    public ArrayList<Silueta> calcularSilueta() {            
        ArrayList<Silueta> coordenadas = new ArrayList<>();
        coordenadas.add(new Silueta(
                        rascacielos.get(0).getIzq(), 
                        rascacielos.get(0).getAlt()
                )
        );
        short mayorDerecha = rascacielos.get(0).getDer();
        
        for (short i = 1; i < rascacielos.size(); ++i) {
            Rascacielo r2 = rascacielos.get(i);
            
            if (r2.getDer() > mayorDerecha)
                mayorDerecha = r2.getDer();
            
            boolean isDisjoint = true;
            
            for (short j = (short)(i - 1); j >= 0; --j) {
                Rascacielo r1 = rascacielos.get(j);
                
                if (r1.isDisjoint(r2)) {
                            if (j == 0 && isDisjoint) {
                                Rascacielo r = rascacielos.get(i - 1);
                                coordenadas.add(new Silueta(r.getDer(), (short) 0));
                                coordenadas.add(new Silueta(r2.getIzq(), r2.getAlt()));
                            }
                }
                else {
                    if (!r1.maxAltura(r2)) {
                        if (r1.isUnion(r2)) {
                            coordenadas.add(new Silueta(r2.getIzq(), r2.getAlt()));
                            coordenadas.add(new Silueta(r2.getDer(), r1.getAlt()));
                        }
                        else
                            if (r1.isInterception(r2))
                                if (coordenadas.get(coordenadas.size() - 1).getHor() > r2.getIzq())
                                    coordenadas.set(coordenadas.size() - 1, new Silueta(r2.getIzq(), r2.getAlt()));
                                else
                                    if (coordenadas.get(coordenadas.size() - 1).getHor() != r2.getIzq())
                                        coordenadas.add(new Silueta(r2.getIzq(), r2.getAlt()));               
                    }
                    else {
                        if (r1.isInterception(r2))
                            coordenadas.add(new Silueta(r1.getDer(), r2.getAlt()));
                        else
                            break;
                    }
                    isDisjoint = false;
                }
            }
        }
        coordenadas.add(new Silueta(
                        mayorDerecha, 
                        (short) 0
                )
        );
        
        return coordenadas;
    }
    
    public final ArrayList<Silueta> getSiluetas() {
        return siluetas;
    }
    
    public final ArrayList<Rascacielo> getRascacielos() {
        return rascacielos;
    }
     
}
