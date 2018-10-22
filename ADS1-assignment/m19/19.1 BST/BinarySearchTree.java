/**.
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>,Value> {
    /**.
     * { var_description }
     */
    private Node root;
    /**.
     * { var_description }
     */
    private int size;
    /**.
     * Class for node.
     */
    private class Node {
        /**.
         * { var_description }
         */
        private BookList key;
        /**.
         * { var_description }
         */
        private Value val;
        /**.
         * { item_description }
         */
        private Node left, right;
        /**.
         * { var_description }
         */
        private int count; 
        /**.
         * Constructs the object.
         */
        public Node () {
        }
    }
    /**.
     * { function_description }
     *
     * @param      key   The key
     * @param      val   The value
     * Time complexity : O(N)
     */
    public void put(BookList key, Value val) {
        if (key == null) {
            System.out.println("key is null");
        }
        root = put(root, key, val);
    }
    /**
     * { function_description }
     *
     * @param      head  The head
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(N)
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
        head.count = 1 + size(head.left) + size(head.right);
        return head;
    }
    /**
     * { function_description }
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(N)
     */
    public Value get(BookList key) {
        return get(root, key);
    }
    /**
     * { function_description }
     *
     * @param      root  The root
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(N)
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
        } else{
            return root.val;
        }
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList min() {
        return min(root).key;
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node min(Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList max() {
        return max(root).key;
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**.
     * { function_description }
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList floor(BookList key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node floor(Node x, BookList key) {
        if (x == null) {
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare == 0) {
            return x;
        }
        if (compare < 0) {
            return floor(x.left, key);
        }
        Node temp = floor(x.right, key);
        if (temp != null) {
            return temp;
        } else {
            return x;
        }
    }
    /**.
     * { function_description }
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList ceiling(BookList key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node ceiling(Node x, BookList key) {
        if (x == null) {
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare == 0) {
            return x;
        }
        if (compare < 0) {
            Node temp = ceiling(x.left, key);
            if (temp != null) {
                return temp;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }

    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(1)
     */

    public int size() {
        return size(root);
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(1)
     */
    public int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.count;
    }
    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList select(int k) {
        if (k < 0 || k >= size()) {
            return null;
        }
        Node x = select(root, k);
        return x.key;
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node select(Node x, int k) {
        if (x == null) {
            return null; 
        }
        int t = size(x.left); 
        if (t > k) {
            return select(x.left,  k); 
        } else if (t < k) {
            return select(x.right, k-t-1);
        } else {
            return x;
        }
    }
    /**.
     * { function_description }
     * Time complexity : O(N)
     */
    public void keys() {
        keys(root);
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     * Time complexity : O(N)
     */
    public void keys(Node x) {
        if (x == null) {
            return;
        } else {
            keys(x.left);
            System.out.println(x.key);
            keys(x.right);
        }
    }
}
