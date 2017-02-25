/**
 * 题目：操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 思路：先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子节点，
 *      当交换完所有的非叶子结点的左右子结点之后，就得到了树的镜像
 */

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) 
            return ;
        if (root.left == null && root.right == null) 
            return ;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null)
            Mirror(root.left);
        if (root.right != null)
            Mirror(root.right);
    }
}