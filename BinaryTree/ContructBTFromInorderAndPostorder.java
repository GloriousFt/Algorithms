public TreeNode buildTree(int[] inorder, int[] postorder) {
    return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
}
private TreeNode helper(int postStart, int inStart, int inEnd, int[] inorder, int[] postorder) {
    if (postStart < 0 || inStart > inEnd) {
        return null;
    }
    int index = 0;
    for (int i = inStart;i <= inEnd;i++) {
        if (inorder[i] == postorder[postStart]) {
            index = i;
            break;
        }
    }
    TreeNode node = new TreeNode(postorder[postStart]);
    node.left = helper(postStart - inEnd + index - 1, inStart, index - 1, inorder, postorder);
    node.right = helper(postStart - 1, index + 1, inEnd, inorder, postorder);
    return node;
}