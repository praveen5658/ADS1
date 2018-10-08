/**
 * { Importing Arrays class }.
 */
import java.util.Arrays;
/**
 * Class for minimum heap.
 *
 * @param      <E>   { Generic type }.
 */
class MinHeap<E extends Comparable<E>> {
	/**
	 * { Private value }.
	 */
	private E[] array;
	/**
	 * { Private value }.
	 */
	private int size;
	/**
	 * Constructs the object.
	 *
	 * @param      len   The length
	 */
	protected MinHeap(final int len) {
		array = (E[])new Comparable[len + 1];
		size = 0;
	}
	/**
	 * { Insert method }.
	 *
	 * @param      value  The value
	 *
	 * @return     { Generic type }.
	 */
	public boolean insert(final E value) {
		array[++size] = value;
		// System.out.println(size);
		return (swim(size));
	}
	/**
	 * { For checking minheap }.
	 *
	 * @param      k     { Integer }.
	 *
	 * @return     { Boolean }.
	 */
	public boolean swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			// swap(k, k/2);
			k = k / 2;
		}
		if (k > 1) {
			return false;
		}
		return true;
	}
	/**
	 * { For compareTo }.
	 *
	 * @param      one   One
	 * @param      two   Two
	 *
	 * @return     { boolean }.
	 */
	public boolean less(final int one, final int two) {
		return ((array[one].compareTo(array[two])) <= 0);
	}
}