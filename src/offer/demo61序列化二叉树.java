package offer;

import leetcode.struct.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class demo61序列化二叉树 {

    String Serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean tag = false;
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp == null) sb.append("#");
                else {
                    sb.append(temp.val);
                    q.offer(temp.left);
                    q.offer(temp.right);
                    if (temp.left != null) tag = true;
                    if (temp.right != null) tag = true;
                }
                sb.append(",");
            }
            if (!tag) break;
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if (str.isEmpty()) return null;
        String[] values = str.substring(0, str.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int len = 1;
        while (len < values.length) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp == null) continue;
                String val = values[len++];
                TreeNode left = val.equals("#") ? null : new TreeNode(Integer.valueOf(val));
                val = values[len++];
                TreeNode right = val.equals("#") ? null : new TreeNode(Integer.valueOf(val));
                temp.left = left;
                temp.right = right;
                q.offer(left);
                q.offer(right);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        String res = new demo61序列化二叉树().Serialize(root);
        System.out.println(res);
        System.out.println(new demo61序列化二叉树().Serialize(new demo61序列化二叉树().Deserialize(res)));
    }

}
