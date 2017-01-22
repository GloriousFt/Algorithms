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

* 链表分割 (Partition List)

### Partition List

[Leetcode Partition List](https://leetcode.com/problems/partition-list/)

Given a linked list and a value `x`, partition it such that all nodes less than `x` come before nodes greater than or equal to `x`.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given `1->4->3->2->5->2` and `x = 3`,
return `1->2->2->4->3->5`.

思路:

链表分割的要求有很多种,这里是根据给定值来进行分割。
用两个指针分别记录小于`x`的链表和大于等于`x`的链表。最后再把两个链表合并成一个。
需要注意的是考虑到循环链表的情况,比如`head`的链表是`[2,1]`,`x = 2`。那么在两个链表合并后将会出现循环链表,因此直接将第二个链表的`next`置`null`就可以了。

```java
public ListNode partition(ListNode head, int x) {
    ListNode lessList = new ListNode(0);
    ListNode greaterList = new ListNode(0);
    ListNode p = head, pLess = lessList, pGreater = greaterList;
    while (p != null) {
        if (p.val < x) {
            pLess.next = p;
            pLess = pLess.next;
        } else {
            pGreater.next = p;
            pGreater = pGreater.next;
        }
        p = p.next;
    }
    //avoid the cycle in link-list
    pGreater.next = null;
    pLess.next = greaterList.next;
    return lessList.next;
}
```