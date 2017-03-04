/**
 * 题目：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 基本思路：递归计算每个结点的左右子树高度，计算得出是否为平衡二叉树。TreeDepth会重复遍历结点多次。
 */
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) 
        	return true;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if(right - left > 1 || right - left < -1)
        	return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
       	
    }
    public int TreeDepth(TreeNode root) {
        if (root == null)
        	return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }
}

/*
 * 改进思路：后序遍历二叉树，边遍历边计算每个结点是否平衡。每个节点只遍历一次。
 * 			直接在TreeDepth中检查是否平衡
 */
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
    	if (TreeDepth(root) == -1) {
    		return false;
    	}
    	return true;
    }
    public int TreeDepth(TreeNode root) {
    	if (root == null) 
    		return 0;
    	int left = TreeDepth(root.left);
    	if (left == -1)
    		return -1;
    	int right = TreeDepth(root.right);
    	if (right == -1)
    		return -1;
    	if (left - right > 1 || left - right < -1)
    		return -1;
    	return left > right ? left + 1: right + 1;
    }
}

