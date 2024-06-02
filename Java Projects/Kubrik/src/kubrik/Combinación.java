package kubrik;

import java.util.ArrayList;

public class Combinación {
    private ArrayList<Byte> comb;
    private char operación;
    
    public Combinación(final char operación, ArrayList<Byte> comb) {
        this.comb = comb;
        this.operación = operación;
        switch(operación) {
            case 'A': case 'a':
                A();
                break;
            case 'B': case 'b':
                B();
                break;
            case 'C': case 'c':
                C();
                break;
            default:
                throw new IllegalArgumentException("Unknown operation. Allowed: A, B, C");
        }
    }
    
    private void A() {
        for (byte i = 0, div = (byte) (comb.size() / 2), size = (byte)(comb.size() - 1); i < div; ++i)
            swap(i, (byte)(size - i));
    }
    
    private void B() {
        byte aux  = comb.get(3),
             aux2 = comb.get(4);
        
        for (byte i = (byte)((comb.size() / 2) - 1); i > 0; --i)
            copy((byte) (i - 1), i);
        
        for (byte i = (byte)((comb.size() / 2) + 1); i < comb.size(); ++i)
            copy(i, (byte)(i - 1));
            
        comb.set(0, aux);
        comb.set(comb.size() - 1, aux2);
    }
    
    private void C() {
        byte aux1 = comb.get(2);
        byte aux2 = comb.get(6);
        
        comb.set(2, comb.get(1));
        comb.set(6, comb.get(5));
        
        comb.set(1, aux2);
        comb.set(5, aux1);
    }
    
    private void swap(byte i, byte j) {
        byte aux = comb.get(i);
        comb.set(i, comb.get(j));
        comb.set(j, aux);
    }
    
    private void copy(byte i, byte j) {
        comb.set(j, comb.get(i));
    }
    
    public final char getOperación() {
        return operación;
    }
    
    public final ArrayList<Byte> getComb() {
        return comb;
    }
}
