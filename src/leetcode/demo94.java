package leetcode;

import leetcode.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class demo94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode[] stack = new TreeNode[100];
        int len = 0;
        while (root != null) {
            stack[len++] = root;
            root = root.left;
        }

        List<Integer> res = new ArrayList<>();
        while (len != 0) {
            TreeNode temp = stack[--len];
            res.add(temp.val);
            if (temp.right != null) {
                root = temp.right;
                while (root != null) {
                    stack[len++] = root;
                    root = root.left;
                }
            }
        }
        return res;
    }

}
