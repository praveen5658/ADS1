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
        String[] input;
        LinkedList l = new LinkedList();
        while (scan.hasNext()) {
            input = scan.nextLine().split(" ");
            switch (input[0]) {
            case "insertAt":
                try {
                    l.insertAt(
                        Integer.parseInt(input[1]), Integer.parseInt(input[2]));
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
            default:
                break;
            }
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
    protected LinkedList() {

    }
    /**
     * { Private Value }.
     */
    private Node start = null;
    /**
     * { Private Value }.
     */
    private Node test;
    /**
     * { Private Value }.
     */
    private Node prev;
    /**
     * { Private Value }.
     */
    private Node temp;
    /**
     * { Private Value }.
     */
    private int size = 0;
    /**
     * Class for node.
     */
    class Node {
        /**
        * { Private Value }.
        */
        private int data;
        /**
        * { Private Value }.
        */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      data1  The data
         */
        Node(final int data1) {
            this.data = data1;
        }
    }
    /**
     * { Private Value }.
     */
    private int index = 0;
    /**
     * { Insert function }.
     *
     * @param      index1      The index
     * @param      inputdata  The inputdata
     *
     * @throws     Exception  { Can't Insert at Position }.
     */
    void insertAt(final int index1, int inputdata) throws Exception {
        index = index1;
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
    /**
     * { Reverse of List }.
     *
     * @throws     Exception  { Empty List }.
     */
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
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
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