package mudanza;

public class Pertenencia {
    private final static int MAX_WEIGHT = 60000,
                             MIN_WEIGHT = 0;
    private final int weight;
    
    public Pertenencia(final int weight) {
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT)
            throw new IllegalArgumentException("Uno de los elementos supera el peso máximo o es un número negativo");
        this.weight = weight;
    }
    
    public final int getWeight() {
        return weight;
    }
}
