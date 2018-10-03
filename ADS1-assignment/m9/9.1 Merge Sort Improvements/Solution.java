import java.util.Scanner;
import java.util.Arrays;
final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input;
		final int fifty = 50;
		String[] array;
		int i = 0;
		Insertion insertion;
		MergeSort m;
		while (scan.hasNext()) {
			array = new String[fifty];
			input = scan.nextLine().split(",");
			for (i = 0; i < input.length; i++) {
				array[i] = input[i];
			}
			array = Arrays.copyOf(array, i);
			// System.out.println(Arrays.toString(array));
			// insertion = new Insertion();
			// array = insertion.insertionsort(array);
			// System.out.println(Arrays.toString(array));
			m = new MergeSort(array);
			array = m.mergesort();
			System.out.println(Arrays.toString(array));
			System.out.println();
		}
	}
}
class Insertion {
	protected Insertion() {

	}
	public String[] insertionsort(String[] array) {
		System.out.println("Insertion sort method invoked...");
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (less(array[j], array[j - 1])) {
					array = swap(array, j, j - 1);
				} else {
					break;
				}
			}
		}
		return array;
	}
	public boolean less(String a, String b) {
		return ((a.compareTo(b))<0);
	}
	public String[] swap(String[] array, int j, int k) {
		String temp = array[k];
		array[k] = array[j];
		array[j] = temp;
		return array;
	}
}
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
			sort(array, aux, low, high);
		}
		return array;
	}
	public void sort(String[] array, String[] aux, int low, int high) {
		if (low >= high) {
			return;
		}
		// System.out.println(Arrays.toString(array));
		// System.out.println(low);
		// System.out.println(high);
		// System.out.println(mid);
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
			sort(array, aux, low, mid);
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
			sort(array, aux, mid + 1, high);
		}
		if (less(array[mid], array[mid + 1])) {
			System.out.println("Array is already sorted. So, skipped the call to merge...");
			return;
		}
		// System.out.println(Arrays.toString(array));
		// System.out.println(low);
		// System.out.println(high);
		// System.out.println(mid);
		merge(array, aux, low, mid, high);
	}
	public void merge(String[] array, String[] aux, int low, int mid, int high) {
		// System.out.println(Arrays.toString(array));
		for (int k = 0; k <= high; k++) {
			aux[k] = array[k];
		}
		// System.out.println(Arrays.toString(aux));
		// System.out.println(low);
		// System.out.println(high);
		// System.out.println(mid);
		int i = low, j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				array[k] = aux[j++];
			} else if (j > high) {
				array[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				array[k] = aux[j++];
			} else {
				array[k] = aux[i++];
			}
			// System.out.println(Arrays.toString(array));
		}
	}
	public boolean less(String a, String b) {
		return ((a.compareTo(b))<0);
	}
}