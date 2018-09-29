class LinkedList {
	protected LinkedList() {

	}
	class Node {
		public int data;
		private Node next;
	}
	public Node head;
	private int size = 0;
	public void addNumber(final int n) {
		Node node = new Node();
		node.data = n;
		node.next = null;
		if (head == null) {
			head = node;
			size++;
			return;
		}
		node.next = head;
		head = node;
		size++;
	}
	public int popNumber() {
		int k = head.data;
		head = head.next;
		size--;
		return k;
	}
	public boolean isEmpty() {
		return (size == 0);
	}
	public int size() {
		return size;
	}
}