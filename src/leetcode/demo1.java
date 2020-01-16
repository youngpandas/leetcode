package leetcode;

import java.util.*;

public class demo1 {

    class Node implements Comparable<Node> {
        int val;
        int pos;

        Node(int a, int b) {
            val = a;
            pos = b;
        }

        @Override
        public int compareTo(Node o) {
            return val - o.val;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) nodeList.add(new Node(nums[i], i));
        Collections.sort(nodeList);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            Node nodePre = nodeList.get(i);
            Node nodePost = nodeList.get(j);
            int val = nodePre.val + nodePost.val;
            if (val == target) return new int[]{nodePre.pos, nodePost.pos};
            if (val < target) i++;
            else j--;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] res = new demo1().twoSum(new int[]{3, 2, 4}, 6);
        System.out.print(res[0] + " " + res[1]);
    }
}
