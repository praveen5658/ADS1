class LinkedList {
	class Node {
		int data;
		Node next;
	}
	private Node head, tail;
	private int size = 0;
	public void push(final int number) {
		Node node = new Node();
		node.data = number;
		node.next = null;
		if (head == null){
			head = node;
			tail = node;
			size++;
			return;
		}
		node.next = head;
		head = node;
		size++;
	}
	public void enqueue(final int number) {
		Node node = new Node();
		node.data = number;
		node.next = null;
		if (head == null) {
			tail = node;
			head = tail;
			size++;
			return;
		}
		tail.next = node;
		tail = node;
		size++;
	}
	public void pop() {
		head = head.next;
		size--;
	}
	public boolean isEmpty() {
		return (size == 0);
	}
	public String print() {
		if (size == 0){
			return "Steque is empty.";
		}
		Node printhead = head;
		int printsize = size;
		String str = "";
		while(printsize > 0){
			str += Integer.toString(printhead.data) + ", ";
			printhead = printhead.next;
			printsize--;
		}
		return str.substring(0, str.length()-2);
	}
}