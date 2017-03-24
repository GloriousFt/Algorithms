public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    TreeNode cur = root;
    if (cur == null) {
        return result;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    while (cur != null || !stack.isEmpty()) {
        while (cur != null) {
        stack.push(cur);
            cur = cur.left;
            }
        cur = stack.pop();
        result.add(cur.val);
        cur = cur.right;
    }
    return result;
}