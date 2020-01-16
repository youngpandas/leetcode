package leetcode.examination;

import leetcode.struct.TreeNode;

public class demo2 {
//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
//
//说明：
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
//
//示例 1:
//
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1
//示例 2:
//
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3
//进阶：
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？


    private int[] nums = null;
    private int len = 0;
    private boolean tag = false;

    public int kthSmallest(TreeNode root, int k) {
        if (tag) return nums[k - 1];
        tag = true;
        nums = new int[count(root)];
        midViewer(root);
        return nums[k - 1];
    }

    public int count(TreeNode root) {
        if (root == null) return 0;
        int res = 1;
        res += count(root.left);
        res += count(root.right);
        return res;
    }

    public void midViewer(TreeNode root) {
        if (root == null) return;
        midViewer(root.left);
        nums[len++] = root.val;
        midViewer(root.right);
    }

}
