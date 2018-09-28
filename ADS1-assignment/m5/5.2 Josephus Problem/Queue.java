class Queue {
	private Node head;
	private Node tail;
    public int size;
	
    private class Node {
        private int value;
        private Node next;
    }

    Queue() {
        head = null;
        tail = null;
    }

    public void enqueue (final int value){
    	if (tail == null) {
           //Node oldTail = tail;
           tail = new Node();
           tail.value = value;
           tail.next = null;
           head = tail;
        } else {
           Node oldTail = tail;
    	   tail = new Node();
    	   tail.value = value;
    	   tail.next = null;
           oldTail.next = tail;
        }
        //size++;
    }
    
    public int dequeue(){
        if (head != null) {
            int value = head.value;
            head = head.next;
            //size--;
            return value;
        }
        return tail.value;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return size;
    }
}
