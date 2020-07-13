package offer;

import leetcode.struct.ListNode;

public class demo56删除链表中重复的结点 {

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode cur = new ListNode(-1);
        cur.next = pHead;
        pHead = cur;
        while (cur.next != null) {
            ListNode temp = cur.next;
            int count = 1;
            while (temp.next != null && temp.next.val == temp.val) {
                temp = temp.next;
                count++;
            }
            if (count == 1) cur = cur.next;
            else {
                cur.next = temp.next;
                temp.next = null;
            }
        }
        return pHead.next;
    }
}
