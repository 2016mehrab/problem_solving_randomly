import java.awt.PrintJob;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

class LC3243 {
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

    public int BFS(ArrayList<Integer>[] adj, int target) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        short[] visited = new short[target + 1];
        Arrays.fill(visited, (short) -1);
        visited[0] = 1;
        int level = 0;
        while (!q.isEmpty()) {
            int currentLevelNodes = q.size();
            for (int i = 0; i < currentLevelNodes; ++i) {
                int curr = q.poll();
                ArrayList<Integer> currNeighbors = adj[curr];
                if (curr == target) {
                    return level;
                }
                for (int v : currNeighbors) {
                    if (visited[v] != 1) {
                        visited[v] = 1;
                        q.add(v);
                    }

                }
            }
            ++level;
        }
        return -1;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int ROWS = queries.length;
        int COLS = queries[0].length;
        int[] shortestPaths = new int[ROWS];
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n - 1; ++i) {
            adj[i].add(i + 1);
        }
        int index = 0;
        for (int[] relation : queries) {
            adj[relation[0]].add(relation[1]);
            shortestPaths[index++] = BFS(adj, n - 1);
        }

        return shortestPaths;
    }

    public static void main(String[] args) {
        LC3243 solution = new LC3243();
        int[][] queries1 = convertStringTo2DArray("[[2,4],[0,2],[0,4]]");
        int[][] queries2 = convertStringTo2DArray("[[0,3],[0,2]]");
        solution.shortestDistanceAfterQueries(5, queries1);
        solution.shortestDistanceAfterQueries(4, queries2);

    }
}
