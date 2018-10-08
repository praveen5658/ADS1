import java.util.Arrays;
class MinHeap<E extends Comparable<E>>{
	private E[] array;
	private int size;
	protected MinHeap(int len){
		array = (E[])new Comparable[len + 1];
		size = 0;
	}
	public boolean insert(E value){
		array[++size] = value;
		// System.out.println(size);
		return(swim(size));
	}
	public boolean swim(int k){
		while(k>1 && less(k/2, k)){
			// swap(k, k/2);
			k = k/2;
		}
		if (k>1){
			return false;
		}
		return true;
	}
	// public void swap(E one, E two){
	// 	E temp = array[one];
	// 	array[one] = array[two];
	// 	array[two] = temp;
	// }
	public boolean less(int one, int two){
		// System.out.println((array[one].compareTo(array[two]))<0);
		return((array[one].compareTo(array[two]))<=0);
	}
	public String toString(){
		if (size == 0){
			return "[]";
		}
		String s = "[";
		for (int j = 1;j<size;j++){
			s+= array[j]+", ";
		}
		s+= array[size]+"]";
		return s;
	}
}