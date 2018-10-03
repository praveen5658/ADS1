import java.util.Arrays;
/**
 * Class for insertion.
 * Complexity:
	 * Best Case : O(N^2)
	 * Worst Case : O(N^2)
	 * Optimal Case : O(N^2)
 */
class Insertion {
	protected Insertion() {

	}
	/**
	 * { Insertion Sort }.
	 *
	 * @param      array  The array
	 *
	 * @return     { String array }.
	 * 
	 * Complexity:
	 * Best Case : O(N^2)
	 * Worst Case : O(N^2)
	 * Optimal Case : O(N^2)
	 */
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