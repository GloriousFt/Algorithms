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
    
    public ListNode deleteDuplicates2(ListNode head) {
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
}