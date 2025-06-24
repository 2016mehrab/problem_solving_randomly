import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

class LCIslandsAndTreasure {
    int M, N;
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public void islandsAndTreasure(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        for (int r = 0; r < M; ++r) {
            for (int c = 0; c < N; ++c) {
                if (grid[r][c] == 0)
                    bfs(grid, r, c);
            }
        }
        for (int r = 0; r < M; ++r) {
            for (int c = 0; c < N; ++c) {
                if (grid[r][c] == -2) {
                    grid[r][c] = 2147483647;
                }
                bfs(grid, r, c);
            }
        }
    }

    void bfs(int[][] grid, int r, int c) {
        // x,y, val

        Map<String, Boolean> visited = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        visited.put(r + "" + c, true);
        q.add(new int[] { r, c, 0 });

        while (!q.isEmpty()) {
            var curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for (int[] dir : dirs) {
                int _x = dir[0] + x;
                int _y = dir[1] + y;
                String key = _x + "" + _y;
                if (_x > -1 && _y > -1 && _x < M && _y < N &&
                // not visited
                        !visited.getOrDefault(key, false)
                        && grid[_x][_y] != -1 && grid[_x][_y] != 0
                        && grid[_x][_y] > curr[2] + 1) {
                    // mark visied
                    visited.put(key, true);
                    grid[_x][_y] = curr[2] + 1;
                    // add to q with new dist
                    q.add(new int[] { _x, _y, curr[2] + 1 });
                }
            }
        }
    }

    public static void main(String[] args) {
        LCIslandsAndTreasure solution = new LCIslandsAndTreasure();

    }
}
