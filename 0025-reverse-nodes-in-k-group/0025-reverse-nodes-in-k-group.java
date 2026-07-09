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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        while(true){
            ListNode end=prev;
            for(int i=0;i<k && end!=null; i++){
                end=end.next;
            }
            if(end==null){
                break;
            }
            ListNode start=prev.next;
            ListNode nextn=end.next;
            end.next=null;
            prev.next=reverse(start);
            start.next=nextn;
            prev=start;
        }
        return dummy.next;
    }
        public ListNode reverse(ListNode head){
            ListNode prev=null;
            ListNode curr=head;
            while(curr!=null){
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            return prev;
        }
    
}