package leetcode;

import leetcode.struct.ListNode;

import java.util.List;

public class demo61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = getLen(head);
        if (k == len) return head;
        k = len - k % len;
        ListNode pos = head;
        for (int i = 0; i < k - 1; i++) {
            pos = pos.next;
        }
        ListNode temp = pos;
        pos = temp.next;
        temp.next = null;
        temp = pos;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.println(len);
        temp.next = head;
        return pos;
    }

    public int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

}
