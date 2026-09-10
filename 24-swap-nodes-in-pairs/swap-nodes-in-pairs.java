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
    public ListNode swapPairs(ListNode head) {
        // if(head == null || head.next == null){
        //     return head;
        // }
        // ListNode curr=head;
        // head=head.next;
        // ListNode prev=null;
        // while(curr != null && curr.next != null){
        //     ListNode safe=curr.next;
        //     curr.next=curr.next.next;
        //     safe.next=curr;
        //     if(prev != null){
        //         prev.next=safe;
        //     }  
        //     prev=curr;
        //     curr=curr.next;  
        // }
        // return head;
        if(head == null || head.next == null){
            return head;
        }
        ListNode first=head;
        ListNode second=head.next;
        first.next=swapPairs(second.next);
        second.next=first;
        return second;

        
    }
}