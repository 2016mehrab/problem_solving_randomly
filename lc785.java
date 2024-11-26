import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class LC785 {
    public static int[][] convertStringTo2DArray(String input) {
        input = input.trim().substring(1, input.length() - 1);
        String[] rows = input.split("\\],\\[");
        int[][] result = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = rows[i].replace("[", "").replace("]", "");
            String[] numbers = rows[i].split(",");
            result[i] = Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
        System.out.println("<--------------------------------------------->");
    }

    public Boolean BFS(int parent, byte color, int[][] graph, byte[] colored) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(parent);
        colored[parent] = color;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int children = graph[curr].length;
            for (int i = 0; i < children; ++i) {
                // same color
                if (colored[graph[curr][i]] == colored[curr]) {
                    return false;
                }
                // not visited
                else if (colored[graph[curr][i]] == 0) {
                    if (colored[curr] == 1) {
                        colored[graph[curr][i]] = 2;
                    } else {
                        colored[graph[curr][i]] = 1;
                    }
                    queue.add(graph[curr][i]);
                }

            }

        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int ROWS = graph.length;
        byte[] colored = new byte[ROWS];
        for (int r = 0; r < ROWS; ++r) {
            // not visited
            if (colored[r] == 0) {
                if (!BFS(r, (byte) 1, graph, colored)) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        LC785 solution = new LC785();
        int[][] g1 = convertStringTo2DArray("[[1,2,3],[0,2],[0,1,3],[0,2]]");
        int[][] g2 = convertStringTo2DArray("[[1,3],[0,2],[1,3],[0,2]]");
        System.out.println(solution.isBipartite(g1));
        System.out.println(solution.isBipartite(g2));

    }
}
