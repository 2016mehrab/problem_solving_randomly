import java.util.Arrays;

class LC63 {
    private int uniquePathsWithObstaclesImpl(int r, int c, int[][] dp, int[][] obstacleGrid, int ROWS, int COLS) {
        if (r >= ROWS || c >= COLS)
            return 0;
        if (obstacleGrid[r][c] == 1) {
            return 0;
        }
        if (r == ROWS - 1 && c == COLS - 1)
            return 1;
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int res = uniquePathsWithObstaclesImpl(r + 1, c, dp, obstacleGrid, ROWS, COLS)
                + uniquePathsWithObstaclesImpl(r, c + 1, dp, obstacleGrid, ROWS, COLS);
        dp[r][c] = res;
        return res;

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ROWS = obstacleGrid.length;
        int COLS = obstacleGrid[0].length;
        int[][] dp = new int[ROWS][COLS];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return uniquePathsWithObstaclesImpl(0, 0, dp, obstacleGrid, ROWS, COLS);

    }

    public static void main(String[] args) {
        LC63 solution = new LC63();

    }
}
