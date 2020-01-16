package leetcode;


public class demo430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if (head == null) return null;
        Node temp = head;
        while (temp != null) {
            if (temp.child != null) break;
            temp = temp.next;
        }
        if (temp == null) return head;
        Node child = flatten(temp.child);
        Node next = flatten(temp.next);
        temp.child = null;
        temp.next = child;
        child.prev = temp;
        if (next != null) {
            temp = child;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = next;
            next.prev = temp;
        }
        return head;
    }

}
