import java.util.HashMap;
import java.util.Map;

class LC2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int a = 0;
        int b = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                count.putIfAbsent(grid[i][j], 0);
                count.put(grid[i][j], count.get(grid[i][j]) + 1);
            }
        }
        for (int i = 1; i <= M * M; ++i) {
            if (count.containsKey(i)) {
                if (count.get(i) > 1)
                    a = i;
            } else
                b = i;
        }
        return new int[] { a, b };

    }

    public static void main(String[] args) {
        LC2965 solution = new LC2965();
        solution.findMissingAndRepeatedValues(new int[][] { { 1, 3 }, { 2, 2 } });

    }
}
