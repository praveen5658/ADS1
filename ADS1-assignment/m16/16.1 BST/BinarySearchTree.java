/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
    /**
     * { Value }.
     */
    private Node root;
    /**
     * { Value }.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
        * { Value }.
        */
        private BookList key;
        /**
        * { Value }.
        */
        private Value val;
        /**
        * { Value }.
        */
        private Node left, right;
        /**
         * Constructs the object.
         */
        public Node () {
        }
    }
    /**
     * { For inserting into BST }.
     *
     * @param      key   The key
     * @param      val   The value
     * Time complexity :
     * Best Case : O(logN)
     * Average Case : O(logN)
     * Worst Case : O(logN)
     */
    public void put(BookList key, Value val) {
        if (key == null) {
            System.out.println("key is null");
        }
        root = put(root, key, val);
    }
    /**
     * { Put method }.
     *
     * @param      head  The head
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { Value }.
     * Time complexity :
     * Best Case : O(logN)
     * Average Case : O(logN)
     * Worst Case : O(logN)
     */
    public Node put(Node head, BookList key, Value val) {
        if (head == null) {
            Node node = new Node();
            node.key = key;
            node.val = val;
            node.left = node.right = null;
            head = node;
            size++;
        }
        int compare = key.compareTo(head.key);
        if (compare < 0) {
            head.left  = put(head.left, key, val);
        } else if (compare > 0) {
            head.right = put(head.right, key, val);
        } else {
            head.val = val;
        }
        return head;
    }
    /**
     * { Get method }.
     *
     * @param      key   The key
     *
     * @return     { Value }.
     * Time complexity :
     * Best Case : O(logN)
     * Average Case : O(logN)
     * Worst Case : O(logN)
     */
    public Value get(BookList key) {
        return get(root, key);
    }
    /**
     * { Get method }.
     *
     * @param      root  The root
     * @param      key   The key
     *
     * @return     { Value. }
     * Time complexity :
     * Best Case : O(logN)
     * Average Case : O(logN)
     * Worst Case : O(logN)
     */
    private Value get(Node root, BookList key) {
        if (key == null) {
            System.out.println("key is null");
        }

        if (root == null) {
            return null;
        }
        int compare = key.compareTo(root.key);
        if (compare < 0) {
            return get(root.left, key);
        } else if (compare > 0) {
            return get(root.right, key);
        } else {
            return root.val;
        }
    }
}
