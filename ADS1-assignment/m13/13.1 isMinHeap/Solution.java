import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// String[] input = scan.nextLine().split(" ");
		String type = scan.nextLine();
		String[] input;
		int testcases = Integer.parseInt(scan.nextLine());
		int k = 0;
		switch (type) {
		case "String":
			while (testcases > 0) {
				k = 0;
				input = scan.nextLine().split(",");
				MinHeap<String> mh = new MinHeap<>(input.length);
				for (int i = 0; i < input.length; i++) {
					if (!(mh.insert(input[i]))) {
						System.out.println("false");
						k++;
						break;
					}
				}
				if (k == 0) {
					System.out.println("true");
				}
				testcases--;
			}
			break;
			// case "delete":
			// 	System.out.println("deleted element " + mh.delmax());
			// 	System.out.println(mh);
			// 	break;
		case "Integer":
			while (testcases > 0) {
				k = 0;
				input = scan.nextLine().split(",");
				MinHeap<Integer> mh = new MinHeap<>(input.length);
				for (int i = 0; i < input.length; i++) {
					if (!(mh.insert(Integer.parseInt(input[i])))) {
						System.out.println("false");
						k++;
						break;
					}
				}
				if (k == 0) {
					System.out.println("true");
				}
				testcases--;
			}
			break;
		case "Double":
			while (testcases > 0) {
				k = 0;
				input = scan.nextLine().split(",");
				MinHeap<Double> mh = new MinHeap<>(input.length);
				for (int i = 0; i < input.length; i++) {
					if (!(mh.insert(Double.parseDouble(input[i])))) {
						System.out.println("false");
						k++;
						break;
					}
				}
				if (k == 0) {
					System.out.println("true");
				}
				testcases--;
			}
			break;
		case "Float":
			while (testcases > 0) {
				k = 0;
				input = scan.nextLine().split(",");
				MinHeap<Float> mh = new MinHeap<>(input.length);
				for (int i = 0; i < input.length; i++) {
					if (!(mh.insert(Float.parseFloat(input[i])))) {
						System.out.println("false");
						k++;
						break;
					}
				}
				if (k == 0) {
					System.out.println("true");
				}
				testcases--;
			}
			break;
		}
		// System.out.println(mh);
	}
}