package edu.ds.practice.TopCoder;

import java.util.HashSet;
import java.util.Set;


public class Islands {
  public int numIslands(char[][] grid) {
    if (grid == null) {
      return 0;
    }

    int m = grid.length; // Gives rows count;
    if (m == 0) {
      return 0;
    }

    int n = grid[m-1].length; // Gives columns count;
    weightedQuickUnionFind uf = new weightedQuickUnionFind(m*n);
    for (int i=0;i<m;i++) {
      for (int j=0;j<n;j++) {
        char value = grid[i][j];
        int oneDim = getOneDim(i,j, n);

        // Left value
        // i,j-1
        if (isValid(i,j-1,m,n) && value == grid[i][j-1]) {
          uf.union(oneDim, getOneDim(i,j-1,n));
        }

        // Right value
        // i,j+1
        if (isValid(i,j+1,m,n) && value == grid[i][j+1]) {
          uf.union(oneDim, getOneDim(i,j+1,n));
        }

        // Top value
        // i-1,j
        if (isValid(i-1,j,m,n) && value == grid[i-1][j]) {
          uf.union(oneDim, getOneDim(i-1,j,n));
        }

        // Bottom value
        // i+1,j
        if (isValid(i+1,j,m,n) && value == grid[i+1][j]) {
          uf.union(oneDim, getOneDim(i+1,j,n));
        }
      }
    }

    Set<Integer> set = new HashSet<Integer>();
    for (int i=0;i<m;i++) {
      for (int j=0;j<n;j++) {
        if (grid[i][j] == '1') {
          set.add(uf.root(getOneDim(i,j,n)));
        }
      }
    }

    return set.size();
  }

  private boolean isValid(int i, int j, int rowCount, int columnCount) {
    if (i < 0 || i >= rowCount)  {
      return false;
    }

    if (j < 0 || j >= columnCount) {
      return false;
    }

    return true;
  }

  private int getOneDim(int i, int j, int columnCount) {
    return ((i*(columnCount))+j);
  }

  public class weightedQuickUnionFind {
    int[] id; // id[i] -> holds parent of i; if id[i] == i, i is the root;
    int[] size; // size[i] -> holds the number of nodes rooted at i
    int count; // gives number of component; between 1 to N

    public weightedQuickUnionFind(int N) {
      id = new int[N];
      size = new int[N];
      count = N;

      for (int i=0;i<N;i++) {
        id[i] = i;
        size[i] = 1;
      }
    }

    public void union(int i, int j) {
      int iRoot = root(i);
      int jRoot = root(j);

      if (size[iRoot] > size[jRoot]) {
        id[jRoot] = iRoot;
        size[iRoot]+=size[jRoot];
      } else {
        id[iRoot] = jRoot;
        size[jRoot]+=size[iRoot];
      }

      count--;
    }

    public boolean isConnected(int i, int j) {
      return root(i) == root(j);
    }

    public int root(int i) {
      while (id[i] != i) {
        i = id[i];
      }

      return i;
    }

    private int getComponentsCount() {
      return count;
    }
  }
}
