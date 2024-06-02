package rascacielos;

public class Silueta {
    private short hor, ver;
    
    public Silueta(final short hor, final short ver) {
        this.hor = hor;
        this.ver = ver;
    }
    
    public final short getHor() {
        return hor;
    }
    
    public final short getVer() {
        return ver;
    }
    
    public final String toString() {
        return hor + " " + ver;
    }
}
