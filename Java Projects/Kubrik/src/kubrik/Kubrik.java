package kubrik;

import java.util.ArrayList;
import java.util.Arrays;

public class Kubrik {
    private static final byte MAX_DEPTH = (byte)5;
    private static final String LINE_BREAK = System.getProperty("line.separator");
    
    private ArrayList<Byte> disposiciónInicial = new ArrayList<>(Arrays.asList((byte)1, (byte)2, (byte)3, (byte)4, (byte)5, (byte)6, (byte)7, (byte)8));
    private final ArrayList<Byte> disposiciónFinal;
    private final ArrayList<Character> ops;
    private ArrayList<Character> operaciones = new ArrayList<>();
    private ArrayList<Character> solución = new ArrayList<>();
    private byte depthSolución;
    
    public Kubrik(final ArrayList<Byte> dispFinal) {
        if (dispFinal.size() != disposiciónInicial.size())
            throw new IllegalArgumentException("Tamaño de disposiciónFinal no es igual a " + disposiciónInicial.size());
        disposiciónFinal = dispFinal;
        ops = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'A', 'C'));  //Los dos últimos elementos son para el caso cuando B se repite tres veces.
        depthSolución = MAX_DEPTH;  //Inicialmente, no existe solución. Por eso se le coloca el nivel más profundo.
    }
    
    public String getSolución() {
        String s = "";
        greedyCrap((byte)0, disposiciónInicial, operaciones);
        s = s.concat(solución.size() + LINE_BREAK);
        for(char c : solución)
            s = s.concat(Character.toString(c) + LINE_BREAK);
        return s;
    }
    
    private void greedyCrap(byte i, ArrayList<Byte> combActual, ArrayList<Character> operaciones) {
        
        // ops = {'A', 'B', 'C', 'A', 'C'}
        // ops.size() / 2 + 1 = 3
        // ops.size() / 2 = 2
        boolean repeatedC = false,
                repeatedB = false;
        if (operaciones.size() >= 3) {
            repeatedC = repeatedB = true;
            for(byte j = (byte)((ops.size() / 2) - 1); i <= ops.size() / 2; ++j) {
                for(byte k = (byte)(operaciones.size() - 1), iter = 0; iter < 3; ++iter, --k)
                    if (!operaciones.get(k).equals(j)) {
                        repeatedB = false;
                        break;
                    }
                if (repeatedB)
                    break;
            }
        }
        
        byte beg = 0, till = (byte)((ops.size() / 2) + 1);
        // ops = {'A', 'B', 'C', 'A', 'C'}
        // ops.size() / 2 + 1 = 3
        // ops.size() / 2 = 2
        
        if (repeatedB) {
            beg = till;
            till = (byte) ops.size();
        }
        else
            if (repeatedC)
                till = (byte) (ops.size() / 2);
            else
                if (!operaciones.isEmpty() && operaciones.get(operaciones.size() - 1) == 'A')
                    beg = 1;
        
        for (; beg < till; ++beg) {
            Combinación c = new Combinación(ops.get(beg), (ArrayList<Byte>) combActual.clone());
            operaciones.add(ops.get(beg));
            if (!c.getComb().equals(disposiciónFinal)) {
                if (i < depthSolución)
                    greedyCrap((byte)(i + 1), c.getComb(), (ArrayList<Character>) operaciones.clone());
            }
            else
                if (solución.size() > operaciones.size() || solución.isEmpty()) {
                    solución = (ArrayList<Character>) operaciones.clone();
                    depthSolución = i;
                    break;
                }
            operaciones.remove(operaciones.size() - 1);
        }
                    
        
        /*if (repeatedB) {
            for (byte l = (byte)((ops.size() / 2) + 1); l < ops.size(); ++l) {
                Combinación c = new Combinación(ops.get(l), (ArrayList<Byte>) combActual.clone());
                operaciones.add(ops.get(l));
                if (!c.getComb().equals(disposiciónFinal)) {
                    if (i < depthSolución)
                        greedyCrap((byte)(i + 1), c.getComb(), (ArrayList<Character>) operaciones.clone());
                }
                else
                    if (solución.size() > operaciones.size() || solución.isEmpty()) {
                        solución = (ArrayList<Character>) operaciones.clone();
                        depthSolución = i;
                        break;
                    }
                operaciones.remove(operaciones.size() - 1);
            }
        }
        else
            if (repeatedC) {
                for (byte l = 0; l < ops.size() / 2; ++l) {
                    Combinación c = new Combinación(ops.get(l), (ArrayList<Byte>) combActual.clone());
                    operaciones.add(ops.get(l));
                    if (!c.getComb().equals(disposiciónFinal)) {
                        if (i < depthSolución)
                            greedyCrap((byte)(i + 1), c.getComb(), (ArrayList<Character>) operaciones.clone());
                    }
                    else
                        if (solución.size() > operaciones.size() || solución.isEmpty()) {
                            solución = (ArrayList<Character>) operaciones.clone();
                            depthSolución = i;
                            break;
                        }
                    operaciones.remove(operaciones.size() - 1);
                }
            } 
            else
                if (!operaciones.isEmpty() && operaciones.get(operaciones.size() - 1) == 'A') {
                    for (byte l = 1; l <= ops.size() / 2; ++l) {
                        Combinación c = new Combinación(ops.get(l), (ArrayList<Byte>) combActual.clone());
                        operaciones.add(ops.get(l));
                        if (!c.getComb().equals(disposiciónFinal)) {
                            if (i < depthSolución)
                                greedyCrap((byte)(i + 1), c.getComb(), (ArrayList<Character>) operaciones.clone());
                        }
                        else
                            if (solución.size() > operaciones.size() || solución.isEmpty()) {
                                solución = (ArrayList<Character>) operaciones.clone();
                                depthSolución = i;
                                break;
                            }
                        operaciones.remove(operaciones.size() - 1);
                    }
                }
                else {
                    for (byte j = 0; j <= ops.size() / 2; ++j) {
                        Combinación c = new Combinación(ops.get(j), (ArrayList<Byte>) combActual.clone());
                        operaciones.add(ops.get(j));
                        if (!c.getComb().equals(disposiciónFinal)) {
                            if (i < depthSolución)
                                greedyCrap((byte)(i + 1), c.getComb(), (ArrayList<Character>) operaciones.clone());
                        }
                        else
                            if (operaciones.size() < solución.size() || solución.isEmpty()) {
                                solución = (ArrayList<Character>) operaciones.clone();
                                depthSolución = i;
                                break;
                            }
                        operaciones.remove(operaciones.size() - 1);
                    }
                }*/
    }
    
}
