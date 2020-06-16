package leetcode;

import leetcode.struct.TreeNode;

import java.util.*;

public class demo297 {


    public String serialize(TreeNode root) {
        List<String> res = solve1(root);
        return res.toString().replace(" ", "");
    }


    public List<String> solve1(TreeNode root) {
        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                res.add("null");
            } else {
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        int i = res.size() - 1;
        for (; i >= 0; i--) {
            if (!res.get(i).equals("null")) break;
        }
        return res.subList(0, i + 1);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.substring(1, data.length() - 1).split(" ");
        return null;
    }


    public TreeNode solve2(String[] strs) {
        if (strs.length == 1) {
            if (strs[0].equals("null")) return null;
            return new TreeNode(Integer.valueOf(strs[0]));
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(new TreeNode(Integer.valueOf(strs[0])));
        int idx = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len * 2; i++) {

            }
        }
        return null;
    }


    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        res.add("sadfsaed");
        res.add("rewr");
        System.out.println(res);
    }

}
