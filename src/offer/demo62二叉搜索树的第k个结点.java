package offer;

public class demo62二叉搜索树的第k个结点 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int pos = 0;
    private TreeNode target;
    private int k;


    TreeNode KthNode(TreeNode pRoot, int k) {
        this.k = k;
        midView(pRoot);
        return target;
    }

    public void midView(TreeNode root) {
        if (pos == k) return;
        if (root == null) return;
        midView(root.left);
        pos++;
        if (pos == k) this.target = root;
        midView(root.right);
    }

}
