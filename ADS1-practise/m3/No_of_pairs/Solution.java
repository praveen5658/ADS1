/**
 * @author Praveen
 */
/**
 * { Value }.
 */
import java.util.*;
/**
 * Class for solution.
 */
class Solution {
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = scan.nextInt();
		}
		Arrays.sort(ar);
		int co = 0;
		int sum = 0;
		System.out.println(Arrays.toString(ar));
		for (int i = 0; i < n - 1; i++) {
			if (ar[i] == ar[i + 1]) {
				co++;
			} else {
				if (co >= 1) {
					sum += ((co + 1) * co) / 2;
					co = 0;
				} else {
					co = 0;
				}
			}
		}
		if (co >= 1) {
			sum += ((co + 1) * co) / 2;
			co = 0;
		}
		System.out.println(sum);
	}
}