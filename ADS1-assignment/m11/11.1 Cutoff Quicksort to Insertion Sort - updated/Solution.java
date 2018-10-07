/**
 * { item_description }
 */
import java.util.Scanner;
/**
 * { item_description }
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		/**
		 * { item_description }
		 */
	}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Sorting sort = new Sorting();
		Scanner sc = new Scanner(System.in);
		int testcases = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testcases; i++) {
			int cutoff = Integer.parseInt(sc.nextLine());
			String line = sc.nextLine();
			String[] tokens = line.split(" ");
			if (tokens[0].equals("")) {
				System.out.println("[]");
			} else {
				sort.sort(tokens, cutoff);
				System.out.println(sort.toString(tokens));
			}
		}
	}
}
