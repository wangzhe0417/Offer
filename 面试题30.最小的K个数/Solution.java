/*
 * 题目：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4
 *      个数字是1,2,3,4。
 * 思路：最直接的想法就是先排序，然后前K个数即为最小的K个数。时间复杂度是O(nlogn);调优后
 *		的方法为基于快排的partition，和基于小根堆的比较替换。
 */

/*
 * 基于快排的pattition算法：随机选择一个数，一次partition后，左边的数全部小于该数，右边
 *	的数全部大于该数；该数下标index>k,则在左边继续partition，index<k，则在右边继续
 *	partition；直到index等于k，则找到了最小的K个数。平均时间复杂度O(n)
 * 缺点：会改变原有数组。
 */
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || k > input.length || k <= 0) 
        	return list;
        int low = 0;
        int high = input.length-1;
        int index = partition(input, low, high);
        while(index != k-1) {
        	if (index > k-1) {
        		index = partition(input, low, index-1);
        	}else {
        		index = partition(input, index+1, high);
        	}
        }
        
        for(int i = 0; i < k; i++)
        	list.add(input[i]);
        return list;
    }
    //快排思想的partition
    public int partition(int[] input, int low, int high) {
    	//随机选择一个数
    	int key = input[low];
    	while (low < high) {
    		while(low < high && input[high] >= key)
    			high --;
    		swap(input, low, high);
    		while(low < high && input[low] <= key)
    			low ++;
    		swap(input, low, high);
    	}
    	return low;
    }
    public void swap(int[] input, int i, int j) {
    	int temp = input[i];
    	input[i] = input[j];
    	input[j] = temp;
    }
}

/*
 * 基于小根堆的比较替换算法：利用输入的数组维护一个大小为k的最大堆，然后再遍历剩下的数组元素，
 *  每当找到一个比当前堆顶元素小的数时，替换堆顶元素，然后重新调整堆，最后维护的堆即为要求的内
 *  容。时间复杂度O(nlogk)
 */
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length == 0 || k > input.length || k <= 0 || input == null)
            return list;
        //构建容量为K的大顶堆
        for (int i = (k - 2) / 2;  i >= 0 ; i --) {
            adjustHeap(input, i, k);
        }
        //遍历剩余的input.length-k个数，并更新堆
        for (int i = k; i < input.length; i++) {
            if (input[i] < input[0]) {
                swap(input, 0, i);
                adjustHeap(input, 0, k);
            }
        }
        for (int i = 0; i < k; i ++) {
            list.add(input[i]);
        }
        return list;
    }

    public void adjustHeap(int[] input, int j, int length){
        for (int i = 2 * j + 1; i < length; i = 2 * i + 1) {
            //i+1 < length一定要在input[i] < input[i+1]前，可以通过短路来排除右孩子不存在而报的下标越界异常
            if(i < length && i + 1 < length && input[i] < input[i+1])
                i++;
            if(input[j] >= input[i]){
                break;
            }else {
                swap(input, j, i);
                j = i;
            }
        }
    }

    public void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}

