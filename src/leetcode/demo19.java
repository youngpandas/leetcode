package leetcode;

import leetcode.struct.ListNode;

import java.util.List;

public class demo19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode empty = new ListNode(0);
        empty.next = head;

        ListNode post = empty;
        for (int i = 0; i < n; i++) {
            post = post.next;
        }

        ListNode pre = empty;
        while (post.next != null) {
            post = post.next;
            pre = pre.next;
        }

        if (pre.next != null) {
            ListNode temp = pre.next;
            pre.next = temp.next;
            temp.next = null;
        }

        head = empty.next;
        empty.next = null;
        return head;
    }

}
