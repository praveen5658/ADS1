import java.util.Arrays;
class MergeSort {
	private String[] array;
	private String[] aux;
	Insertion insertion;
	private String[] sample;
	protected MergeSort(String[] arr) {
		array = arr;
		aux = new String[array.length];
	}
	public String[] mergesort() {
		int low = 0;
		int high = array.length - 1;
		if(high<8){
			insertion = new Insertion();
			array = insertion.insertionsort(array);
		}else {
			sort(aux, array, low, high);
		}
		return array;
	}
	public void sort(String[] array, String[] aux, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = low + ((high - low) / 2);
		if((mid - low + 1)<=8){
			insertion = new Insertion();
			sample = new String[mid - low + 1];
			for(int h = 0,l = low; h< sample.length;h++,l++){
				sample[h] = array[l];
			}
			sample = insertion.insertionsort(sample);
			for(int h = 0,l = low; h< sample.length;h++,l++){
				array[l] = sample[h];
			}
		} else {
			sort(aux, array, low, mid);
		}
		if((high - (mid+1) + 1)<=8){
			insertion = new Insertion();
			sample = new String[high - (mid+1) + 1];
			for(int h = 0,l = mid+1; h< sample.length;h++,l++){
				sample[h] = array[l];
			}
			sample = insertion.insertionsort(sample);
			for(int h = 0,l = mid+1; h< sample.length;h++,l++){
				array[l] = sample[h];
			}
		} else {
			sort(aux, array, mid + 1, high);
		}
		if (less(aux[mid], aux[mid + 1])) {
			System.out.println("Array is already sorted. So, skipped the call to merge...");
			return;
		}
		merge(aux, array, low, mid, high);
	}
	public void merge(String[] array, String[] aux, int low, int mid, int high) {
		// for (int k = 0; k <= high; k++) {
		// 	aux[k] = array[k];
		// }
		int i = low, j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				aux[k] = array[j++];
			} else if (j > high) {
				aux[k] = array[i++];
			} else if (less(array[j], array[i])) {
				aux[k] = array[j++];
			} else {
				aux[k] = array[i++];
			}
		}
	}
	public boolean less(String a, String b) {
		return ((a.compareTo(b))<0);
	}
}