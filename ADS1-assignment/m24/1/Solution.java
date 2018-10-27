/**
 * imports Scanner class.
 */
import java.util.Scanner;
/**
 * Class for book.
 */
class Student implements Comparable<Student>{
    private String name;
    private int rollno;
    private double marks;
    protected Student(final int r, final String na, final double m) {
        name = na;
        rollno = r;
        marks = m;
    }
    public String getname() {
        return name;
    }
    public int getrollno() {
        return rollno;
    }
    public double getmarks() {
        return marks;
    }
    public int compareTo(final Student other) {
        return this.rollno - other.rollno;
    }
    public int com(final int ro) {
        return ro - this.rollno;
    }
    public String toString() {
        return Integer.toString(rollno) + "," + name + "," + Double.toString(marks);
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
     * varible for value.
     */
    // private String value;
    /**
     * varible for left node.
     */
    private Node left;
    /**
     * varible for right node.
     */
    private Node right;
    /**
     * varible for count.
     */
    // private int count;
    /**
     * Constructs the object.
     *
     * @param      key1    The key 1
     * @param      value1  The value 1
     * @param      count1  The count 1
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
     * Gets the value.
     *
     * @return     The value.
     */
    // public String getValue() {
    //     return value;
    // }
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
     * Gets the count.
     *
     * @return     The count.
     */
    // public int getCount() {
    //     return count;
    // }
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
    /**
     * Sets the value.
     *
     * @param      val   The value
     */
    // public void setValue(final String val) {
    //     this.value = val;
    // }
    /**
     * Sets the count.
     *
     * @param      cnt   The count
     */
    // public void setCount(final int cnt) {
    //     this.count = cnt;
    // }
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
    Bst() {

    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    // public boolean isEmpty() {
    //     return count() == 0;
    // }
    /**
     * keeps track of count.
     *
     * @return     { integer }
     */
    // public int count() {
    //     return count(root);
    // }
    /**
     * keeps track of count.
     *
     * @param      x     { Node }
     *
     * @return     { Node type }
     */
    // private int count(final Node x) {
    //     if (x == null) {
    //         return 0;
    //     } else {
    //         return x.getCount();
    //     }
    // }
    /**
     * Determines whether key is present.
     *
     * @param      key   The key
     *
     * @return     { boolean }
     */
    // public boolean contains(final Student key) {
    //     return get(key) != null;
    // }
    /**
     * Method to insert the key.
     *
     * Time complexity is O(N).
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Student key) {
        root = put(root, key);
    }
    /**
     * Method to insert the keys.
     * Time complexity is O(N) in worst case.
     * @param      x      The node.
     * @param      key    The key
     * @param      value  The value
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
        // if (cmp == 0) {
        //     x.setValue(value);
        // }
        // x.setCount(1 + count(x.getLeft()) + count(x.getRight()));
        return x;
    }
    /**
     * Method to get value of the key.
     * Time complexity of this method is O(N).
     * @param      key   The key
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
public class Solution {
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int insertoperations = Integer.parseInt(scan.nextLine());
        Bst bst = new Bst();
        String[] input;
        for (int i = 0; i < insertoperations; i++) {
            input = scan.nextLine().split(",");
            bst.put(new Student(Integer.parseInt(input[0]), input[1], Double.parseDouble(input[2])));
        }
        int queries = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < queries; i++) {
            input = scan.nextLine().split(" ");
            Student s = bst.get(Integer.parseInt(input[1]));
            if (Integer.parseInt(input[2]) == 1) {
                System.out.println(s.getname());
            } else if (Integer.parseInt(input[2]) == 2){
                System.out.println(s.getmarks());
            }
        }
    }
}
