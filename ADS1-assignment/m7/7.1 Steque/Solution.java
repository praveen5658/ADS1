/**
 * { Importing Scanner Class }.
 */
import java.util.Scanner;
/**
 * { Solution class }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { Main Method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        String[] input;
        String line = "";
        LinkedList l;
        while (testcases > 0) {
            l = new LinkedList();
            while (scan.hasNext()) {
                line = scan.nextLine();
                if(line.isEmpty()) {
                    break;
                }
                input = line.split(" ");
                switch (input[0]) {
                case "push":
                    l.push(Integer.parseInt(input[1]));
                    System.out.println(l.print());
                    break;
                case "enqueue":
                    l.enqueue(Integer.parseInt(input[1]));
                    System.out.println(l.print());
                    break;
                case "pop":
                    if (!(l.isEmpty())) {
                        l.pop();
                    }
                    System.out.println(l.print());
                    break;
                default :
                    break;
                }
            }
            testcases--;
            System.out.println();
        }
    }
}
/**
 * List of linkeds.
 */
class LinkedList {
    /**
     * Constructs the object.
     */
    protected LinkedList(){

    }
    /**
     * Class for node.
     */
    class Node {
        int data;
        Node next;
    }
    /**
     * { Tail and Head are Node references }.
     */
    private Node head, tail;
    /**
     * { size of the list }.
     */
    private int size = 0;
    /**
     * { For pushing element to Steque }.
     *
     * @param      number  The number
     */
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
    /**
     * { For Enqueue operation in Steque }.
     *
     * @param      number  The number
     */
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
    /**
     * { For popping an element from Steque }.
     */
    public void pop() {
        head = head.next;
        size--;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
     * { For Printing Steque in required format }.
     *
     * @return     { String contains values in required format }.
     */
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