package leetcode;

import leetcode.struct.ListNode;
import leetcode.struct.TreeNode;

public class demo109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len += 1;
            temp = temp.next;
        }
        ListNode empty = new ListNode(-1);
        empty.next = head;
        return solve(empty, len);
    }

    public TreeNode solve(ListNode head, int len) {
        if (len == 0) return null;
        ListNode pre = head, cur = head.next;
        int mid = len >> 1;
        for (int i = 0; i < mid; i++) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(cur.val);
        root.left = solve(head, mid);
        root.right = solve(cur, len - mid - 1);
        return root;
    }

}
