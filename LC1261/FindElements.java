import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class FindElements {
    Set<Integer> valSet;

    public FindElements(TreeNode root) {
        valSet = new HashSet<>();
        purify(0, root);

    }

    private void dfs(int curr, TreeNode root) {
        if (root == null)
            return;
        root.val = curr;
        valSet.add(curr);
        if (root.left != null)
            dfs(2 * curr + 1, root.left);
        if (root.right != null)
            dfs(2 * curr + 2, root.right);

    }

    private void bfs(int curr, TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        root.val = curr;

        while (!q.isEmpty()) {
            var currNode = q.poll();
            valSet.add(currNode.val);
            if (currNode.left != null) {
                currNode.left.val = currNode.val * 2 + 1;
                q.add(currNode.left);
            }
            ;
            if (currNode.right != null) {
                currNode.right.val = currNode.val * 2 + 2;
                q.add(currNode.right);
            }
            ;
        }

    }

    private void purify(int curr, TreeNode root) {
        // dfs(0, root);
        bfs(0, root);
    }

    public boolean find(int target) {
        return valSet.contains(target);
    }
}
