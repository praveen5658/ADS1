import java.util.*;
class Sorting {
    Sorting() {

    }
    public int partition(Comparable[] array, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(array[++i], array[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(array[low], array[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, low, j);
        System.out.println(toString(array));
        return j; 
    }
    
    /**
     * Time complexity is O(1)
     */
    private void sort(Comparable[] array, int low, int high, int cutoff){
      if (high <= low + cutoff - 1) {
        insertionSort(array, low, high);
        System.out.println("insertionSort called");
        return;
      }
      int j = partition(array, low, high);
      sort(array, low, j - 1, cutoff);
      sort(array, j + 1, high, cutoff);
    }

    /**
     * Time complexity is O(1)
     */
    public void sort(Comparable[] array, int cutoff) {
        sort(array, 0, array.length-1, cutoff);
    }
    /**
     * Time complexity is O(N^2)
     */
    public void insertionSort(Comparable[] array, int low, int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(array[j], array[j-1]); j--) {
                swap(array, j, j-1);
            }
        }
    }
    /**
     * Time complexity is O(1)
     */
    public void swap(Comparable[] array, int i, int j) {
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
    /**
     * Time complexity is O(1)
     */
    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * Time complexity is O(N)
     */
    public Object toString(Object[] a) {
        String s = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            s += a[i] + ", ";
        }
        s = s + a[a.length - 1] + "]";
        return s;
    }
}
