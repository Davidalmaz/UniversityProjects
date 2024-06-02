package mudanza;

import java.util.ArrayList;

public class Camión {
    private ArrayList<Pertenencia> p;
    private int totalWeight;
    
    public Camión(final int weight) {
        totalWeight = weight;
    }
    
    public final int getPeso() {
        return totalWeight;
    }
    
}
