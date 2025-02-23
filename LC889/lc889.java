class LC889 {
    private TreeNode constructFromPrePostImpl(int preStart, int preEnd, int postStart, int[] preorder,
            int[] postorder) {
        if (preStart == preEnd)
            return new TreeNode(preorder[preStart]);
        if (preStart > preEnd)
            return null;
        TreeNode r = new TreeNode(preorder[preStart]);
        int leftSubtreeStartIdx = -1;
        for (int i = postStart; i < postorder.length; ++i) {
            if (postorder[i] == preorder[preStart + 1]) {
                leftSubtreeStartIdx = i;
                break;
            }
        }
        int rightSubtreeIdx = preStart + 1 + leftSubtreeStartIdx - postStart + 1;

        r.left = constructFromPrePostImpl(preStart + 1, rightSubtreeIdx - 1, postStart, preorder, postorder);
        r.right = constructFromPrePostImpl(rightSubtreeIdx, preEnd, leftSubtreeStartIdx + 1, preorder,
                postorder);
        return r;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePostImpl(0, preorder.length - 1, 0, preorder, postorder);

    }

    public static void main(String[] args) {
        LC889 solution = new LC889();
        solution.constructFromPrePost(new int[] { 2, 1 }, new int[] { 1, 2 });
        solution.constructFromPrePost(new int[] { 1, 2, 4, 5, 3, 6, 7 }, new int[] { 4, 5, 2, 6, 7, 3, 1 });

    }
}
