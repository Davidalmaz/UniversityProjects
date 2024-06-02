package rascacielos;

public class Rascacielo {
    private final static int MIN_RANGO = 1,
                             MAX_RANGO = 99;
    private final static byte NÚMERO_COMPONENTES = 3;
    private short izq, der, alt;
    
    public Rascacielo(final short izq, final short der, final short alt) {
        if (!(isInRange(izq) && isInRange(der) && isInRange(alt)))
            throw new IllegalArgumentException(
                    "Componentes izq, der, alt del Rascacielo deben ser entre "
                    + MIN_RANGO + " y " + MAX_RANGO
            );
        if (der <= izq)
            throw new IllegalArgumentException("Se encontró un punto con izq >= der");
        this.der = der;
        this.izq = izq;
        this.alt = alt;
            
    }
    
    private boolean isInRange(final short number) {
        return number >= MIN_RANGO && number <= MAX_RANGO;
    }
    
    public boolean isUnion(final Rascacielo r) {
        return der > r.der;
    }
    
    public boolean isInterception(final Rascacielo r) {
        return (der >= r.izq) && (r.der > der);
    }
    
    public boolean isDisjoint(final Rascacielo r) {
        return r.izq > der;
    }
    
    public boolean maxAltura(final Rascacielo r) {
        return alt >= r.alt;
    }
    
    public final short getIzq() {
        return izq;
    }
    
    public final short getDer() {
        return der;
    }
    
    public final short getAlt() {
        return alt;
    }
    
    public final String getHorVer(boolean izq) {
        return (izq) ? (this.izq + " " + alt) : (der + " " + alt);
    }
    
}
