public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(0, 0, inorder.length - 1, preorder, inorder);
}
private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if (preStart >= preorder.length || inStart > inEnd) {
        return null;
    }
    int index = 0;
    for (int i = inStart;i <= inEnd;i++) {
        if (preorder[preStart] == inorder[i]) {
            index = i;
        }
    }
    TreeNode node = new TreeNode(preorder[preStart]);
    node.left = helper(preStart + 1, inStart, index - 1, preorder, inorder);
    node.right = helper(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);
    return node;
}