/**
 * { Importing Scannner }.
 */
import java.util.Scanner;
/**
 * { Importing Arrays }.
 */
import java.util.Arrays;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
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
    }
    /**
     * { Head Node }.
     */
    private Node head = new Node();
    /**
     * { For pushing }.
     *
     * @param      n    { Integer }.
     */
    public void push(final int n) {
        Node node = new Node();
        if (head == null) {
            head.data = n;
            head.next = null;
            return;
        }
        node.data = n;
        node.next = head;
        head = node;
    }
    /**
     * { Pop function }.
     *
     * @return     { Integer }.
     */
    public int pop() {
        // System.out.println(head.data);
        int c = head.data;
        head = head.next;
        return c;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return (head.next == null);
    }
    /**
     * { Main Method }.
     *
     * @param      main  The main
     */
    public static void main(final String[] main) {
        Scanner scan = new Scanner(System.in);
        String[] input;
        int popelement1;
        int popelement2;
        Solution s;
        input = scan.nextLine().split(" ");
        s = new Solution();
        for (int j = 0; j < input.length; j++) {
            if (!(Arrays.asList("+", "-", "*", "/").contains(input[j]))) {
                s.push(Integer.parseInt(input[j]));
            } else {
                popelement1 = s.pop();
                popelement2 = s.pop();
                if (input[j].equals("+")) {
                    s.push(popelement1 + popelement2);
                } else if (input[j].equals("-")) {
                    s.push(popelement1 - popelement2);
                } else if (input[j].equals("*")) {
                    s.push(popelement1 * popelement2);
                } 
                else {
                    s.push(popelement1 / popelement2);
                }
            }
        }
        System.out.println(s.pop());
    }
}
