package offer;

import leetcode.struct.ListNode;

public class demo55链表中环的入口结点 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode t1 = pHead;
        ListNode t2 = pHead.next;
        if (t2 == null) return null;
        while (t2 != null) {
            t1 = t1.next;
            t2 = t2.next;
            if (t2 == null) return null;
            t2 = t2.next;
            if (t1 == t2) {

            }
        }
        return null;
    }

}
