package test;

// 数组 + 链表，访问效率对比
public class demo2 {

    static class Item {
        int val;

        Item(int val) {
            this.val = val;
        }
    }

    static class Node {
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(null);
        Node last = head;
        int[] nums = new int[10000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 1000000);
        }
        for (int i = 0; i < nums.length; i++) {
            Node temp = new Node(new Item(nums[i]));
            last.next = temp;
            last = temp;
        }
        Item[] list = new Item[10000000];
        for (int i = 0; i < nums.length; i++) {
            list[i] = new Item(nums[i]);
        }

        double t1, t2;

        last = head.next;
        t1 = System.currentTimeMillis();
        while (last != null) {
            Item item = last.item;
            item.val++;
            last = last.next;
        }
        t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

        t1 = System.currentTimeMillis();
        for (int i = 0; i < nums.length; i++) {
            list[i].val++;
        }
        t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}
