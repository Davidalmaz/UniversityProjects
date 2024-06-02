import org.jfree.ui.RefineryUtilities; 
/*import org.jfree.chart.ChartUtilities; 
import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.List;*/
public class TestChart {
    
    private static long tiempo_ini = 0, tiempo_fin = 0;
    
    public static int[] fill(final int max, final boolean ascendente) {
        int[] elements = new int[max];
        //int j = max - 1;
        if (ascendente) 
            for (int i = 0; i < max; ++i)
                elements[i] = i;
        else
            for (int i = 0, j = (max - 1); i < max; ++i, --j)
                elements[i] = j;
        return elements;
    }
    
    public static int[] fillPromedio(final int max) {
        int[] elements = new int[max];
        int split = max / 2;
        for (int i = 0; i < split; ++i)
            elements[i] = i;
        for (int i = split, j = (max - 1); i < max; ++i, --j)
            elements[i] = j;
        return elements;
    }
    
     public static double nsToSeg(final long ns) {
	return ns * Math.pow(10, -9);	//1 Nanosegundo = 10^-9 segundos.
    }
     
     public static void benchmark(final int maxNumberOfN, int[] n, double[][] timeArray) {
         
         SelectionSort ss = new SelectionSort();
         HeapSort hp = new HeapSort();
         
         for (int i = 0; i < maxNumberOfN; ++i) {
           int[] elements = fill(n[i], true);
           //int[] elements = fillPromedio(n[i]);
           
           tiempo_ini = System.nanoTime();
           ss.sort(elements);        //SelectionSort
           tiempo_fin = System.nanoTime();
           
           timeArray[0][i] = tiempo_fin - tiempo_ini;
           
           tiempo_ini = System.nanoTime();
           hp.heapSort(elements);   //HeapSort
           tiempo_fin = System.nanoTime();
           
           timeArray[1][i] = tiempo_fin - tiempo_ini;
       }
     }
    
    public static void main(String[] args) {
       
       final int maxNumberOfN   = 10, //Número n
                 startingNumber = 10, //Número mínimo
                 multiplier     = 2;  //Multiplicador
       
       int[] n = new int[maxNumberOfN];
       double[][] timeArray = new double[2][maxNumberOfN];
       
       for (int i = 0, j = startingNumber; i < maxNumberOfN; ++i, j *= multiplier)
           n[i] = j;
       
       //double[] timeArray = {2.7, 10.8, 43.1, 172.4, 689.6};
       /*int[] elements = fillPromedio(6);
       System.out.println(Arrays.toString(elements));
       SelectionSort(elements);
       System.out.println("=========================");
       System.out.println(Arrays.toString(elements));*/
       
       benchmark(maxNumberOfN, n, timeArray);
 
       //System.out.println("Tiempo transcurrido: " + time + "ns (" + nsToSeg(time) + " seg)");
       
       XYLineChart_AWT chart = new XYLineChart_AWT("Algorithms benchmark",
         "Benchmark", n, timeArray);
       chart.pack( );          
       RefineryUtilities.centerFrameOnScreen( chart );          
       chart.setVisible( true );
       
    }
    
}
