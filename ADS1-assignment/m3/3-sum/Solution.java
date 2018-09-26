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
		long[] ar = new long[n];
		for (int i = 0; i < n; i++) {
			ar[i] = scan.nextLong();
		}
		long a = 0;
		long b = 0;
		long c = 0;
		int head = 0;
		int tail = 0;
		int cou = 0;
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));
		for (int i = 0; i < n - 2; i++) {
			a = ar[i];
			head = i + 1;
			tail = n - 1;
			while(head < tail) {
				b = ar[head];
				c = ar[tail];
				if (a+b+c == 0){
					cou++;
					head += 1;
					tail -= 1;
				}
				else if (a+b+c < 0){
					head += 1;
				}
				else {
					tail -= 1;
				}
			}
		}
		System.out.println(cou);
	}
}