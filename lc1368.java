import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class LC1368 {
    public int minCost(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> pq = new PriorityQueue<>((f, l) -> f[0] - l[0]);
        int[][] dir = { { 4, -1, 0 }, { 3, 1, 0 }, { 1, 0, 1 }, { 2, 0, -1 } };
        int[][] cost = new int[M][N];

        for (int[] c : cost)
            Arrays.fill(c, Integer.MAX_VALUE);

        pq.add(new int[] { 0, 0, 0 });
        cost[0][0] = 0;
        while (!pq.isEmpty()) {
            var curr = pq.poll();
            int cost_ = curr[0];
            int x = curr[1];
            int y = curr[2];
            if (cost_ > cost[x][y])
                continue;

            for (int[] move : dir) {
                int new_x = x + move[1];
                int new_y = y + move[2];
                if (new_x < 0 || new_y < 0 ||
                        new_x >= M || new_y >= N)
                    continue;
                int estimatedCost = 0;
                if (grid[x][y] != move[0]) {
                    ++estimatedCost;
                }

                estimatedCost += cost_;
                if (estimatedCost < cost[new_x][new_y]) {
                    cost[new_x][new_y] = estimatedCost;
                    pq.add(new int[] { cost[new_x][new_y], new_x, new_y });
                }
            }
        }

        System.out.println(cost[M - 1][N - 1]);
        return cost[M - 1][N - 1];
    }

    public static void main(String[] args) {
        LC1368 solution = new LC1368();
        int[][] g1 = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 } };
        int[][] g2 = { { 1, 1, 3 }, { 3, 2, 2 }, { 1, 1, 4 } };
        int[][] g3 = { { 1, 2 }, { 4, 3 } };
        solution.minCost(g3);
        solution.minCost(g1);
        solution.minCost(g2);

    }
}
