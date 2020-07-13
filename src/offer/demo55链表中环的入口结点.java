package offer;

import leetcode.struct.ListNode;

import java.util.HashSet;
import java.util.Set;

public class demo55链表中环的入口结点 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode t1 = pHead;
        ListNode t2 = pHead.next;
        while (t2 != null) {
            t1 = t1.next;
            t2 = t2.next;
            if (t2 == null) break;
            t2 = t2.next;
            if (t1 == t2) {
                Set<ListNode> set = new HashSet<>();
                t1 = pHead;
                while (t1 != null) {
                    if (set.contains(t1)) return t1;
                    set.add(t1);
                    t1 = t1.next;
                }
            }
        }
        return null;
    }

}
