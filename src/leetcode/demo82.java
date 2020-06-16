package leetcode;

import leetcode.struct.ListNode;

public class demo82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode empty = new ListNode(-1);
        empty.next = head;
        ListNode pre = empty, post = head;
        while (post != null) {
            if (post.next == null) break;
            if (post.next.val == post.val) {
                ListNode temp = post.next;
                while (temp != null && temp.val == post.val) {
                    temp = temp.next;
                }
                pre.next = temp;
                post = temp;
            } else {
                pre = post;
                post = post.next;
            }
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.val + ",");
                temp = temp.next;
            }
            System.out.println();

        }
        return pre.next;
    }

    public static void main(String[] args) {

    }
}
