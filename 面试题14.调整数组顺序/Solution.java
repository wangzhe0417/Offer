/**
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *		 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 思路一：因为要保证奇偶数各自的相对位置不变，所以不能使用快排思想，只能使用冒泡思想。
 *		   i从左向右遍历，找到第一个偶数停下，j从i+1开始从左向右遍历，遇见第一个奇数则将i~j-1后移一位，j插入；
 *		   i后移一位，j继续向后遍历，直至遍历整个数组。
 * 思路二：再创建一个数组，两次遍历原数组，第一次将奇数顺序存储，第二次将偶数顺序存储。
 */

//思路一
public class Solution {
    public void reOrderArray(int [] array) {
    	if(array == null || array.length == 0)
    		return;
    	int i = 0;
    	int j = 0;
    	while(i < array.length && j < array.length) {
    		while(i < array.length && array[i] % 2 == 1) {
    			i ++;
    		}
    		if(j <= i)
    			j = i + 1;
    		while(j < array.length && array[j] % 2 == 0) {
    			j ++;
    		}
    		if (j < array.length) {
    			int temp = array[j];
    			for(int m = j-1; m >= i; m--) {
    				array[m+1] = array[m];
    			}
    			array[i] = temp;
    		}else {
    			break;	
    		}
    	}
    }
}

//思路二
public class Solution {
    public void reOrderArray(int [] array) {
    	if(array == null || array.length == 0)
    		return;
    	int [] result = new int[array.length];
    	int j = 0;
    	for(int i = 0; i < array.length; i++) {
    		if(array[i] % 2 == 1)
    			result[j++] = array[i];
    	}
    	for(int i = 0; i < array.length; i++) {
    		if(array[i] % 2 == 0)
    			result[j++] = array[i];
    	}
    	if(result.length != array.length)
    		throw new RuntimeException("Error result!");
        for(int i = 0; i < array.length && i < result.length; i++){
            array[i] = result[i];
        }
    }
}