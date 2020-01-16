package leetcode.examination;

import leetcode.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class demo3 {
    //给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//示例:
//
//输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int len = 1;
        while (!queue.isEmpty()) {
            int subLen = 0;
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                    subLen++;
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    subLen++;
                }
                if (i == len - 1) res.add(temp.val);
            }
            len = subLen;
        }
        return res;
    }

}
