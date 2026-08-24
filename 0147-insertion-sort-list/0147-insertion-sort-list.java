/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Dummy node helps handle insertions at the head easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode lastSorted = head; // Last node of the sorted portion
        ListNode curr = head.next;  // Node to be inserted

        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                // Node is already in the correct position
                lastSorted = lastSorted.next;
            } else {
                // Find the correct position to insert curr
                ListNode prev = dummy;
                while (prev.next.val < curr.val) {
                    prev = prev.next;
                }

                // Insert curr between prev and prev.next
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            // Advance to the next unsorted node
            curr = lastSorted.next;
        }

        return dummy.next;
    }
}
