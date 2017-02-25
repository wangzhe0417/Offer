/**
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,
 *		否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 思路：对于二叉搜索树的后序遍历序列，最后一个值为根节点的值，前面的序列又分为两个部分；
 *		一部分是根节点左子树的后序遍历序列，值都比根节点小，另一部分是根节点右子树的后
 *		序遍历序列，值都比根节点大。
 */

//递归实现
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)
        	return false;
        if(sequence.length == 1)
        	return true;
        return verify(sequence, 0, sequence.length-1);
    }
    public boolean verify(int [] sequence, int startIndex, int rootIndex) {
    	if (startIndex > rootIndex)
    		return true;
    	int i = startIndex; 
    	while(i < rootIndex && sequence[i] < sequence[rootIndex]) {
    		i++;
    	}
    	for (int j = i; j < rootIndex; j++) {
    		if (sequence[j] < sequence[rootIndex]) 
    			return false;
    	}
    	return verify(sequence, startIndex, i-1) && verify(sequence, i, rootIndex-1);
    }
}