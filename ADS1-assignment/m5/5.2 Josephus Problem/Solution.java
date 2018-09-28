/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * { item_description }
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        /**.
         * { item_description }
         */
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            int n = Integer.parseInt(tokens[0]);
            int m = Integer.parseInt(tokens[1]);
            Queue q = new Queue();
            String str = "";
            for (int j = 0; j < n; j++) {
                q.enqueue(j);
            }

            while (!q.isEmpty()) {
                for (int k = 0; k < m - 1; k++) {
                    q.enqueue(q.dequeue());
                }
                str += q.dequeue() + " ";
            }
            System.out.println(str.substring(0, str.length() - 1));
            //System.out.println();
        }
    }
}
