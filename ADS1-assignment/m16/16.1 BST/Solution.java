/**.
 * { Scanner }
 */
import java.util.Scanner;
/**.
 * { Solution class }.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
    }
    /**.
     * { Main method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] tokens = input.split(",");
            switch (tokens[0]) {
            case "put":
                bst.put(new BookList(
                            tokens[1], tokens[2],
                            Float.parseFloat(tokens[2 + 1])),
                        Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                System.out.println(
                    bst.get(
                        new BookList(tokens[1],
                                     tokens[2],
                                     Float.parseFloat(
                                         tokens[2 + 1]))));
                break;
            default:
                break;
            }
        }
    }
}
