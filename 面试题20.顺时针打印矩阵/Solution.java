/**
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 
 *                    1 2 3 4 
 *                    5 6 7 8 
 *                    9 10 11 12 
 *                    13 14 15 16 
 *      则依次打印出数字
 *                    1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 思路：
 */

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
    	ArrayList<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (rows == 0 || columns == 0) 
        	return list;
        int circle = 0;
        while (rows > 2 * circle && columns > 2 * circle) {
        	printMatrixInCircle(matrix, list, rows, columns, circle);
           	circle++;
       	}
       	return list;
    }
    public void printMatrixInCircle(int [][] matrix, ArrayList<Integer> list, int rows, int columns, int circle) {
    	//从左到右打印一行
    	for(int i = circle; i < columns - circle; i++) 
    		list.add(matrix[circle][i]);
    	//从上到下打印一列
    	for(int j = circle + 1; j < rows - circle; j++)
    		list.add(matrix[j][columns - circle - 1]);
    	//从右向左打印一行
    	for(int m = columns - circle - 2; m >= circle && rows - circle -1 > circle; m--)
    		list.add(matrix[rows - circle - 1][m]);
    	//从下向上打印一列
    	for(int n = rows - circle - 2; n >= circle + 1 && columns - circle -1 > circle; n--)
    		list.add(matrix[n][circle]);
    }
}