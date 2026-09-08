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
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode cur=head;
        ListNode safe=null;
        while(cur != null){
            safe=cur.next;
            cur.next=prev;
            prev=cur;
            cur=safe;
        }
        head=prev;
        return head;
        
    }
}