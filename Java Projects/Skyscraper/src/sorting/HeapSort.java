package sorting;

import java.util.ArrayList;
import rascacielos.Rascacielo;

public class HeapSort {
    
    public void buildheap(ArrayList<Rascacielo> list) {
      
    /*
     * As last non leaf node will be at (arr.length-1)/2 
     * so we will start from this location for heapifying the elements
     * */
    /*for(int i = (arr.length - 1) / 2; i >= 0 ; i--)
        heapify(arr, i, arr.length - 1);*/
    
    for (int i = (list.size() - 1) / 2; i >= 0; --i)
        heapify(list, i, list.size() - 1);
   }
 
   public void heapify(ArrayList<Rascacielo> list, int i, int size) { 
      int left  = 2 * i + 1,
          right = 2 * i + 2;
      int max = 0;
      
      max = (left <= size && list.get(left).getIzq() > list.get(i).getIzq()) ? left : i;
 
      if (right <= size && list.get(right).getIzq() > list.get(max).getIzq())
            max = right;
      // If max is not current node, exchange it with max of left and right child
      if(max != i) {
         exchange(list, i, max);
         heapify(list, max, size);
      }
   }
 
   public void exchange(ArrayList<Rascacielo> arr, int i, int j) {
        Rascacielo t = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, t); 
   }
 
   public void heapSort(ArrayList<Rascacielo> arr) {
     
      buildheap(arr);
      int sizeOfHeap = arr.size() - 1;
      
      for(int i = sizeOfHeap; i > 0; i--) {
         exchange(arr, 0, i);
         sizeOfHeap = sizeOfHeap - 1;
         heapify(arr, 0, sizeOfHeap);
      }
     
   }
    
}


