import java.util.Arrays;

class LC980 {
    private int ROWS;
    private int COLS;
    private int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private int dfs(int r, int c, boolean[][] seen, int[][] grid, int nobsCnt, int nobs) {
        if (grid[r][c] == 2)
            return nobsCnt == nobs ? 1 : 0;
        int ways = 0;
        seen[r][c] = true;
        if (grid[r][c] != 1)
            ++nobsCnt;

        for (int[] dir : dirs) {
            int row = r + dir[0];
            int col = c + dir[1];
            if (row >= ROWS || row < 0 || col < 0 || col >= COLS || grid[row][col] == -1 || seen[row][col])
                continue;
            ways += dfs(row, col, seen, grid, nobsCnt, nobs);
        }
        seen[r][c] = false;
        return ways;
    }

    public int uniquePathsIII(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        boolean[][] seen = new boolean[ROWS][COLS];
        int ways = 0;
        int nobs = 0;
        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                if (grid[r][c] == 0) {
                    ++nobs;
                }
            }
        }
        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                if (grid[r][c] == 1) {
                    ways = dfs(r, c, seen, grid, 0, nobs);
                }

            }
        }
        System.out.println(ways);
        return ways;

    }

    public static void main(String[] args) {
        LC980 solution = new LC980();
        solution.uniquePathsIII(new int[][] { { 0, 1 }, { 2, 0 } });
        solution.uniquePathsIII(new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } });

    }
}
