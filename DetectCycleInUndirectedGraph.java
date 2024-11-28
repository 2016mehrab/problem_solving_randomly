import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

class DetectCycleInUndirectedGraph {
        private boolean hasCycleBFS(int node, ArrayList<Integer>[] adj, boolean[] visited) {
                Queue<ArrayList<Integer>> q = new ArrayDeque<>();
                q.add(new ArrayList<Integer>(Arrays.asList(node, -1)));
                visited[node] = true;
                while (!q.isEmpty()) {
                        ArrayList<Integer> currPair = q.poll();
                        for (int neighbor : adj[currPair.get(0)]) {
                                if (neighbor == currPair.get(1))
                                        continue;
                                if (visited[neighbor]) {
                                        return true;
                                }
                                visited[neighbor] = true;
                                q.add(new ArrayList<Integer>(Arrays.asList(neighbor, currPair.get(0))));
                        }

                }
                return false;
        }

        private boolean hasCycleDFS(int current, int parent, ArrayList<Integer>[] adj, boolean[] visited) {
                visited[current] = true;
                for (int neighbor : adj[current]) {
                        if (neighbor == parent)
                                continue;
                        if (visited[neighbor])
                                return true;
                        if (hasCycleDFS(neighbor, current, adj, visited)) {
                                return true;
                        }
                }

                return false;
        }

        private boolean hasCycle(int vertices, ArrayList<Integer>[] adj) {

                boolean[] visited = new boolean[vertices];
                for (int i = 0; i < vertices; ++i) {
                        // if (!visited[i] && hasCycleDFS(i, -1, adj, visited)) {
                        //         return true;
                        // }
                        if (!visited[i] && hasCycleBFS(i,  adj, visited)) {
                                return true;
                        }
                }
                return false;
        }

        public static void main(String[] args) {
                DetectCycleInUndirectedGraph obj = new DetectCycleInUndirectedGraph();

                int vertices1 = 4;
                ArrayList<Integer>[] adj1 = new ArrayList[vertices1];
                for (int i = 0; i < vertices1; i++) {
                        adj1[i] = new ArrayList<>();
                }
                adj1[0].add(1);
                adj1[1].add(0);
                adj1[1].add(2);
                adj1[2].add(1);
                adj1[2].add(3);
                adj1[3].add(2);
                System.out.println("Test Case 1 (No Cycle): " + obj.hasCycle(vertices1, adj1)); // Expected: false

                // Test Case 2: Graph with a single cycle
                int vertices2 = 3;
                ArrayList<Integer>[] adj2 = new ArrayList[vertices2];
                for (int i = 0; i < vertices2; i++) {
                        adj2[i] = new ArrayList<>();
                }
                adj2[0].add(1);
                adj2[1].add(0);
                adj2[1].add(2);
                adj2[2].add(1);
                adj2[2].add(0);
                adj2[0].add(2);
                System.out.println("Test Case 2 (Cycle Exists): " + obj.hasCycle(vertices2, adj2)); // Expected: true

                // Test Case 3: Disconnected graph with a cycle in one component
                int vertices3 = 6;
                ArrayList<Integer>[] adj3 = new ArrayList[vertices3];
                for (int i = 0; i < vertices3; i++) {
                        adj3[i] = new ArrayList<>();
                }
                adj3[0].add(1);
                adj3[1].add(0);
                adj3[2].add(3);
                adj3[3].add(2);
                adj3[3].add(4);
                adj3[4].add(3);
                adj3[4].add(5);
                adj3[5].add(4);
                adj3[5].add(3);
                adj3[3].add(5);
                System.out.println("Test Case 3 (Disconnected with Cycle): " + obj.hasCycle(vertices3, adj3)); // Expected:
                                                                                                               // true

                // Test Case 4: Complete graph (cycle guaranteed)
                int vertices4 = 4;
                ArrayList<Integer>[] adj4 = new ArrayList[vertices4];
                for (int i = 0; i < vertices4; i++) {
                        adj4[i] = new ArrayList<>();
                }
                for (int i = 0; i < vertices4; i++) {
                        for (int j = i + 1; j < vertices4; j++) {
                                adj4[i].add(j);
                                adj4[j].add(i);
                        }
                }
                System.out.println("Test Case 4 (Complete Graph): " + obj.hasCycle(vertices4, adj4)); // Expected: true

                // Test Case 5: Single vertex, no edges
                int vertices5 = 1;
                ArrayList<Integer>[] adj5 = new ArrayList[vertices5];
                for (int i = 0; i < vertices5; i++) {
                        adj5[i] = new ArrayList<>();
                }
                System.out.println("Test Case 5 (Single Vertex): " + obj.hasCycle(vertices5, adj5)); // Expected: false

                // Test Case 6: Two vertices, one edge
                int vertices6 = 2;
                ArrayList<Integer>[] adj6 = new ArrayList[vertices6];
                for (int i = 0; i < vertices6; i++) {
                        adj6[i] = new ArrayList<>();
                }
                adj6[0].add(1);
                adj6[1].add(0);
                System.out.println("Test Case 6 (Two Vertices, No Cycle): " + obj.hasCycle(vertices6, adj6)); // Expected:
                                                                                                              // false
        }
}
