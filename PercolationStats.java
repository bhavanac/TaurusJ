/**
 * Created by bchalla on 7/12/15.
 */
public class PercolationStats {
  double[] results;
  double totalSum;
  int openSites;
  int T;

  public PercolationStats(int N, int T) {
    // perform T independent experiments on an N-by-N grid
    this.T = T;
    Percolation perc;
    results = new double[T];

    for (int i = 0; i < T; i++) {
      openSites = 0;
      perc = new Percolation(N);

      while (!perc.percolates()) {
        int a = StdRandom.uniform(N) + 1; // This generates numbers from 0 to N-1. So add 1
        int b = StdRandom.uniform(N) + 1;
        if (perc.validForGrid(a, b) && !perc.isOpen(a, b)) {
          perc.open(a, b);
          openSites++;
        }
      }

      results[i] = ((double) openSites / (N * N));
      totalSum += ((double) openSites / (N * N));
    }
  }

  public double mean() {
    return StdStats.mean(results);
  }

  public double stddev() {
    return StdStats.stddev(results);
  }

  public double confidenceLo() {
    double mean = mean();
    double stddev = stddev();
    return (mean - ((1.96 * stddev) / Math.sqrt(T)));
  }

  public double confidenceHi() {
    double mean = mean();
    double stddev = stddev();
    return (mean + ((1.96 * stddev) / Math.sqrt(T)));
  }

  public static void main(String[] args) {
    System.out.println(args[0] + " " + args[1]);
    PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    System.out.println("mean                     = " + stats.mean());
    System.out.println("stddev                   = " + stats.stddev());
    System.out.println("95 % confidence interval = " + stats.confidenceLo() + ", " + stats.confidenceHi());
  }
}
