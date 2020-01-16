package leetcode;

import leetcode.struct.ListNode;

import java.util.List;

public class demo23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode last = head;

        while (!isEmpty(lists)) {
            int idx = findMinValIndex(lists);
            ListNode e = lists[idx];
            lists[idx] = e.next;
            e.next = null;
            last.next = e;
            last = e;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }


    public int findMinValIndex(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            ListNode e = lists[i];
            if (min > e.val) {
                res = i;
                min = e.val;
            }
        }
        return res;
    }


    public boolean isEmpty(ListNode[] lists) {
        for (ListNode e : lists) {
            if (e != null) return false;
        }
        return true;
    }

}
