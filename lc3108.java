class LC3108 {
    int find(int u, int[] parent) {
        if (parent[u] == u)
            return u;
        return parent[u] = find(parent[u], parent);
    }

    void Union(int x, int y, int[] parent) {
        parent[y] = x;
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {

        int[] parent = new int[n];
        int[] cost = new int[n];

        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            cost[i] = -1;
        }
        for (var edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int parent_u = find(u, parent);
            int parent_v = find(v, parent);
            if (parent_u != parent_v) {
                Union(parent_u, parent_v, parent);
                cost[parent_u] &= cost[parent_v];
            }
            cost[parent_u] &= edge[2];
        }
        int[] res = new int[query.length];
        int j = 0;
        for (var q : query) {
            int parent_0 = find(q[0], parent);
            int parent_1 = find(q[1], parent);
            if (q[0] == q[1]) {
                res[j++] = 0;
            } else if (parent_0 != parent_1) {
                res[j++] = -1;
            } else
                res[j++] = cost[parent_1];
        }

        return res;
    }

    public static void main(String[] args) {
        LC3108 solution = new LC3108();

    }
}
