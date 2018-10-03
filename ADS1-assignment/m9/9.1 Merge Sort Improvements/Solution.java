import java.util.Scanner;
import java.util.Arrays;
final class Solution{
	private Solution(){

	}
	public static void main(final String[] args){
		Scanner scan = new Scanner(System.in);
		String[] input;
		final int fifty = 50;
		int[] array = new int[fifty];
		int i = 0;
		while(scan.hasNext()){
			i = 0;
			input = scan.nextLine().split(",");
			for(i = 0; i< input.length;i++){
				array[i] = Integer.parseInt(input[i]);
			}
			array = Arrays.copyOf(array, i);
			System.out.println(Arrays.toString(array));
		}
	}
}