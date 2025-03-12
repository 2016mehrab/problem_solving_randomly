import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class LC1028 {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int index = 0, n = traversal.length();

        while (index < n) {
            int depth = 0;
            while (index < n && traversal.charAt(index) == '-') {
                ++depth;
                ++index;
            }

            int value = 0;
            while (index < n && Character.isDigit(traversal.charAt(index))) {
                value = value * 10 + Character.getNumericValue(traversal.charAt(index));
                ++index;
            }
            TreeNode node = new TreeNode(value);
            while (stack.size() > depth) {
                stack.pop();
            }
            if (depth > 0) {
                TreeNode parent = stack.peek();
                if (parent.left == null)
                    parent.left = node;
                else
                    parent.right = node;
            }
            stack.push(node);
        }

        return stack.get(0);
    }

    public static void main(String[] args) {
        LC1028 solution = new LC1028();
        solution.recoverFromPreorder("1-2--3--4-5--6--7");
        solution.recoverFromPreorder("1-2--3---4-5--6---7");
        solution.recoverFromPreorder("1-401--349---90--88");

    }
}
