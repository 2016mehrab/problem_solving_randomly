import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
public class LC2471 {
    private int getRequiredSwaps(int[] original){
        int N =original.length;
        int swaps =0;
        int[] sorted = original.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> pos= new HashMap<>();
        for(int i=0; i< N; ++i){
            pos.put(original[i],i);
        }
// 1, 2, 3, 4
// 4, 3, 2 ,1
// 4, 3, 2 ,4
        for(int i = 0 ; i<N;++i){
            if(original[i] != sorted[i]) ++swaps;
            int tmp= pos.get(sorted[i]);
            pos.put(original[i],tmp );
            original[tmp] =original[i];
        }
        return swaps;

    }
        public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int totalSwaps = 0;

        // Process tree level by level using BFS
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int[] levelValues = new int[levelSize];

            // Store values of current level and add children to queue
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelValues[i] = node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Add minimum swaps needed for current level
            totalSwaps += getRequiredSwaps(levelValues);
        }
        return totalSwaps;
    }
    public static void main(String[] args) {
        LC2471 solution = new LC2471();
        
    }
}
