package test;

public class demo3 {


    public static void main(String[] args) {
        Node node = new Node() {
            @Override
            public int test() {
                return super.test();
            }
        };

        System.out.println(node.test());

        Node1 node1 = new Node1();
        System.out.println(node1.test());

        Node2 node2 = new Node2();
        System.out.println(node2.test());
    }
}
