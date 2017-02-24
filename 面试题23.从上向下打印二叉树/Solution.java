/**
 * 题目：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 思路：借助一个辅助栈，将入栈序列依次入栈，栈顶元素与所给出的出栈队列相比，如果相同则出栈，
 *		如果不同，则继续入栈，直到原入栈序列全部入栈为止；检测辅助栈是否为空，若空，说明出栈
 *		队列正确，否则不正确。
 */

import java.util.ArrayList;
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        
    }
}