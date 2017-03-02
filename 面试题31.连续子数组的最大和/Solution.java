/**
 * 题目：输入一个整数数组，数组中有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
 *		求所有子数组的和的最大值。要求时间复杂度为O(n)。
 */

 /*
  * 分析数组规律法：对于一个数A，若A的左边累计数非负，那么加上A能使值不小于A，则认为累计值
  *				 对当前子数组整体和是有贡献的；如果前几项累计值为负数，则认为有害于当前子
  *				 数组总体和，total记录当前和值，若total大于maxSum，则maxSum=total。
  */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0 || array == null) {
        	return 0;
        }
        int total = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
        	if (total >= 0) {
        		total += array[i];
        	}else {
        		total = array[i];
        	}
        	if (total > maxSum) 
        		maxSum = total;
        }
        return maxSum;
    }
}
