import java.util.Scanner;
import java.util.Arrays;
final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input;
		final int thousand = 1000;
		String[] array;
		int i = 0;
		Insertion insertion;
		MergeSort m;
		while (scan.hasNext()) {
			array = new String[thousand];
			input = scan.nextLine().split(",");
			for (i = 0; i < input.length; i++) {
				array[i] = input[i];
			}
			array = Arrays.copyOf(array, i);
			m = new MergeSort(array);
			array = m.mergesort();
			System.out.println(Arrays.toString(array));
			System.out.println();
		}
	}
}
