public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null) {
        return result;
    }
    queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0;i < size;i++) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            list.add(node.val);
        }
        result.add(list);
    }
    return result;
}