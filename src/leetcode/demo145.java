package leetcode;

import leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class demo145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode[] stack = new TreeNode[14];
        int len = 0;
        while (root != null) {
            stack[len++] = root;
            root = root.left;
        }

        boolean tag = true;
        List<Integer> res = new ArrayList<>();
        while (len != 0) {
            TreeNode temp = stack[len - 1];
            if (temp.right != null && tag) {
                root = temp.right;
                while (root != null) {
                    stack[len++] = root;
                    root = root.left;
                }
                tag = true;
            } else {
                len--;
                res.add(temp.val);
                tag = false;
            }
        }
        return res;
    }

}
