## Linklist(链表相关算法)

链表是非常常用的一种数据结构,涉及链表操作的算法非常多,一些特殊的链表操作算法能让效率提高很多。

常见的问题:

* 链表去重 (Remove Duplicates)

### Remove Duplicates from Link List

[Leetcode Remove Duplicates from Link List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given `1->1->2`, return `1->2`.
Given `1->1->2->3->3`, return `1->2->3`.

思路:

用两个指针来记录操作位置,一个指针指向遍历的当前位置,一个指针指向最终修改链表的尾。
每次遍历先找到重复节点的最后一个节点,然后把这个节点放到最终修改链表的尾,再修改两个指针的位置。

时间复杂度o(n)。

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode p = result;
        ListNode q = head;
        p.next = q;
        while (q != null) {
            while (q.next != null && q.val == q.next.val) {
                q = q.next;
            }
            if (p.next != q) {
                p.next = q;
            } else {
                p = p.next;
                q = q.next;
            }
        }
        return result.next;
    }
}
```

### Remove Duplicates from Link List 2

[Leetcode Remove Duplicates from Link List 2](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given `1->2->3->3->4->4->5`, return `1->2->5`.
Given `1->1->1->2->3`, return `2->3`.

思路:

不同于上面的,去重要求不留下重复的,但是整体思路不变,只是指针的位置操作有所不同。

```java
public ListNode deleteDuplicates(ListNode head) {
    ListNode result = new ListNode(0);
    ListNode p = result;
    ListNode q = head;
    p.next = q;
    while (q != null) {
        while (q.next != null && q.val == q.next.val) {
            q = q.next;
        }
        if (p.next != q) {
            p.next = q.next;
            q = p.next;
        } else {
            p = p.next;
            q = q.next;
        }
    }
    return result.next;
}
```