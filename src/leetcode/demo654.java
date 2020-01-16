package leetcode;


import leetcode.struct.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class demo654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(0, nums.length - 1, nums);
    }

    public TreeNode solve(int start, int end, int[] nums) {
        if (start > end) return null;
        int idx = start;
        for (int i = start; i <= end; i++) if (nums[idx] < nums[i]) idx = i;
        TreeNode res = new TreeNode(nums[idx]);
        res.left = solve(start, idx - 1, nums);
        res.right = solve(idx + 1, end, nums);
        return res;

    }

}
