/**
Importing Value.
*/
import java.util.Scanner;
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
     * { Main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Percolation p = new Percolation(scan.nextInt());
        while (scan.hasNext()) {
            p.open(scan.nextInt(), scan.nextInt());
        }
        System.out.println(p.percolates());
    }
}
