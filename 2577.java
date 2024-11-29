import java.util.PriorityQueue;

class LC2577 {
    public int minimumTime(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        PriorityQueue<int[]> pq = new PriorityQueue<>((f, l) -> f[2] - l[2]);
        // {r, c, time}
        if (Math.min(grid[0][1], grid[1][0]) > 1)
            return -1;
        pq.add(new int[] { 0, 0, 0 });
        int[][] moves = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (visited[curr[0]][curr[1]]) {
                continue;
            }
            visited[curr[0]][curr[1]] = true;
            if (curr[0] == ROWS - 1 && curr[1] == COLS - 1) {
                return curr[2];
            }
            for (int[] move : moves) {
                int nextR = curr[0] + move[0];
                int nextC = curr[1] + move[1];
                // out of bounds
                if (nextR < 0 || nextC < 0 || nextR >= ROWS || nextC >= COLS) {
                    continue;
                }
                int nextTime = curr[2];
                if (grid[nextR][nextC] < nextTime) {
                    pq.add(new int[] { nextR, nextC, nextTime + 1 });
                    continue;
                }
                if (((grid[nextR][nextC]) - nextTime) % 2 == 1) {
                    nextTime = grid[nextR][nextC];
                } else {
                    nextTime = grid[nextR][nextC] + 1;
                }
                pq.add(new int[] { nextR, nextC, nextTime });
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC2577 solution = new LC2577();

    }
}
