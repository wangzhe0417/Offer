/**
 * 题目：把只包含因子2、3和5的数称作丑数(Ugly Number).例如6、8都是丑数，但14不是，
 *		因为它包含因子7。习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *	PS：一个数 m 是另一个数 n 的因子，是指 n 能被 m 整除，也就是 n % m == 0.
 */

/*
 * 基本思路：根据丑数的定义，如果一个数能被 2 整除，则将其连续除以 2；如果能被 3 整除，
 *		   则将其连续除以 3；如果能被 5 整除，则将其连续除以 5。如果最后的得到的值 1，
 *		   则这个数为丑数。
 * 缺点：每次求都需要从新计算，时间复杂度高，重复计算太多。
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
    	if (index <= 0)
    		return 0;
    	if (index == 1) 
    		return 1;
        int indexNnmber = 2;
        while(index > 1) {
        	if( isUglyNumber(indexNnmber) )
        		index --;
        	indexNnmber ++;
        }
        return indexNnmber;
    }
    public boolean isUglyNumber(int number) {
    	while(number % 2 == 0)
    		number /= 2;
    	while(number % 3 == 0)
    		number /= 3;
    	while(number % 5 == 0)
    		number /= 5;
    	return (number == 1) ? true : false;
    }
}

/*
 * 改进思路：创建数组保存已经找到的丑数，根据丑数定义，丑数应该是另一个丑数乘以 2，3 或 
 *		   5 的结果，因此可以创建一个数组，存储排序好的丑数。
 * 		   因为数组中丑数按顺序存放，所以对乘 2 而言，肯定存在某一个丑数 T2，排在它之前
 *		   的每一个丑数乘以 2 得到的结果都会小于数组中已存在的最大丑数，在它之后的丑数乘
 *		   以 2 得到的结果都太大；因此只需记下该丑数的位置，同时每次生成新丑数时，更新 T2.
 *		   对乘以 3 和 5 而言，也存在着同样的 T3 和 T5.
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0)
        	return 0;
        int [] array = new int[index];
        array[0] = 1;
        int nextUgly = 1;
        int uglyIndex2 = 0;
        int uglyIndex3 = 0;
        int uglyIndex5 = 0;
        while(nextUgly < index) {
        	array[nextUgly] = min(array[uglyIndex2] * 2, array[uglyIndex3] * 3, array[uglyIndex5] * 5);
        	while(array[uglyIndex2] * 2 <= array[nextUgly])
        		uglyIndex2 ++;
        	while(array[uglyIndex3] * 3 <= array[nextUgly])
        		uglyIndex3 ++;
        	while(array[uglyIndex5] * 5 <= array[nextUgly])
        		uglyIndex5 ++;
        	nextUgly++;
        }
        return array[index-1];
    }
    public int min(int number1, int number2, int number3) {
    	int min = (number1 < number2) ? number1 : number2;
    	min = (min < number3) ? min : number3;
    	return min;
    }
}


