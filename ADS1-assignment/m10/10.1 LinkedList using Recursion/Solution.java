import java.util.Scanner;
class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input;
		LinkedList l = new LinkedList();;
		while (scan.hasNext()) {
			input = scan.nextLine().split(" ");
			switch (input[0]) {
			case "insertAt":
				try {
					l.insertAt(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
					System.out.println(l);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "reverse":
				try {
					l.reverse();
					System.out.println(l);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}
	}
}
class LinkedList {
	Node start = null;
	Node test;
	Node prev;
	Node temp;
	int size = 0;
	class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}
	void insertAt(int index, int inputdata) throws Exception {
		if (index > size || index < 0) {
			throw new Exception("Can't insert at this position.");
			// return;
		}
		if (index == 1) {
			Node node = new Node(inputdata);
			node.next = test.next;
			test.next = node;
			test = start;
			size++;
			return;
		}
		if (index == 0) {
			Node node = new Node(inputdata);
			node.next = test;
			start = node;
			test =  start;
			size++;
			return;
		}
		test = test.next;
		index--;
		insertAt(index, inputdata);
	}
	void reverse() throws Exception {
		if (size == 0) {
			throw new Exception("No elements to reverse.");
		}
		if (test.next == null) {
			start = test;
			start.next = prev;
			test = start;
			prev = null;
			return;
		}
		temp = test;
		test = test.next;
		temp.next = prev;
		prev = temp;
		reverse();
	}
	public String toString() {
		String s = "";
		Node sample = start;
		while (sample != null) {
			s += Integer.toString(sample.data) + ", ";
			sample = sample.next;
		}
		return s.substring(0, s.length() - 2);
	}
}