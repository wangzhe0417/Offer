/**
 * 题目：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义
 *		为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 思路：当用前序遍历的方式访问到某一结点时，我们把该节点添加到路径中，并累加该节点的值。
 *		该节点为叶子结点并且路径中结点的值恰好等于输入整数值，则当前路径符合要求；若当前
 *		结点不是叶子结点，则继续访问它的子结点。当前结点访问结束之后，递归函数将自动返回
 *		到它的父节点。因此，要在函数退出之前，在路径上删除当前结点并减去当前节点的值，以
 *		确保返回父节点时路径刚好是从根节点到父节点的路径。
 */

import java.util.ArrayList;
import java.util.Stack;
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
                if (root == null) {
        	return pathList;
        }
        Stack<Integer> stack = new Stack<>();
        findPath(root, target, pathList, stack);
        return pathList;
    }

    public void findPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> pathList, Stack<Integer> stack) {
    	if (root == null)
    		return ;
    	stack.push(root.val);
    	target -= root.val;
    	if (root.left == null && root.right == null && target == 0) {//为叶子节点
    		ArrayList<Integer> list = new ArrayList<>();
    		for(int s: stack)
    			list.add(s);
    		pathList.add(list);
    	}
    	//不是叶子节点则遍历子节点
    	if (root.left != null)
   			findPath(root.left, target, pathList, stack);
   		if (root.right != null)
   			findPath(root.right, target, pathList,stack);
   		//保证退出访问节点时要出栈！
   		stack.pop();
    }
}