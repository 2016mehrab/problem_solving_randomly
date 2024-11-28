import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class LC547 {
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

    private void markConnectionBFS(int node, int[][] adj, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbor = 0; neighbor < adj[curr].length; ++neighbor) {
                if (visited[neighbor])
                    continue;
                if (adj[curr][neighbor] == 1) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    private void markConnectionDFS(int node, int[][] adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor = 0; neighbor < adj[node].length; ++neighbor) {
            if (visited[neighbor])
                continue;
            if (adj[node][neighbor] == 1) {

                markConnectionDFS(neighbor, adj, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int ROWS = isConnected.length;
        boolean[] visited = new boolean[ROWS];
        int provinces = 0;
        for (int city = 0; city < ROWS; ++city) {
        if (!visited[city]) {
        markConnectionDFS(city, isConnected, visited);
        ++provinces;
        }
        }
        for (int city = 0; city < ROWS; ++city) {
            if (!visited[city]) {
                markConnectionBFS(city, isConnected, visited);
                ++provinces;
            }
        }
        System.out.println("provinces= " + provinces);
        return provinces;

    }

    public static void main(String[] args) {
        LC547 solution = new LC547();
        int[][] g1 = convertStringTo2DArray("[[1,1,0],[1,1,0],[0,0,1]]");
        int[][] g2 = convertStringTo2DArray("[[1,1,0],[1,1,1],[0,0,1]]");
        int[][] g3 = convertStringTo2DArray("[[1,0,0],[0,1,0],[0,0,1]]");
        solution.findCircleNum(g1);
        solution.findCircleNum(g2);
        solution.findCircleNum(g3);
    }
}
