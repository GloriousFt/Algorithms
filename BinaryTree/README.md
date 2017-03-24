## Binary Tree(二叉树)

二叉树的遍历是解决一切问题的关键,递归方法与利用栈和队列可以完成二叉树的遍历。

层次遍历(广度优先)可以利用队列来完成。
前中后序可以利用栈来完成。

二叉树的构建序列只有:中序前序和中序后序,前序和后序的构建二叉树不唯一。

关键: 队列和栈

常见的问题:

### 二叉树遍历,中序

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

### 二叉树遍历,前序

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

### 二叉树遍历,层次

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

### 二叉树构建,前序和中序

从前序序列和中序序列来构建二叉树,主要思路就是重复这样一个过程:

1. 在前序中找到当前序列的第一个节点,它一定是根节点。

2. 在中序序列中找到这个节点,因此得到了以该节点为中心的两个子序列。

3. 该节点左边的序列一定是它的左子树的中序序列,右边的序列一定是它的右子树的中序序列。

4. 再依次对这两个序列进行1步骤中的操作。

可以看出来,这就是一个递归方法。

[Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

```java
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
```

### 二叉树构建,中序和后序

中序和后序构建二叉树与上一个方法非常相近。

1. 在后序序列中查找当前序列的最后一个节点,它一定是根节点。

2. 在中序序列中找到该节点,左边的序列就是它的左子树,右边的序列是它的右子树。

3. 然后把这两个序列分别进行1步骤的操作。

同样是用递归来解决

```java
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
```