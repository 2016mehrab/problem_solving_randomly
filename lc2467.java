import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class LC2467 {
    private int maxIncome;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int N = amount.length;
        ArrayList<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].add(v);
            adj[v].add(u);
        }
        // for (int i = 0; i < N; ++i) {
        // System.out.println(i + ": " + adj[i]);
        // }
        boolean[] visited = new boolean[N];
        Map<Integer, Integer> bobMap = new HashMap<>();
        bobMap.put(bob, 0);
        // start,time, map,adj ,visited
        dfs(bob, 0, bobMap, adj, visited);
        amount[bob] = 0;
        // start, time , amount,bob_map, adj,visited
        Arrays.fill(visited, false);
        // start, time , amount,bob_map, adj,visited
        mostProfitablePathImpl(0, 0, 0, amount, bobMap, adj, visited);
        System.out.println(this.maxIncome);
        return this.maxIncome;
    }

    private void mostProfitablePathImpl(int node, int time, int income, int[] amount, Map<Integer, Integer> bobMap,
            ArrayList<Integer>[] adj,
            boolean[] visited) {
        if (bobMap.containsKey(node)) {
            // alice reaches first then, 0 for alice
            if (bobMap.get(node) > time) {
                income += amount[node];
            } else if (bobMap.get(node) == time) {
                income += amount[node] / 2;
            }

        } else
            income += amount[node];

        visited[node] = true;
        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                mostProfitablePathImpl(neighbor, time + 1, income, amount, bobMap, adj, visited);
            }
        }
        // leaf node
        // if (adj[node].size() == 1 && adj[node].get(0) != 0) {
        if (adj[node].size() == 1 && node != 0) {
            if (this.maxIncome != 0) {
                this.maxIncome = Math.max(this.maxIncome, income);
            } else
                maxIncome = income;

        }

    }

    private boolean dfs(int node, int time, Map<Integer, Integer> bobMap, ArrayList<Integer>[] adj,
            boolean[] visited) {
        if (node == 0)
            return true;
        visited[node] = true;
        bobMap.put(node, time);
        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, time + 1, bobMap, adj, visited))
                    return true;
            }
        }
        bobMap.remove(node);
        return false;

    }

    public static void main(String[] args) {
        LC2467 solution = new LC2467();
        solution.mostProfitablePath(new int[][] { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3,
                4 } }, 3,
                new int[] { -2, 4, 2, -4, 6 });
        solution.mostProfitablePath(new int[][] { { 0, 1 } }, 1, new int[] { -7280,
                2350 });
        solution.mostProfitablePath(new int[][] { { 0, 1 }, { 0, 2 } }, 2, new int[] { -3360, -5394, -1146 });

    }
}
