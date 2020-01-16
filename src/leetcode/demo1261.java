package leetcode;

import leetcode.struct.TreeNode;

public class demo1261 {

class FindElements {

    private TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
    }

    public boolean find(int target) {
        int[] stack = new int[20];
        int len = 0;
        while (target > 0) {
            stack[len++] = --target % 2;
            target /= 2;
        }
        TreeNode temp = root;
        while (len != 0) {
            temp = stack[--len] == 0 ? temp.left : temp.right;
            if (temp == null) return false;
        }
        return true;
    }
}

}
