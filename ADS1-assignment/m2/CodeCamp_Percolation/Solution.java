// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.Scanner;
class Percolation {
	boolean[][] opened;
	int top = 0;
	int bottom;
	int size;
	UnionFindPathCompression uf;
	int count = 0;

	public Percolation(int N) {
		opened = new boolean[N][N];
		size = N;
		bottom = N * N + 1;
		uf = new UnionFindPathCompression(N * N + 2);
	}

	public void open(int row, int col) {
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

	public boolean isOpen(int row, int col) {
		return opened[row - 1][col - 1];
	}

	public boolean isFull(int row, int col) {
		return uf.connected(top, getUFIndex(row, col));
	}

	public boolean percolates() {
		return uf.connected(top, bottom);
	}

	private int getUFIndex(int row, int col) {
		return size * (row - 1) + col;
	}
}
class Solution {
	Solution () {

	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		Percolation p = new Percolation(scan.nextInt());
		while (scan.hasNext()) {
			p.open(scan.nextInt(), scan.nextInt());
		}
		System.out.println(p.percolates());
	}
}