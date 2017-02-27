/**
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的
 *		结点，只能调整树中结点指针的指向。
 * 思路：二叉搜索树的中序遍历序列就是递增有序的，因此
 * 
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

//递归实现
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
        	return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null)
        	return pRootOfTree;
        //将左子树构造成双链表，并返回链表头结点
        TreeNode pLeft = Convert(pRootOfTree.left);
        TreeNode pNode = pLeft;
        //定位左子树链表的尾结点
        while (pNode != null && pNode.right != null) 
        	pNode = pNode.right;
 		//左子树不为空，则将根节点加到左子树链表末尾
 		if (pLeft != null) {
 			pNode.right = pRootOfTree;
 			pRootOfTree.left = pNode;
 		}
 		//将右子树构造成双链表，并返回链表头结点
 		TreeNode pRight = Convert(pRootOfTree.right);
 		//如果右子树链表不为空，则加到根节点后
 		if (pRight != null){
 			pRootOfTree.right = pRight;
 			pRight.left = pRootOfTree;
 		}
 		//根节点左子树链表不为空，则pLeft为链表头结点；否则根节点为链表头结点
 		//return (pLeft != null):pLeft?pRootOfTree;
        if(pLeft != null)
           return pLeft;
        return pRootOfTree;
    }
}

//非递归实现
import java.util.Stack;

public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
        	return null;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pNode = pRootOfTree;
		TreeNode preNode = null;
		boolean isFirst = true;
		while(pNode != null || !stack.empty()){
			while (pNode != null) {
				stack.push(pNode);
				pNode = pNode.left;
			 }
			pNode = stack.pop();
			if (isFirst) {
				pRootOfTree = pNode;
				preNode = pRootOfTree;
				isFirst = false;
			} else {
				preNode.right = pNode;
				pNode.left = preNode;
				preNode = pNode;
			}
			pNode = pNode.right;
		}
		return pRootOfTree;
    }
}
