package leetcode;

import leetcode.struct.ListNode;

import java.util.List;

public class demo234 {


    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        boolean tag = len % 2 == 1;
        len /= 2;

        ListNode q = new ListNode(-1);
        temp = q;
        q = head;
        head = temp;

        ListNode rHead = new ListNode(-1);
        for (int i = 0; i < len; i++) {
            temp.next = q.next;
            q.next = rHead.next;
            rHead.next = q;
            q = temp.next;
        }
        if (tag) {
            q = q.next;
        }
        rHead = rHead.next;
        for (int i = 0; i < len; i++) {
            if (q.val != rHead.val) {
                return false;
            }
            q = q.next;
            rHead = rHead.next;
        }
        return true;
    }


}
