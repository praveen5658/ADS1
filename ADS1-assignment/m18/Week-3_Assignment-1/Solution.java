import java.util.Scanner;
final class Solution{
	private Solution(){

	}
	public static void main(final String[] args){
		Scanner scan = new Scanner(System.in);
		int noofstocksperhour = Integer.parseInt(scan.nextLine());
		int n = 6;
		String[] input;
		String[] keys;
		float[] values;
		String key;
		float value;
		MinPQ minpq;
		MaxPQ maxpq;
		float f;
		int s = 0;
		BinarySearchST bstmin = new BinarySearchST();
		BinarySearchST bstmax = new BinarySearchST();
		while(n>0){
			minpq = new MinPQ(5);
			maxpq = new MaxPQ(5);
			keys = new String[noofstocksperhour];
			values = new float[noofstocksperhour];
			for(int i = 0; i< noofstocksperhour;i++){
				input = scan.nextLine().split(",");
				key = input[0];
				keys[i] = input[0];
				value = Float.parseFloat(input[1]);
				values[i] = value;
				minpq.insert(value);
				maxpq.insert(value);
			}
			for(int m = 0; m<5;m++){
				f = (float)minpq.delMin();
				for(s = 0; s < noofstocksperhour;s++){
					if(values[s]==f){
						break;
					}
				}
				key = keys[s];
				value = f;
				if (bstmin.contains(key)){
					// bstmin.put(key, bstmin.get(key)+(float)1);
				}else {
					bstmin.put(key, 1);
				}
				System.out.print(key + " "+ Float.toString(value) + "\n");
			}
			System.out.println();
			for(int m = 0; m<5;m++){
				f = (float)maxpq.delMax();
				for(s = 0; s < noofstocksperhour;s++){
					if(values[s]==f){
						break;
					}
				}
				key = keys[s];
				value = f;
				if (bstmax.contains(key)){
					// bstmax.put(key, bstmax.get(key)+1);
				}else {
					bstmax.put(key, 1);
				}
				System.out.print(key + " "+ Float.toString(value) + "\n");
			}
			System.out.println();
			n--;
		}
	}
}