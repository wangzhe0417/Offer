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
    	if(array.length <= 0)
    		return 0; 
    	if(array.length == 1)
    		return array[0];
    	int middle = array.length >> 1;
    	int start = 0;
    	int end = array.length - 1;
    	int index = partition(array, start, end);
    	while(index != middle) {
    		if (index > middle) {
    			index = partition(array, start, index-1);
    		}else {
    			index = partition(array, index+1, end);
    		}
    	}
    	int result = array[index];

    	//排除不存在出现次数超过数组长度一半的数
    	int time = 0;
    	for (int i = 0; i < array.length; i++) {
    		if (array[i] == result) 
    			time ++;
    	}
    	if (time * 2 <= array.length) {
    		return 0;
    	}else {
    		return result;
    	}
    }
    //基于快排思想的划分
    public int partition(int[] array, int start, int end) {
    	//随机确定基准点
    	int keyIndex = (int)start + (int)Math.random() * (end-start);  
   		while(start < end){  
   			while(start < end && array[end] >= array[keyIndex])  
   				end--;  
   			swap(array, start, end);
   			while(start < end && array[start] <= array[keyIndex])  
   				start ++ ;  
   			swap(array, start, end); 
   		}  
   		return start;  
    }
    public void swap(int[] array, int i, int j) {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
}

/*
 * 基于数组特点找出的O(n)算法：因为数组中有一个数出现的次数超过数组长度的一半，也就是说他
 * 出现的次数比其他所有数字出现次数的和还要多。则在遍历数组时用两个值，一个保存数num，一个保存
 * 出现次数count；遇见相同的数，则count++，遇见不同的数，则count--；当count为0时，则下一个
 * 数字赋值给num，所以遍历结束时，num中的数就是出现次数超过一半的数。
 */
public class Solution {
	public int MoreThanHalfNum_Solution(int[] array) {
		if(array.length == 0)
    		return 0; 
    	if(array.length == 1)
    		return array[0];
    	int num = array[0];
    	int count = 1;
    	for (int i = 1; i < array.length; i++) {
    		if (count != 0) {
    			if (array[i] == num ) {
    				count ++;
    			}else {
    				count --;
    			}
    		}else {
    			num = array[i];
    			count = 1;
    		}
    	}
    	//排除不存在出现次数超过数组长度一半的数
    	int time = 0;
    	for (int i = 0; i < array.length; i++) {
    		if (array[i] == num) 
    			time ++;
    	}
    	if (time * 2 <= array.length) {
    		return 0;
    	}else {
    		return num;
    	}
	}
}

/*
 * HashMap法：遍历数组，并将数存入hash表，不存在则加入hash表，value为1；存在则value++；
 * 			 最后再迭代器访问hash表，value>=array.length/2，则返回key。
 */
import java.util.HashMap;
import java.util.Map;
public class Solution {
	public int MoreThanHalfNum_Solution(int[] array) {
		if(array.length == 0)
    		return 0; 
    	if(array.length == 1)
    		return array[0];
    	HashMap<Integer,Integer> map = new HashMap<>();
    	//遍历数组，计算每个数出现的次数
    	for (int i = 0; i < array.length; i++) {
    		if (map.containsKey(array[i])) {
    			map.put(array[i], map.get(array[i])+1 );
    		}else {
    			map.put(array[i], 1);
    		}
    	}
    	//迭代器访问HashMap，找到出现次数超过一半的数
    	for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
    		if(entry.getValue() > array.length/2)
    			return entry.getKey();
    	}
    	return 0;
	}
}





