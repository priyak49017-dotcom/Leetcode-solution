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
    public ListNode partition(ListNode head, int x) {
        ListNode res=new ListNode(0);
        ListNode list1=res;
        ListNode  res2= new ListNode(0);
        ListNode list2=res2;
        while(head != null){
            if(head.val < x){
                list1.next=head;
                list1=list1.next;
            }else{
                list2.next=head;
                list2=list2.next;
            }
            head=head.next;
        }
        list2.next=null;
        //list2=res2.next;
        list1.next=res2.next;
        return res.next;
        
    }
}