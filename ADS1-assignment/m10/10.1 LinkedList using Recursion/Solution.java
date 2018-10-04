import java.util.Scanner;
class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input;
		LinkedList l = new LinkedList();
		while (scan.hasNext()) {
			input = scan.nextLine().split(" ");
			switch (input[0]) {
			case "insertAt":
				try {
					l.insert(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
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
	protected LinkedList() {

	}
	class Node {
		int data;
		Node next;
	}
	private Node start;
	private int size = 0;
	public void insert (int index, int data) throws Exception {
		if (index < 0 || index > size) {
			throw new Exception("Can't insert at this position.");
		}
		Node node = new Node();
		int sampleindex = 0;
		node.data = data;
		node.next = null;
		if (start == null) {
			start = node;
			current = start;
			size++;
			return;
		}
		if (index == 0) {
			node.next = start;
			start = node;
			current = start;
			size++;
			return;
		}
		Node samplestart = start;
		while (sampleindex < index - 1) {
			samplestart = samplestart.next;
			sampleindex++;
		}
		node.next = samplestart.next;
		samplestart.next = node;
		size++;
	}
	private Node prev = null;
	private Node current;
	private Node next = null;
	public void reverse() throws Exception {
		if (size == 0) {
			throw new Exception("No elements to reverse.");
		}
		if (current == null) {
			start = prev;
		}else {
			System.out.println(current.data);
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			System.out.println("reverse1");
			System.out.println(current.data);
			System.out.print(current+"reverse\n");
			reverse();
		}
		return;
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