/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */


import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final WeightedQuickUnionUF weightedQuickUnionUF;
    private boolean[][] sites;
    private int openSites;
    private final int n;
    private final int size;

    public Percolation(int n) {

        if (n <= 0)
            throw new java.lang.IllegalArgumentException("N must be positive");

        this.size = n*n;
        this.n = n;

        weightedQuickUnionUF = new WeightedQuickUnionUF(n*n + 2);
        sites = new boolean[n][n];
        openSites = 0;
        // Populate all sites as being closed
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sites[i][j] = false;
            }
        }
        // Create unions on first and last rows
        for (int i = 0; i < n; i++) {
            weightedQuickUnionUF.union(i + 1, 0);
            weightedQuickUnionUF.union(size - i, size + 1);
        }

    }

    public void open(int row, int col) {

        if ((row <= 0) || (row > n) || (col <= 0) || (col > n))
            throw new java.lang.IllegalArgumentException("Out of bounds exception");

        if (isOpen(row, col)) { return; }

        sites[row - 1][col - 1] = true;
        openSites += 1;

        // Get neighbour indexes;
        int curIndex = n*(row - 1) + col;

        // Is cell alligned to right or left sides ?
        if (curIndex == row*n) { // Only connect left side if open and alligned to right side
            if (isOpen(row, col -1))
                weightedQuickUnionUF.union(curIndex, curIndex - 1);
        } else if (curIndex == ((row - 1)*n + 1)) { // Only connect right side if open and alligned to left side
            if (isOpen(row, col + 1))
                weightedQuickUnionUF.union(curIndex, curIndex + 1);
        } else { // Connect both sides if they are open
            if (isOpen(row, col - 1))
                weightedQuickUnionUF.union(curIndex, curIndex - 1);

            if (isOpen(row, col + 1))
                weightedQuickUnionUF.union(curIndex, curIndex + 1);
        }

        // Is cell alligned to top or bottom
        if (row == 1) {
            if (isOpen(row + 1, col))
                weightedQuickUnionUF.union(curIndex, curIndex + n);
        } else if (row == n) {
            if (isOpen(row - 1, col))
                weightedQuickUnionUF.union(curIndex, curIndex - n);
        } else {
            if (isOpen(row + 1, col))
                weightedQuickUnionUF.union(curIndex, curIndex + n);

            if (isOpen(row - 1, col))
                weightedQuickUnionUF.union(curIndex, curIndex - n);
        }
    }

    public boolean isOpen(int row, int col) {

        if ((row <= 0) || (row > n) || (col <= 0) || (col > n))
            throw new java.lang.IllegalArgumentException("Out of bounds exception");

        return sites[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {

        if ((row <= 0) || (row > n) || (col <= 0) || (col > n))
            throw new java.lang.IllegalArgumentException("Out of bounds exception");

        // Only check if cell is open
        if (isOpen(row, col)) {

            int index = n*(row - 1) + col;

            return weightedQuickUnionUF.connected(0, index);
        }

        return false;
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return weightedQuickUnionUF.connected(0, size + 1);
    }

    public static void main(String[] args) {

    }
}
