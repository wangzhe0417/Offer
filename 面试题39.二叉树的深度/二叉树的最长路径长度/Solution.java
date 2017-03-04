/**
 * 题目：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 *		最长路径的长度为树的深度。
 *
 * 基本思路：递归遍历二叉树或者非递归法用队列对二叉树进行层次遍历。
 */
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

//递归实现
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null) 
        	return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left > right ? (left + 1) : (right + 1);
    }
}

//层次遍历
import java.util.Queue;
import java.util.LinkedList;
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null) 
        	return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0;
        int count = 1;
        while (queue.size() != 0) {
        	TreeNode node = queue.poll();
        	count --;
        	if (node.left != null) 
        		queue.add(node.left);
        	if (node.right != null) 
        		queue.add(node.right);
        	if (count == 0) {
        		count = queue.size();
        		depth ++;
        	}
        }
        return depth;
    }
}