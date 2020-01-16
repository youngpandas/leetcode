package leetcode;

import leetcode.struct.TreeNode;

import java.util.Stack;

public class demo173 {

    class BSTIterator {

        private TreeNode[] stack = new TreeNode[21];
        private int len = 0;

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack[len++] = root;
                root = root.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode res = stack[--len];
            if (res.right != null) {
                TreeNode root = res.right;
                while (root != null) {
                    stack[len++] = root;
                    root = root.left;
                }
            }
            return res.val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return len != 0;
        }
    }

}
