/**.
 * { Scanner class }
 */
import java.util.Scanner;
/**.
 * { Solution class }
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
    }
    /**.
     * { Main Function }
     *
     * @param      args  The arguments
     */
    // time complexity for the main method is N
    // Because there is one while loop.
    // while loop iterates until it has next line i.e N times.
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Sorting sort = new Sorting();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Team team = new Team(tokens[0], Integer.parseInt(tokens[1]),
             Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2 + 1]));
            sort.add(team);
        }
        sort.insertion();
        System.out.println(sort.toString());
    }
}
