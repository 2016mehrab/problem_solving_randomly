  public class TreeNode {
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
class LC2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
       if(root ==null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level =0;
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();
            for(int i =0; i< levelSize ;++i){
                TreeNode n= q.poll();
                currentLevelNodes.add(n);
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            if(level%2 == 1){
                int left= 0;
                int right = currentLevelNodes.size()-1;
                while(left < right){
                    int tmp = currentLevelNodes.get(left) .val;
    currentLevelNodes.get(left).val = currentLevelNodes.get(
                            right
                        ).val;
                    currentLevelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            ++level;
        }
        return root;

    }
    public static void main(String[] args) {
        LC2415 solution = new LC2415();
        
    }
}
