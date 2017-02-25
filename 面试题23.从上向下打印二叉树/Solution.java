/**
 * 题目：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 思路：借助一个队列，从根节点顺序入队，出队时打印并顺序遍历其左孩子节点和右孩子节点；
 *		若节点不为空则入队，直到队列为空为止。
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
import java.util.*;

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) 
        	return result;
        queue.add(root);
        while (!queue.isEmpty()) {
        	root = queue.poll();
        	if (root.left != null) 
        		queue.add(root.left);
        	if(root.right != null)
        		queue.add(root.right);
			result.add(root.val);
        }
        return result;
    }
}