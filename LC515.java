import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
  class Pair<K, V>{
      private K key;
      private V val;
      public Pair(K key, V val){
          this.key =key;
          this.val =val;
      }
      public K getKey(){
return key;
      } 
      public V getVal(){
return val;
      } 

  }
public class LC515 {
    public List<Integer> largestValues(TreeNode root) {
          if(root == null) return new ArrayList<Integer>();
          List<Integer> ans = new ArrayList();
          Stack<Pair<TreeNode, Integer>> stack=  new Stack();
          stack.push(new Pair<>(root, 0));
          while(!stack.isEmpty()){
              Pair<TreeNode, Integer> curr= stack.pop();
              int depth = curr.getVal();
              TreeNode node = curr.getKey();
              
              if(depth == ans.size()) ans.add(node.val);
              else{ 
                  int prevMax= ans.get(depth);
                  if(prevMax < node.val) ans.set(depth, node.val);
              }
              if(node.right!=null) stack.push(new Pair<>(node.right, depth+1));
              if(node.left!=null) stack.push(new Pair<>(node.left, depth+1));
              
          }
          return ans;
        

    }
    public static void main(String[] args) {
        LC515 solution = new LC515();
        
    }
}
