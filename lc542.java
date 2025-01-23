import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class LC542 {
    public int[][] updateMatrix(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        int[][] r = new int[M][N];
        int[][] v = new int[M][N];
        Queue<int[]> q = new ArrayDeque<>();
        for (int row = 0; row < M; ++row) {
            for (int col = 0; col < N; ++col) {
                if (mat[row][col] == 0) {
                    r[row][col] = 0;
                    v[row][col] = 1;
                    q.add(new int[] { 0, row, col });
                } else {

                    v[row][col] = -1;
                }
            }
        }
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!q.isEmpty()) {
            var curr = q.poll();
            int val = curr[0];
            int x = curr[1];
            int y = curr[2];
            // visit the neighbors
            for (int[] dir : dirs) {
                int x_ = x + dir[0];
                int y_ = y + dir[1];
                if (x_ < 0 || y_ < 0 ||
                        x_ >= M || y_ >= N ||
                        v[x_][y_] != -1)
                    continue;

                r[x_][y_] = val + 1;
                v[x_][y_] = 1;
                q.add(new int[] { val + 1, x_, y_ });

            }
        }
        return r;

    }

    public static void main(String[] args) {
        LC542 solution = new LC542();
        int[][] m1 = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int[][] m2 = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        solution.updateMatrix(m1);
        solution.updateMatrix(m2);

    }
}
