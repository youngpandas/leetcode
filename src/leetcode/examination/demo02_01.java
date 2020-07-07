package leetcode.examination;

import leetcode.struct.ListNode;

import java.util.HashSet;
import java.util.Set;

public class demo02_01 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        set.add(cur.val);
        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = null;
            } else {
                cur = cur.next;
                set.add(cur.val);
            }
        }
        return head;
    }

}
