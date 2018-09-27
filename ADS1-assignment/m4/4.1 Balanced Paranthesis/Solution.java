import java.util.Scanner;
import java.util.Arrays;
class Solution {
	private Solution() {

	}
	class Node {
		char data;
		Node next = null;
	}
	private Node head = new Node();
	public void push(char ch) {
		Node node = new Node();
		if (head == null) {
			head.data = ch;
			head.next = null;
			return;
		}
		node.data = ch;
		node.next = head;
		head = node;
	}
	public char pop() {
		// System.out.println(head.data);
		char c = head.data;
		head = head.next;
		return c;
	}
	public boolean isEmpty() {
		return (head.next == null);
	}
	public static void main(final String[] main) {
		Scanner scan = new Scanner(System.in);
		String input1;
		char popelement;
		boolean flag = true;
		int num = Integer.parseInt(scan.nextLine());
		Solution s;
		char[] input;
		for (int i = 0;i< num ; i++) {
			input1 = scan.nextLine();
			input = input1.toCharArray();
			s = new Solution();
			flag = true;
			for (int j = 0;j< input.length;j++) {
				if (Arrays.asList('(', '{', '[').contains(input[j])) {
					s.push(input[j]);
				}
				else {
					popelement = s.pop();
					if (input[j] == ')') {
						if (!(popelement == '(')) {
							System.out.println("NO");
							flag = false;
							break;
						}
					}
					else if (input[j] == '}') {
						if (!(popelement == '{')) {
							System.out.println("NO");
							flag = false;
							break;
						}
					}
					else {
						if (!(popelement == '[')) {
							System.out.println("NO");
							flag = false;
							break;
						}
					}
				}
			}
			if (flag) {
				if (s.isEmpty()) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
	}
}