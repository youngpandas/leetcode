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
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        res.add("" + root.val);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left == null) res.add("null");
            else {
                res.add(String.valueOf(temp.left.val));
                queue.offer(temp.left);
            }
            if (temp.right == null) res.add("null");
            else {
                res.add(String.valueOf(temp.right.val));
                queue.offer(temp.right);
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
        if (data.equals("[]")) return null;
        String[] strs = data.substring(1, data.length() - 1).split(",");
        return solve2(strs);
    }


    public TreeNode solve2(String[] strs) {
        if (strs.length == 1) {
            if (strs[0].equals("null")) return null;
            return new TreeNode(Integer.valueOf(strs[0]));
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        queue.offer(root);
        int idx = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                if (temp == null) continue;
                String left = idx == strs.length ? "" : strs[idx++];
                String right = idx == strs.length ? "" : strs[idx++];
                if (!left.equals("")) {
                    if (!left.equals("null")) {
                        temp.left = new TreeNode(Integer.valueOf(left));
                        queue.offer(temp.left);
                    }
                }
                if (!right.equals("")) {
                    if (!right.equals("null")) {
                        temp.right = new TreeNode(Integer.valueOf(right));
                        queue.offer(temp.right);
                    }
                }
            }
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new demo297().serialize(root));

        root = new demo297().deserialize("[1,2,3,null,null,4,5]");
        System.out.println(new demo297().serialize(root));
    }

}
