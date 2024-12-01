import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

class LC332 {
    // post-order dfs
    private void dfs(String node, Map<String, PriorityQueue<String>> adj, List<String> visited) {
        while (adj.containsKey(node) && !adj.get(node).isEmpty()) {
            dfs(adj.get(node).poll(), adj, visited);
        }
        visited.add(node);
        return;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (int i = 0; i < tickets.size(); ++i) {
            String src = tickets.get(i).get(0);
            String dest = tickets.get(i).get(1);
            adj.putIfAbsent(src, new PriorityQueue());
            adj.get(src).add(dest);
        }
        List<String> itinerary = new ArrayList<>();
        dfs("JFK", adj, itinerary);
        Collections.reverse(itinerary);
        return itinerary;
    }

    public static void main(String[] args) {
        LC332 solution = new LC332();
        String[][] t_1 = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };

        String[][] t_2 = { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "SFO" }, { "ATL", "JFK" } };
        String[][] t_3 = { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };

        List<List<String>> t1 = Arrays.stream(t_1).map(Arrays::asList).toList();
        List<List<String>> t2 = Arrays.stream(t_2).map(Arrays::asList).toList();
        List<List<String>> t3 = Arrays.stream(t_3).map(Arrays::asList).toList();
        solution.findItinerary(t1);
        solution.findItinerary(t2);
        solution.findItinerary(t3);
    }
}
