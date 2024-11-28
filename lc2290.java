import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

class LC2290 {
        public int minimumObstacles(int[][] grid) {
                int ROWS = grid.length;
                int COLS = grid[0].length;
                boolean[][] visited = new boolean[ROWS][COLS];
                Deque<ArrayList<Integer>> queue = new ArrayDeque<>();
                queue.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0)));
                visited[0][0] = true;
                int[][] moves = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
                while (!queue.isEmpty()) {
                        ArrayList<Integer> curr = queue.poll();
                        for (int[] move : moves) {
                                int x = move[0] + curr.get(0);
                                int y = move[1] + curr.get(1);
                                if (x >= ROWS || y >= COLS || x < 0 || y < 0 || visited[x][y])
                                        continue;
                                visited[x][y] = true;
                                if (x == ROWS - 1 && y == COLS - 1) {
                                        return curr.get(2);
                                }
                                if (grid[x][y] == 0) {
                                        queue.addFirst(new ArrayList<Integer>(Arrays.asList(x, y, curr.get(2))));
                                } else {
                                        queue.addLast(new ArrayList<Integer>(Arrays.asList(x, y, curr.get(2) + 1)));
                                }
                        }

                }

                return -1;
        }

        public static void main(String[] args) {
                LC2290 solution = new LC2290();

        }
}
