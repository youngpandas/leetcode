package leetcode;

import leetcode.struct.TreeNode;

public class demo701 {

    boolean tag = false;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        dfs(root, val);
        if (tag) return root;
        TreeNode res = new TreeNode(val);
        res.left = root;
        return res;
    }

    public void dfs(TreeNode root, int val) {
        if (root == null) return;
        dfs(root.left, val);
        if (root.val > val && !tag) {
            tag = true;
            TreeNode temp = new TreeNode(val);
            temp.left = root.left;
            root.left = temp;
            return;
        }
        dfs(root.right, val);
    }

}
