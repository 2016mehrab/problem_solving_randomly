import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class LC2503 {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[][] q = new int[queries.length][2];
        Map<String, Boolean> visited = new HashMap<>();
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            q[i] = new int[] { queries[i], i };
        }
        Arrays.sort(q, (f, l) -> Integer.compare(f[0], l[0]));
        // [value, x, y]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        pq.add(new int[] { grid[0][0], 0, 0 });
        visited.put("0,0", true);
        int points = 0;
        for (int i = 0; i < q.length; ++i) {
            var queryVal = q[i][0];
            var queryIdx = q[i][1];
            while (!pq.isEmpty() && pq.peek()[0] < queryVal) {
                var curr = pq.poll();
                ++points;
                for (var dir : dirs) {
                    int new_x = dir[0] + curr[1];
                    int new_y = dir[1] + curr[2];
                    var key = new_x + "," + new_y;
                    if (new_x >= 0 && new_x < grid.length && new_y >= 0 && new_y < grid[0].length
                            && !visited.getOrDefault(key, false)) {
                        visited.put(key, true);
                        pq.add(new int[] { grid[new_x][new_y], new_x, new_y });
                    }

                }

            }
            res[queryIdx] = points;

        }
        return res;

    }

    public static void main(String[] args) {
        LC2503 solution = new LC2503();

    }
}
