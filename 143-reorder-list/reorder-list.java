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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        ListNode curr=slow;
        while(curr != null){
            ListNode safe=curr.next;
            curr.next=prev;
            prev=curr;
            curr=safe;
        }
        ListNode start=head;
        ListNode end=prev;
        while(end.next != null){
            ListNode safe_start=start.next;
            ListNode safe_end=end.next;
            start.next=end;
            start=safe_start;
            end.next=safe_start;
            end=safe_end;
        }
    }
}