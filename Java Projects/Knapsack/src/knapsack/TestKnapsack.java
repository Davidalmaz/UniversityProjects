
package knapsack;

import java.util.ArrayList;

public class TestKnapsack {
    
    static int max(int i, int j) { return (i > j) ? i : j; }
    
    static int knapSack(int W, int[] weight, int[] value, int n) {
        
        if (n == 0 || W == 0) return 0;
        
        if (weight[n - 1] > W)
            return knapSack (W, weight, value, n - 1);
        else
            return max(value[n - 1] + knapSack(W - weight[n - 1], weight, value, n - 1),
                       knapSack(W, weight, value, n - 1)
                    );
        
    }
    
    public static boolean compare(final int i, final int j) { return (i > j);}
    
    public static String sum(int[] data) {
        String s = "";
        
        int first = data[data.length - 1],
            second = data[data.length - 2];
        
        for (int i = data.length - 3; i >= 0; --i)
            if(compare(first, second))
                second += data[i]; 
            else
                first += data[i];
        
        s += s.concat(first + " " + second);
        return s;
    }
    
    public static void main(String[] args) {
        int[] value = new int[] {7, 4, 5, 3};
        int[] weight = new int[] {1, 3, 1, 4};
        int W = 7;
        int n = value.length;
        System.out.println("Max value: " + knapSack(W, weight, value, n));
        
        /*int[] data = {64, 4, 256, 16, 128, 2, 32, 8};
        System.out.println(sum(data));*/
    }
    
}
