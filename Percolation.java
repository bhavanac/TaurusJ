/**
 * Created by bchalla on 7/12/15.
 */
public class Percolation {
  int[][] grid;
  int N;
  WeightedQuickUnionUF weightedQuickUnionUF;
  WeightedQuickUnionUF weightedQuickUnionUFToPreventBackwash;

  public Percolation(int N) {
    // create N-by-N grid, with all sites blocked
    if (N <= 0) {
      throw new IllegalArgumentException();
    }

    this.N = N;
    grid = new int[N+1][N+1];
    weightedQuickUnionUF = new WeightedQuickUnionUF((N*N)+2);
    weightedQuickUnionUFToPreventBackwash = new WeightedQuickUnionUF((N*N)+1);
    // N+2 because we have to include virtual top site and virtual bottom site
    // top's index is N
    // bottom's index is N+1

    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= N; j++) {
        if (i == 0 || j == 0) {
          grid[i][j] = -1;
        } else {
          grid[i][j] = 0;
        }
      }
    }
  }

  public void open(int i, int j) {
    if (!validForGrid(i, j)) {
      throw new IllegalArgumentException();
    }

    // open site (row i, column j) if it is not open already
    if (grid[i][j] == 1) {
      return;
    }

    grid[i][j] = 1;

    // Firstly, if it exists in the top row, we should do union with top virtual site
    if (i == 1) {
      weightedQuickUnionUF.union(getVirtualTopSiteIndex(), TwoDimToOneDim(i,j));
      weightedQuickUnionUFToPreventBackwash.union(getVirtualTopSiteIndex(), TwoDimToOneDim(i,j));
    }

    // Secondly, it it exists in the bottom row, we should do union with bottom virtual site
    if (i == N) {
      weightedQuickUnionUF.union(getVirtualBottomSiteIndex(), TwoDimToOneDim(i,j));
    }

    // Otherwise open it by doing a union of left right above and below open sites
    // left is open ? then call union
    if (j-1 >= 1 && grid[i][j-1] == 1) {
      weightedQuickUnionUF.union(TwoDimToOneDim(i,j-1), TwoDimToOneDim(i, j));
      weightedQuickUnionUFToPreventBackwash.union(TwoDimToOneDim(i,j-1), TwoDimToOneDim(i, j));
    }

    // right is open ? then call union
    if (j+1 <= N && grid[i][j+1] == 1) {
      weightedQuickUnionUF.union(TwoDimToOneDim(i, j+1), TwoDimToOneDim(i, j));
      weightedQuickUnionUFToPreventBackwash.union(TwoDimToOneDim(i, j + 1), TwoDimToOneDim(i, j));
    }

    // bottom is open ?
    if (i+1 <= N && grid[i+1][j] == 1) {
      weightedQuickUnionUF.union((TwoDimToOneDim(i+1, j)), TwoDimToOneDim(i, j));
      weightedQuickUnionUFToPreventBackwash.union((TwoDimToOneDim(i+1, j)), TwoDimToOneDim(i, j));
    }

    // top is open ?
    if (i-1 >= 1 && grid[i-1][j] == 1) {
      weightedQuickUnionUF.union(TwoDimToOneDim(i-1, j), TwoDimToOneDim(i, j));
      weightedQuickUnionUFToPreventBackwash.union(TwoDimToOneDim(i-1, j), TwoDimToOneDim(i, j));
    }
  }

  public boolean isOpen(int i, int j) {
    // is site (row i, column j) open?
    // If grid[i][j] == 0, then the site is blocked. If it is 1
    // it is open.
    return (grid[i][j] == 1);
  }

  public boolean isFull(int i, int j)     // is site (row i, column j) full?
  {
    return weightedQuickUnionUF.connected(TwoDimToOneDim(i, j), getVirtualTopSiteIndex())
        && weightedQuickUnionUFToPreventBackwash.connected(TwoDimToOneDim(i, j), getVirtualTopSiteIndex());
  }

  public boolean percolates()             // does the system percolate
  {
    return weightedQuickUnionUF.connected(getVirtualTopSiteIndex(), getVirtualBottomSiteIndex());
  }

  private int getVirtualTopSiteIndex() {
    return (N*N);
  }

  private int getVirtualBottomSiteIndex() {
    return (N*N)+1;
  }

  private int TwoDimToOneDim(int i, int j) {
    if (validForGrid(i, j)) {
      return ((i-1)*N)+(j-1);
    }
    return -1;
  }

  public boolean validForGrid(int i, int j) {
    if (i <= 0 || i > N) {
      return false;
    }

    if (j <= 0 || j > N) {
      return false;
    }

    return true;
  }
}
