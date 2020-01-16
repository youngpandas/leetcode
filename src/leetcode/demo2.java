package leetcode;

import leetcode.struct.ListNode;

public class demo2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLen(l1), len2 = getLen(l2);
        if (len1 < len2) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        int pre = 0;
        ListNode temp = l1;
        while (l2 != null) {
            int val = temp.val + l2.val + pre;
            pre = val / 10;
            temp.val = val % 10;
            temp = temp.next;
            l2 = l2.next;
        }

        while (temp != null) {
            int val = temp.val + pre;
            pre = val / 10;
            temp.val = val % 10;
            temp = temp.next;
        }

        if (pre != 0) {
            temp = l1;
            while (temp.next != null) temp = temp.next;
            temp.next = new ListNode(pre);
        }
        return l1;
    }

    public int getLen(ListNode node) {
        int len = 0;
        ListNode temp = node;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static void main(String[] args) {

    }
}
