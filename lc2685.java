import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class LC2685 {
    private void union(int u, int v, int[] parent, int[] sizes) {
        int par_u = find(u, parent);
        int par_v = find(v, parent);
        if (par_v == par_u)
            return;
        if (sizes[par_u] >= sizes[par_v]) {
            parent[par_v] = par_u;
            sizes[par_u] += sizes[par_v];
        } else {
            parent[par_u] = par_v;
            sizes[par_v] += sizes[par_u];

        }
    }

    private int find(int node, int[] parent) {
        if (parent[node] == node)
            return node;
        return parent[node] = find(parent[node], parent);
    }

    public int countCompleteComponents(int n, int[][] edges) {
        int r = 0;
        int[] parents = new int[n];
        int[] sizes = new int[n];
        int[] edgeCnt = new int[n];

        for (int i = 0; i < n; ++i) {
            parents[i] = i;
            sizes[i] = 1;
        }

        for (var edge : edges) {
            int u = edge[0];
            int v = edge[1];
            union(u, v, parents, sizes);
        }

        for (var edge : edges) {
            int u = edge[0];
            int par = find(u, parents);
            edgeCnt[par] += 1;
        }
        for (int i = 0; i < n; ++i) {
            if (parents[i] == i) {
                int v = sizes[i];
                if (v * (v - 1) / 2 == edgeCnt[i])
                    ++r;
            }
        }

        return r;
    }

    public int countCompleteComponentsForBfsDfs(int n, int[][] edges) {
        int r = 0;
        List<Integer> adj[] = new ArrayList[n];

        for (int i = 0; i < n; ++i)
            adj[i] = new ArrayList<>();
        for (var edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                int[] v = new int[1];
                int[] e = new int[1];
                dfs(i, adj, visited, v, e);
                if (v[0] * (v[0] - 1) / 2 == e[0] / 2) {
                    ++r;
                }
            }
        }
        return r;
    }

    private void dfs(int node, List<Integer> adj[], boolean[] visited, int[] v, int[] e) {
        Stack<Integer> st = new Stack<>();
        st.add(node);
        visited[node] = true;
        while (!st.isEmpty()) {
            var curr = st.pop();
            ++v[0];
            for (var ngbr : adj[curr]) {
                ++e[0];
                if (!visited[ngbr]) {
                    visited[ngbr] = true;
                    st.add(ngbr);
                }
            }

        }

    }

    private void bfs(int node, List<Integer> adj[], boolean[] visited, int[] v, int[] e) {
        visited[node] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        while (!q.isEmpty()) {
            var curr = q.poll();
            ++v[0];
            for (int ngbr : adj[curr]) {
                ++e[0];
                if (!visited[ngbr]) {
                    visited[ngbr] = true;
                    q.add(ngbr);
                }
            }
        }

    }

    public static void main(String[] args) {
        LC2685 solution = new LC2685();
        solution.countCompleteComponents(6, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } });
        solution.countCompleteComponents(6, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 }, { 3, 5 } });

    }
}
