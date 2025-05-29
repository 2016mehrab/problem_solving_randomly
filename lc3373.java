import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LC3373 {
    // create adjlist
    private void createAdjList(int[][] edges, List<Integer>[] adjlist) {
        for (int i = 0; i < edges.length + 1; ++i) {
            adjlist[i] = new ArrayList<>();
        }
        for (var edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjlist[u].add(v);
            adjlist[v].add(u);

        }
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<Integer>[] adjlist1 = new ArrayList[n];
        List<Integer>[] adjlist2 = new ArrayList[m];
        createAdjList(edges1, adjlist1);
        createAdjList(edges2, adjlist2);

        boolean[] visit = new boolean[n];
        int[] sign1 = new int[n];
        int zeroCnt = bfs(0, adjlist1, sign1, visit);
        int oneCnt = n - zeroCnt;

        boolean[] visit2 = new boolean[m];
        int[] sign2 = new int[m];
        int zeroCnt2 = bfs(0, adjlist2, sign2, visit2);
        int oneCnt2 = m - zeroCnt2;

        int maxNodes = Math.max(zeroCnt2, oneCnt2);

        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = sign1[i] == 0 ? (zeroCnt + maxNodes) : (oneCnt + maxNodes);
        }

        return ans;
    }

    private int bfs(int node, List<Integer>[] adjlist, int[] targetTree, boolean[] visit) {
        // (node, even/odd)
        Queue<int[]> q = new LinkedList<>();
        int zeroCnt = 0;
        q.add(new int[] { node, 0 });
        targetTree[node] = 0;
        visit[node] = true;
        while (!q.isEmpty()) {
            var curr = q.poll();
            zeroCnt += curr[1] == 0 ? 1 : 0;
            targetTree[curr[0]] = curr[1];
            for (var ngbr : adjlist[curr[0]]) {
                if (!visit[ngbr]) {
                    visit[ngbr] = true;
                    q.add(new int[] { ngbr, curr[1] == 0 ? 1 : 0 });
                }
            }
        }
        return zeroCnt;
    }

    public static void main(String[] args) {
        LC3373 solution = new LC3373();
        solution.maxTargetNodes(new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 } },
                new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 7 }, { 1, 4 }, { 4, 5 }, { 4, 6 } });
    }
}
