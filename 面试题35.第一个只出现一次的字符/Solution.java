/**
 * 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出"b"。
 */
/*
 * 基本思路：两个指针 i，j 从头开始遍历字符串；i 固定，j 向后遍历，若array[i] == array[j] && i != j,
 *		   则 i++，j==0；直至 j指针遍历完整个数组跳出，输出此时的array[i]
 * 缺点：时间复杂度为O(n^2)
 */
import java.lang.String;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null)
        	return -1;
        char[] array = str.toCharArray();
        int i = 0;
        int j = 0;
        for (; i < array.length && j < array.length; i++) {
        	for (j = 0; j < array.length; j++) {
        		if ( array[i] == array[j] && i != j )
        			break;
        	}
        }
        return i-1;
    }
}

/*
 * 改进思路：用HashMap，遍历两次字符串数组，第一遍遍历更新map，第二次遍历查询map；当
 *		   value == 1，则输出。
 */
import java.lang.String;
import java.util.HashMap;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(str == null)
        	return -1;
        char[] array = str.toCharArray();
        for(int i = 0; i < array.length; i ++) {
        	if (map.containsKey(array[i])) {
        		map.put(array[i], map.get(array[i]) + 1);
        	}else {
        		map.put(array[i], 1);
        	}
        }

        for (int i = 0; i < array.length; i ++) {
        	if (map.get(array[i]) == 1) {
        		return i;
        	}
        }
        return -1;
    }
}

