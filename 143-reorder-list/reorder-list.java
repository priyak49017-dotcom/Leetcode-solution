
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;

        while (curr != null) {
            ListNode safe = curr.next;
            curr.next = prev;
            prev = curr;
            curr = safe;
        }

        // Step 3: Merge both halves
        ListNode start = head;
        ListNode end = prev;

        while (end != null) {
            ListNode safeStart = start.next;
            ListNode safeEnd = end.next;

            start.next = end;
            end.next = safeStart;

            start = safeStart;
            end = safeEnd;
        }
    }
}
