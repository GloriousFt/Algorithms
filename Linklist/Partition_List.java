/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
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
        // avoid cycle in link-list!
        pGreater.next = null;
        pLess.next = greaterList.next;
        return lessList.next;
    }
}