/**
 * 题目：统计一个数字在排序数组中出现的次数。
 *
 * 基本思路：使用折半查找找到 k ，然后分别向前向后遍历，找到 k 出现的第一个位置 m 和最后一个位置 n;
 *			出现次数则为 n - m + 1;
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
    	if(array == null || array.length ==0)
       		return 0;
       	int low = 0;
       	int high = array.length - 1;
       	int middle = (low + high) >> 1;
        while (low <= high) {
    		if (array[middle] == k) {
    			break;
    		} else if (array[middle] < k) {
    			high = middle - 1;
    		} else {
    			low = middle + 1;
    		}
    		middle = (low + high) >> 1;
       	}
       	if (array[middle] != k)
       		return 0;
       	int firstK = middle;
       	int lastK = middle;
       	while(firstK >= 0 && array[firstK] == k)
       		firstK --;
       	firstK ++;
       	while(lastK <= array.length - 1 && array[lastK] == k)
       		lastK ++;
       	lastK --;
       	return lastK - firstK + 1;
    }
}

/*
 * 改进思路：使用二分查找分别找到第一个 K 和最后一个 K。
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
      	if (array == null || array.length == 0) 
      		return 0;
      	int low = 0;
      	int high = array.length - 1;
      	int firstK = getFirstK(array, k, low, high);
      	int lastK = getLastK(array, k, low, high);
      	if (firstK == -1 || lastK == -1)
      		return 0;
      	return lastK - firstK + 1;
    }

    public int getFirstK(int [] array, int k, int low, int high) {
    	while(low <= high) {
    		int middle = (low + high) >> 1;
    		if (array[middle] == k) {
    			if (middle == 0 ||array[middle - 1] != k) {
    				return middle;
    			}else {
    				high =  middle - 1;
    			}
    		} else if (array[middle] < k) {
    			low = middle + 1;
    		} else {
    			high = middle - 1;
    		}
    	}
    	return -1;
    }

    public int getLastK(int[] array, int k, int low, int high) {
    	while(low <= high) {
    		int middle = (low + high) >> 1;
    		if (array[middle] == k) {
    			if (middle == array.length - 1 || array[middle + 1] != k) {
    				return middle;
    			}else {
    				low = middle + 1;
    			}
    		} else if (array[middle] < k) {
    			low = middle + 1;
    		} else {
    			high = 	middle - 1;
    		}
    	}
    	return -1;
    }
}


