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
		String input = scan.nextLine();
		Star star = new Star();
		System.out.println(star.pairStar(input));
	}
}
/**
 * Class for star.
 */
class Star{
	/**
	 * Constructs the object.
	 */
	protected Star(){

	}
	/**
	 * { Prints Star if encounters with equal characters }.
	 *
	 * @param      s     { String }.
	 *
	 * @return     { String }
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
	public String pairStar(String s){
		String result = "";
		if (s == null){
			return result;
		}
		if(s.length() == 1){
			return s;
		}
		result = s.substring(0,1);
		if(result.equals(s.substring(1,2))){
			result += "*";
		}
		s = s.substring(1);
		return result + pairStar(s);
	}
}