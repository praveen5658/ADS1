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
class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Class for node.
     */
    class Node {
        char data;
        Node next;
    }
    /**
     * { Head Node }.
     */
    private Node head = new Node();
    /**
     * { For pushing }.
     *
     * @param      ch    { character }.
     */
    public void push(final char ch) {
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
    /**
     * { Pop function }.
     *
     * @return     { Character }.
     */
    public char pop() {
        // System.out.println(head.data);
        char c = head.data;
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
        String input1;
        char popelement;
        boolean flag = true;
        int num = Integer.parseInt(scan.nextLine());
        Solution s;
        char[] input;
        for (int i = 0; i < num ; i++) {
            input1 = scan.nextLine();
            input = input1.toCharArray();
            s = new Solution();
            flag = true;
            for (int j = 0; j < input.length; j++) {
                if (Arrays.asList('(', '{', '[').contains(input[j])) {
                    s.push(input[j]);
                } else {
                    popelement = s.pop();
                    if (input[j] == ')') {
                        if (!(popelement == '(')) {
                            System.out.println("NO");
                            flag = false;
                            break;
                        }
                    } else if (input[j] == '}') {
                        if (!(popelement == '{')) {
                            System.out.println("NO");
                            flag = false;
                            break;
                        }
                    } else {
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
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}