package offer;

public class demo57二叉树的下一个结点 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right == null) return null;
        pNode = pNode.right;
        while (pNode.left != null) {
            pNode = pNode.left;
        }
        return pNode;
    }

}
