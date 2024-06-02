
public class HeapSort {
    
    /**
     *
     * @param arr
     */
    public void buildheap(int []arr) {
      
    for(int i = (arr.length - 1) / 2; i >= 0 ; i--)
        heapify(arr, i, arr.length - 1);
   }
 
   public void heapify(int[] arr, int i,int size) { 
      int left  = 2 * i + 1,
          right = 2 * i + 2;
      int max = 0;
      
      max = (left <= size && arr[left] > arr[i]) ? left : i;
 
      if (right <= size && arr[right] > arr[max])
            max = right;
      
      if(max != i) {
         exchange(arr, i, max);
         heapify(arr, max, size);
      }
   }
 
   public void exchange(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t; 
   }
 
   public void heapSort(int[] arr) {
     
      buildheap(arr);
      int sizeOfHeap = arr.length-1;
      
      for(int i = sizeOfHeap; i > 0; i--) {
         exchange(arr, 0, i);
         sizeOfHeap = sizeOfHeap - 1;
         heapify(arr, 0, sizeOfHeap);
      }
   }
    
}
