/**
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *		输入一个数组，求出这个数组中的逆序对总数 P。并将 P 对1000000007取模的结果
 *		输出。 即输出P%1000000007。
 */

/*
 * 基本思路：顺序扫描整个数组，每扫描到一个数，则逐个比较该数与它后面的所有数字的大小。
 *		   如果后面的数小于该数，则是一个逆序对。
 * 缺点：时间复杂度为O(n^2)
 */
public class Solution {
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0)
        	return -1;
        int count = 0;
        for (int i = 0; i < array.length; i ++) {
        	for (int j = i+1; j < array.length; j++) {
        		if (array[i] > array[j])
        			count ++;
        	}
        }
        return count;
    }
}

/*
 * 改进思路：运用归并排序思想，
 *			1.先把数组分割成子数组，统计出子数组内部的逆序对数目并对子数组排序。
 *		    2.统计两个相邻子数组之间逆序对的数目，并排序。
 * 
 * 统计相邻子数组逆序对的方法：
 *		  两个指针分别指向两个数组的末尾，并每次比较两个指针指向的数字。如果第一个子数组
 *		  的数字大于第二个子数组中的数字，则构成逆序对，并且逆序对数量是第二个子数组中剩
 *		  余数字的个数；如果第一个子数组的数字小于第二个子数组中的数字，则不构成逆序对。
 *		  每次比较，都把大的数字从后往前复制到辅助数组中，把对应的指针向前移动一位，确保
 *		  辅助数组是递增排序的。
 */
public class Solution {
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0)
        	return -1;
       	int pairsNum = mSort(array, 0, array.length-1);
       	return pairsNum;
    }

    public int mSort(int [] array, int left, int right) {
    	if (left == right) {
    		return 0;
    	}
    	int middle = (left + right) >> 1;
    	int leftPairsNum = mSort(array, left, middle);
    	int rightPairsNum = mSort(array, middle+1, right);
    	int count = merge(array, left, middle, right) + leftPairsNum + rightPairsNum;
    	return count % 1000000007;
    }

    public int merge(int [] array, int left, int middle, int right) {
    	int cur1 = middle;
    	int cur2 = right;
    	int cur3 = right - left;
    	int [] temp = new int[right - left + 1];
    	int count = 0;
    	while (cur1 >= left && cur2 >= middle+1) {
    		if (array[cur1] > array[cur2]) {
    			temp[cur3--] = array[cur1--];
    			count = count + (cur2 - middle);
    			if (count > 1000000007) {
    				count %= 1000000007;
    			}
    		}else {
    			temp[cur3--] = array[cur2--];
    		}
    	}
    	while(cur1 >= left)
    		temp[cur3--] = array[cur1--];
    	while(cur2 >= middle+1)
    		temp[cur3--] = array[cur2--];
    	
    	//将临时数组赋值给原数组
    	for (int i = 0; i < temp.length; i++) {
    		array[left++] = temp[i];
    	}
    	return count;
    }
}
   


