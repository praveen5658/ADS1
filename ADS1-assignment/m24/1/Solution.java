/**
 * @author Praveen N
 * Date : 27-10-2018
 */
/**
 * imports Scanner class.
 */
import java.util.Scanner;
/**
 * Class for book.
 */
class Student implements Comparable<Student> {
    /**
     * { Private Value }.
     */
    private String name;
    /**
     * { Private Value }.
     */
    private int rollno;
    /**
     * { Private Value }.
     */
    private double marks;
    /**
     * { Private Value }.
     */
    /**
     * Constructs the object.
     *
     * @param      r     { parameter_description }
     * @param      na    { parameter_description }
     * @param      m     { parameter_description }
     */
    protected Student(final int r, final String na, final double m) {
        name = na;
        rollno = r;
        marks = m;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String getname() {
        return name;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int getrollno() {
        return rollno;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public double getmarks() {
        return marks;
    }
    /**
     * { function_description }.
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Student other) {
        return this.rollno - other.rollno;
    }
    /**
     * { function_description }.
     *
     * @param      ma    { parameter_description }
     */
    public void setmarks(final double ma) {
        this.marks = ma;
    }
}
/**
 * Class for node.
 */
class Node {
    /**
     * varible for key.
     */
    private Student key;
    /**
     * varible for left node.
     */
    private Node left;
    /**
     * varible for right node.
     */
    private Node right;
    /**
     * Constructs the object.
     *
     * @param      key1    The key 1
     */
    Node(final Student key1) {
        this.key = key1;
    }
    /**
     * Gets the key.
     *
     * @return     The key.
     */
    public Student getKey() {
        return key;
    }
    /**
     * Gets the left.
     *
     * @return     The left.
     */
    public Node getLeft() {
        return left;
    }
    /**
     * Gets the right.
     *
     * @return     The right.
     */
    public Node getRight() {
        return right;
    }
    /**
     * Sets the left.
     *
     * @param      left1  The left 1
     */
    public void setLeft(final Node left1) {
        this.left = left1;
    }
    /**
     * Sets the right.
     *
     * @param      right1  The right 1
     */
    public void setRight(final Node right1) {
        this.right = right1;
    }
}
/**
 * Class for bst.
 */
class Bst {
    /**
     * varible for root.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    protected Bst() {

    }
    /**
     * Method to insert the key.
     *
     * Average Time Complexity : O(logN)
     *
     * @param      key    The key
     */
    public void put(final Student key) {
        root = put(root, key);
    }
    /**
     * Method to insert the keys.
     * Average Time Complexity : O(logN)
     * @param      x      The node.
     * @param      key    The key
     *
     * @return     The node.
     */
    public Node put(final Node x, final Student key) {
        if (x == null) {
            return new Node(key);
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp < 0) {
            x.setLeft(put(x.getLeft(), key));
        }
        if (cmp > 0) {
            x.setRight(put(x.getRight(), key));
        }
        if (cmp == 0) {
            x.getKey().setmarks(key.getmarks());
        }
        return x;
    }
    /**
     * Method to get value of the key.
     * Average Time Complexity : O(logN)
     * @param      roll   The key
     *
     * @return     The value of the key
     */
    public Student get(final Integer roll) {
        Node x = root;
        while (x != null) {
            int cmp = roll - x.getKey().getrollno();
            if (cmp < 0) {
                x = x.getLeft();
            }
            if (cmp > 0) {
                x = x.getRight();
            }
            if (cmp == 0) {
                return x.getKey();
            }
        }
        return null;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution(){

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int insertoperations = Integer.parseInt(scan.nextLine());
        Bst bst = new Bst();
        String[] input;
        for (int i = 0; i < insertoperations; i++) {
            input = scan.nextLine().split(",");
            bst.put(new Student(Integer.parseInt(input[0]),
                                input[1], Double.parseDouble(input[2])));
        }
        int queries = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < queries; i++) {
            input = scan.nextLine().split(" ");
            Student s = bst.get(Integer.parseInt(input[1]));
            if (s == null) {
                System.out.println("Student doesn't exists...");
            } else {
                if (Integer.parseInt(input[2]) == 1) {
                    System.out.println(s.getname());
                } else if (Integer.parseInt(input[2]) == 2) {
                    System.out.println(s.getmarks());
                }
            }
        }
    }
}
