package leetcode;

import leetcode.struct.ListNode;

import java.util.List;

public class demo21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode last = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode temp = l1.next;
                last.next = l1;
                l1.next = null;
                last = l1;
                l1 = temp;
            } else {
                ListNode temp = l2.next;
                last.next = l2;
                l2.next = null;
                last = l2;
                l2 = temp;
            }
        }
        last.next = l1 != null ? l1 : l2;
        return head.next;
    }


}
