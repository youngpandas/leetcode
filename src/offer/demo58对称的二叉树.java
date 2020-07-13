package offer;

import leetcode.struct.TreeNode;

public class demo58对称的二叉树 {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isSame(pRoot.left, pRoot.right);
    }

    boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }

}
