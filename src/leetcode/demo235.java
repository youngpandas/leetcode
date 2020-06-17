package leetcode;

import leetcode.struct.TreeNode;

public class demo235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) return root;
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        if (min < root.val && max > root.val) return root;
        if (min < root.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }

}
