public TreeNode sortedArrayToBST(int[] nums) {
    return helper(0, nums.length - 1, nums);
}
private TreeNode helper (int start, int end, int[] nums) {
    if (start > end) {
        return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = helper(start, mid - 1, nums);
    node.right = helper(mid + 1, end, nums);
    return node;
}