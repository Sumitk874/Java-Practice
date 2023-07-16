import java.util.*;
public class MaxSumRectangle {

  public static int maxSumRectangle(int[][] arr, int n, int m) {
    int[] row = new int[n];
    int max = Integer.MIN_VALUE;

    // Storing max col sum in row arr;
    for (int c = 0; c < m; c++) {
      Arrays.fill(row, 0);

      for (int cNext = c; cNext < m; cNext++) {
        for (int r = 0; r < n; r++) {
          row[r] += arr[r][cNext];
        }

        int maxSum = KadaneAlgo(row);
        max = Math.max(max, maxSum);
      }
    }

    return max;
  }
// Apply Kadane algo to row arr to get amx sum
public static int KadaneAlgo(int[] row) {
    int ms = Integer.MIN_VALUE;
    int cs = 0;

    for (int i = 0; i < row.length; i++) {
      cs = cs + row[i];
      ms = Math.max(ms, cs);

      if (cs < 0) {
        cs = 0;
      }
    }

    return ms;
  }

  public static void main(String[] args) {
    int[][] arr = {
        {-1, 1},
        {2, 2}
    };

    int n = arr.length;
    int m = arr[0].length;

    int maxSum = maxSumRectangle(arr, n, m);
    System.out.println("The maximum sum rectangle is: " + maxSum);
  }
}