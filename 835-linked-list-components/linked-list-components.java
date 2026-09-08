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
    public int numComponents(ListNode head, int[] nums) {
        int count=0;
        while(head != null){
            if(contains(nums,head.val)){
                if(head.next == null || !contains(nums,head.next.val)){
                    count++;
                }
            }
            head=head.next;
        }
        return count;
    }
    public boolean contains(int[] nums,int value){
        for(int x:nums){
            if(x == value){
                return true;
            }
        }
        return false;
    }
}
        
    
