package leetcode;

import leetcode.struct.TreeNode;

public class demo700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        TreeNode left = searchBST(root.left, val);
        return left == null ? searchBST(root.right, val) : left;
    }

}
