// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
/**
Importing Value.
*/
import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * { Value }.
     */
    private boolean[][] opened;
    /**
     * { Value }.
     */
    private int top = 0;
    /**
     * { Value }.
     */
    private int bottom;
    /**
     * { Value }.
     */
    private int size;
    /**
     * { Value }.
     */
    private UnionFindPathCompression uf;
    /**
     * { Value }.
     */
    private int count = 0;
    /**
     * Constructs the object.
     *
     * @param      N     { Integer }.
     */
    public Percolation(final int N) {
        opened = new boolean[N][N];
        size = N;
        bottom = N * N + 1;
        uf = new UnionFindPathCompression(N * N + 2);
    }
    /**
     * { OPen }.
     *
     * @param      row   The row
     * @param      col   The col
     */
    public void open(final int row, final int col) {
        if (isOpen(row, col)) return;
        count++;
        opened[row - 1][col - 1] = true;
        if (row == 1)
            uf.union(top, getUFIndex(row, col));
        if (row == size)
            uf.union(getUFIndex(row, col), bottom);
        if (row > 1 && isOpen(row - 1, col))
            uf.union(getUFIndex(row, col), getUFIndex(row - 1, col));
        if (row < size && isOpen(row + 1, col))
            uf.union(getUFIndex(row, col), getUFIndex(row + 1, col));
        if (col > 1 && isOpen(row, col - 1))
            uf.union(getUFIndex(row, col), getUFIndex(row, col - 1));
        if (col < size && isOpen(row, col + 1))
            uf.union(getUFIndex(row, col), getUFIndex(row, col + 1));
    }
    /**
     * Determines if open.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int row, final int col) {
        return opened[row - 1][col - 1];
    }
    /**
     * Determines if full.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if full, False otherwise.
     */
    public boolean isFull(final int row, final int col) {
        return uf.connected(top, getUFIndex(row, col));
    }
    /**
     * { Checks whether Percolates or nOt }.
     *
     * @return     { Boolean }.
     */
    public boolean percolates() {
        return uf.connected(top, bottom);
    }
    /**
     * Gets the uf index.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     The uf index.
     */
    private int getUFIndex(final int row, final int col) {
        return size * (row - 1) + col;
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    private Solution () {

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