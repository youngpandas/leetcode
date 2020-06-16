package leetcode;

import leetcode.struct.ListNode;

import java.util.List;

public class demo86 {

    public ListNode partition(ListNode head, int x) {
        ListNode empty = new ListNode(-1);
        empty.next = head;
        head = empty;

        ListNode pre = head;
        ListNode cur = head.next;

        ListNode hs = new ListNode(-1);
        ListNode hb = new ListNode(-1);
        ListNode ls = hs;
        ListNode lb = hb;

        while (cur != null) {
            pre.next = cur.next;
            cur.next = null;
            if (cur.val < x) {
                ls.next = cur;
                ls = cur;
            } else {
                lb.next = cur;
                lb = cur;
            }
            cur = pre.next;
        }
        ls.next = hb.next;
        return hs.next;
    }

}
