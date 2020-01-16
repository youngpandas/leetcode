package leetcode;

import leetcode.struct.ListNode;

public class demo24 {

    public ListNode swapPairs(ListNode head) {
        ListNode zero = new ListNode(0);
        zero.next = head;
        head = zero;
        ListNode first = zero.next;
        if (first != null) {
            ListNode second = first.next;
            while (first != null && second != null) {
                first.next = second.next;
                second.next = first;
                zero.next = second;
                zero = first;
                first = zero.next;
                if (first == null) break;
                second = first.next;
            }
        }
        zero = head;
        head = zero.next;
        zero.next = null;
        return head;
    }

}
