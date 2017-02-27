/**
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9
 *		的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因
 *		此输出2。如果不存在则输出0。
 */

/*
 * 基于Partition函数的O(n)算法：因为数组中有一个数字出现次数超过数组长度的一半，那么排序
 * 后位于数组中间的数字一定就是那个出现次数超过一半的数字，即中位数。
 * 1.在数组随机选择一个数，使用快排的思想，调整数组顺序，是的比选中数字小的数位于该数左边，
 *	 大的位于右边。
 * 2.若该数下标为n/2，则该数为中位数；若下标小于n/2，则在右边寻找；若大于n/2，则在左边寻找。
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
    	if(array.length == 0)
    		throw RuntimeException("Empty array！")； 
    	if(array.length == 1)
    		return array[0];
    	int start = 0;
    	int end = array.length-1;
        int middle = (array.length-1) / 2;
    	int index = Partition(array, start, end);
        while (index != middle) {
        	if (index > middle) {
        		index = Partition(array, )
        	}
        }
    }

    public int Partition(int [] array, int start, int end) {

    }
}