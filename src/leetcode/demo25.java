package leetcode;

import leetcode.struct.ListNode;

import java.util.List;

public class demo25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode empty = new ListNode(0);
        empty.next = head;
        ListNode pre = empty;
        int len = getLen(head);
        int step = len / k;
        for (int i = 0; i < step; i++) {
            pre = reverse(pre, k);
        }
        head = empty.next;
        empty.next = null;
        return head;
    }

    public ListNode reverse(ListNode pre, int k) {
        ListNode head = new ListNode(0);
        for (int i = 0; i < k; i++) {
            ListNode post = pre.next;
            pre.next = post.next;
            post.next = head.next;
            head.next = post;
        }
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = pre.next;
        pre.next = head.next;
        head.next = null;
        return last;
    }

    public int getLen(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }

}
