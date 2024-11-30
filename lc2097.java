import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class LC2097 {
    private void dfs(int start, Map<Integer, Deque<Integer>> adj, ArrayList<Integer> path) {
        Deque<Integer> neighbors = adj.get(start);
        while (neighbors != null && !neighbors.isEmpty()) {
            int neighbor = neighbors.pollFirst();
            dfs(neighbor, adj, path);
        }
        path.add(start);
        return;
    }

    public int[][] validArrangement(int[][] pairs) {
        int N = pairs.length;
        int[][] result = new int[N][2];
        Map<Integer, Deque<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            adj.putIfAbsent(pairs[i][0], new ArrayDeque());
            adj.get(pairs[i][0]).add(pairs[i][1]);
            outdegree.put(pairs[i][0], outdegree.getOrDefault(pairs[i][0], 0) + 1);
            indegree.put(pairs[i][1], indegree.getOrDefault(pairs[i][1], 0) + 1);

        }
        System.out.println("outdegree" + outdegree);
        System.out.println("indegree" + indegree);
        int startingNode = pairs[0][0];
        for (int i = 0; i < N; ++i) {
            int outcmp = outdegree.containsKey(pairs[i][0]) ? outdegree.get(pairs[i][0]).intValue() : 0;
            int incmp = indegree.containsKey(pairs[i][0]) ? indegree.get(pairs[i][0]).intValue() : 0;
            if (outcmp - incmp == 1) {
                startingNode = pairs[i][0];
            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        dfs(startingNode, adj, path);
        System.out.println("path -> " + path);
        Collections.reverse(path);
        System.out.println("after rev path -> " + path);
        for (int i = 0; i < path.size() - 1; ++i) {
            result[i][0] = path.get(i);
            result[i][1] = path.get(i + 1);
        }
        printMatrix(result);

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

    public static void main(String[] args) {
        LC2097 s = new LC2097();

        int[][] arr = { { 5, 1 }, { 4, 5 }, { 11, 9 }, { 9, 4 } };
        int[][] arr2 = { { 1, 3 }, { 3, 2 }, { 2, 1 } };
        int[][] arr3 = { { 1, 2 }, { 1, 3 }, { 2, 1 } };
        s.validArrangement(arr);
        s.validArrangement(arr2);
        s.validArrangement(arr3);

    }
}
