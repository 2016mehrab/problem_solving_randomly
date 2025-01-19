import java.util.PriorityQueue;
import java.util.Queue;

class LC407 {
    public int trapRainWater(int[][] heightMap) {
        int M = heightMap.length;
        int N = heightMap[0].length;
        int r = 0;
        Queue<int[]> boundary = new PriorityQueue<>((f, l) -> f[0] - l[0]);
        // add top row & bottom row
        for (int i : new int[] { 0, M - 1 }) {
            for (int j = 0; j < N; ++j) {
                boundary.add(new int[] { heightMap[i][j], i, j });
            }
        }
        // add first col & last col
        for (int i : new int[] { 0, N - 1 }) {
            for (int j = 0; j < M; ++j) {
                boundary.add(new int[] { heightMap[j][i], j, i });
            }
        }
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        // var tmp = boundary.peek();
        // heightMap[tmp[1]][tmp[2]] = -1;

        while (!boundary.isEmpty()) {
            var curr = boundary.poll();
            int h = curr[0];
            int x = curr[1];
            int y = curr[2];
            for (int[] dir : dirs) {
                int x_ = x + dir[0];
                int y_ = y + dir[1];
                if (x_ <= 0 || y_ <= 0 || x_ >= M - 1 || y_ >= N - 1 || heightMap[x_][y_] == -1)
                    continue;
                r += Math.max(h - heightMap[x_][y_], 0);
                // add to boundary
                boundary.add(new int[] { Math.max(h, heightMap[x_][y_]), x_, y_ });
                // mark visited
                heightMap[x_][y_] = -1;
            }
        }
        return r;

    }

    public static void main(String[] args) {
        LC407 solution = new LC407();

    }
}
