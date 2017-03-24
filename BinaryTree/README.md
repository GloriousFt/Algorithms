## Binary Tree(二叉树)

二叉树的遍历是解决一切问题的关键,递归方法与利用栈和队列可以完成二叉树的遍历。

层次遍历(广度优先)可以利用队列来完成。
前中后序可以利用栈来完成。

关键: 队列和栈

常见的问题:

* 二叉树遍历,中序

[Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal)

中序遍历的思路是,先把当前节点放入栈中,然后一直找到其最左节点,然后开始出栈,操作当前出栈节点,然后再向其右节点遍历,以此循环。

```java
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
```

* 二叉树遍历,前序

[Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal)

前序的思路跟中序很像,同样是用栈来辅助遍历,每次访问操作从栈中pop出的当前节点,然后将其右节点先入栈,再将其左节点入栈(栈的特性:先入后出),以此循环,只要栈不为空。

```java
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if (root == null) {
        return result;
    }
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.add(node.val);
        if (node.right != null) {
            stack.push(node.right);
        }
        if (node.left != null) {
            stack.push(node.left);
        }
    }
    return result;
}
```

* 二叉树遍历,层次

层次遍历需要的是"先入先出"的特性,这与队列的特性是刚好相同的,所以层次遍历可以用队列来辅助。

先把根节点入队列,只要队列不为空,每次从队列中取出一个节点,再把它的左右子树节点分别按序入队。为了区分层次关系,还可以利用队列长度来判断哪些节点属于哪一层。

[Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

```java
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
```

