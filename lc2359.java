import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LC2359 {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int N = edges.length;
        List<Integer>[] adjlist = new ArrayList[N];

        for (int i = 0; i < N; ++i) {
            adjlist[i] = new ArrayList<>();
            if (edges[i] != -1)
                adjlist[i].add(edges[i]);

        }

        // create distance array from both nodes
        int[] dist1 = new int[N];
        Arrays.fill(dist1, -1);
        int[] dist2 = new int[N];
        Arrays.fill(dist2, -1);
        // get distance from node1 to all nodes
        bfs(node1, adjlist, dist1);
        bfs(node2, adjlist, dist2);

        int res = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < N; ++i) {
            if (dist1[i] == -1 || dist2[i] == -1)
                continue;
            if (res > Math.max(dist1[i], dist2[i])) {
                res = Math.max(dist1[i], dist2[i]);
                minIdx = i;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : minIdx;

    }

    private void bfs(int node, List<Integer>[] adj, int[] dist) {
        boolean[] visit = new boolean[adj.length];
        // (node, distance)
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { node, 0 });
        visit[node] = true;
        while (!q.isEmpty()) {
            // get the curr
            var curr = q.poll();
            var n = curr[0];
            var distance = curr[1];
            dist[n] = distance;
            for (var ngbr : adj[n]) {
                if (!visit[ngbr]) {
                    q.add(new int[] { ngbr, distance + 1 });
                    visit[ngbr] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        LC2359 solution = new LC2359();
        solution.closestMeetingNode(new int[] { 2, 2, 3, -1 }, 0, 2);
    }
}
