package leetcode;

import leetcode.struct.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class demo814 {

    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public boolean dfs(TreeNode root) {
        if (root == null) return true;
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if (left) root.left = null;
        if (right) root.right = null;
        return left && right && root.val == 0;
    }

}
