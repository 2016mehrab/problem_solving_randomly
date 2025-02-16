import java.util.Arrays;

class LC62 {
    private int uniquePathImpl(int r, int c, int m, int n, int[][] dp) {

        if (r >= m || c >= n) {
            return 0;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        if (r == m - 1 && c == n - 1)
            return 1;
        int res = uniquePathImpl(r + 1, c, m, n, dp) + uniquePathImpl(r, c + 1, m, n, dp);
        dp[r][c] = res;
        return res;

    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int r = uniquePathImpl(0, 0, m, n, dp);
        System.out.println(r);
        return r;
    }

    public static void main(String[] args) {
        LC62 solution = new LC62();
        solution.uniquePaths(3, 7);
        solution.uniquePaths(23, 12);

    }
}
