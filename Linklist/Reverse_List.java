/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        for(int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;
        
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        return preHead;
    }
}