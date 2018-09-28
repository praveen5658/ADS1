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
class Deque {
    /**
     * { Private Value }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    protected Deque() {
        size = 0;
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
        private Node right;
        /**
         * { Private Value }.
         */
        private Node left;
    }
    /**
     * { Head Node, Tail Node }.
     */
    private Node head;
    private Node tail;
    /**
     * { For pushing }.
     *
     * @param      n    { Integer }.
     */
    public void pushLeft(final int n) {
        Node node = new Node();
        if (head == null) {
            node.data = n;
            node.right = null;
            node.left = null;
            head = node;
            tail = head;
            size = 1;
            return;
        }
        node.data = n;
        node.left = null;
        node.right = head;
        head.left = node;
        head = node;
        size++;
    }
    /**
     * { Pop function }.
     *
     * @return     { Character }.
     */
    public void popLeft() {
        // System.out.println(head.data);
        if (size > 0) {
            int k = head.data;
            head = head.right;
            if (head != null) {
                head.left = null;
            }
            size--;
        } else {
            System.out.println("Deck is empty");
        }
    }
    /**
     * { For pushing }.
     *
     * @param      n    { Integer }.
     */
    public void pushRight(final int n) {
        Node node = new Node();
        if (tail == null) {
            node.data = n;
            node.right = null;
            node.left = null;
            tail = node;
            head = tail;
            size = 1;
            return;
        }
        // System.out.println("Entered");
        node.data = n;
        node.right = null;
        node.left = tail;
        tail.right = node;
        tail = node;
        // System.out.println(tail.data);
        size ++;
    }
    /**
     * { Pop  function }.
     *
     * @return     { Character }.
     */
    public void popRight() {
        // System.out.println(head.data);
        if (size > 0) {
            int k = tail.data;
            tail = tail.left;
            if (tail != null) {
                tail.right = null;
            }
            size--;
        } else {
            System.out.println("Deck is empty");
        }
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
     * { Size }.
     *
     * @return     { Integer }.
     */
    public int size() {
        return size;
    }
    public String print() {
        if (size == 0) {
            return "[]";
        }
        String s = "[";
        Node head1 = head;
        Node tail1 = tail;
        while (head1 != null) {
            s += Integer.toString(head1.data) + ", ";
            head1 = head1.right;
        }
        s = s.substring(0, s.length() - 2);
        s += "]";
        return s;
    }
}
final class Solution {
    private Solution() {

    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Deque d = new Deque();
        String[] input;
        while (num > 0) {
            input = scan.nextLine().split(" ");
            switch (input[0]) {
            case "pushLeft" :
                d.pushLeft(Integer.parseInt(input[1]));
                System.out.println(d.print());
                break;
            case "pushRight" :
                d.pushRight(Integer.parseInt(input[1]));
                System.out.println(d.print());
                break;
            case "size" :
                System.out.println(d.size());
                break;
            case "popLeft" :
                d.popLeft();
                if (d.size() > 0){
                    System.out.println(d.print());
                }
                break;
            case "popRight" :
                d.popRight();
                if (d.size() > 0){
                    System.out.println(d.print());
                }
                break;
            case "isEmpty" :
                System.out.println(d.isEmpty());
                break;
            }
            num--;
        }
    }
}