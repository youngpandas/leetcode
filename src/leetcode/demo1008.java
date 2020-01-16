package leetcode;

import leetcode.struct.TreeNode;

public class demo1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(0, preorder.length, preorder);
    }


    public TreeNode solve(int start, int end, int[] preorder) {
        if (start >= end) return null;
        int i = start, val = preorder[start];
        for (; i < end; i++) if (preorder[i] > val) break;
        TreeNode res = new TreeNode(val);
        res.left = solve(start + 1, i, preorder);
        res.right = solve(i, end, preorder);
        return res;
    }


}
