/**
 * { Scanner Class }.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution{
	/**
	 * Constructs the object.
	 */
	private Solution(){

	}
	/**
	 * { Main method }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args){
		Scanner scan = new Scanner(System.in);
		long number = Long.parseLong(scan.nextLine());
		Factorial factorial = new Factorial();
		System.out.println(factorial.fact(number));
	}
}
/**
 * Class for factorial.
 */
class Factorial{
	/**
	 * Constructs the object.
	 */
	protected Factorial(){

	}
	/**
	 * { fact method }.
	 *
	 * @param      n     { number }.
	 *
	 * @return     { Long value }.
	 * 
	 * If we trace the following function:
	 * T(1) = 1
       T(2) = T(1) + 1 = 2
       T(3) = T(2) + 1 = 3
       T(4) = T(3) + 1 = 4
       ...
       T(n) = n

       Complexity : O(N)
	 */
	public long fact(final long n){
		if(n == 0 || n == 1){
			return 1;
		}else {
			return n * fact(n - 1);
		}
	}
}