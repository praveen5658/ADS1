import java.util.Scanner;
class Solution{
	private Solution(){

	}
	public static void main(final String[] args){
		Scanner scan = new Scanner(System.in);
		String[] input;
		LinkedList l = new LinkedList();
		while(scan.hasNext()){
			input = scan.nextLine().split(" ");
			switch(input[0]){
				case "insertAt":
					l.insert(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
					System.out.println(l);
					break;
				case "reverse":
					l.reverse();
					System.out.println(l);
					break;
			}
		}
	}
}
class LinkedList{
	protected LinkedList(){

	}
	class Node{
		int data;
		Node next;
	}
	private Node start;
	public void insert(int index, int data){
		Node node = new Node();
		int sampleindex = 0;
		node.data = data;
		node.next = null;
		if(start == null){
			start = node;
			return;
		}
		if(index == 0){
			node.next = start;
			start = node;
			return;
		}
		Node samplestart = start;
		while(sampleindex < index - 1){
			samplestart = samplestart.next;
			sampleindex++;
		}
		node.next = samplestart.next;
		samplestart.next = node;
	}
	public void reverse(){
		Node prev = null;
		Node current = start;
		Node next = null;
		while(current != null){
			next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next;
		}
		start = prev;
	}
	public String toString(){
		String s = "";
		Node sample = start;
		while(sample != null){
			s+= Integer.toString(sample.data)+", ";
			sample = sample.next;
		}
		return s.substring(0, s.length() - 2);
	}
}