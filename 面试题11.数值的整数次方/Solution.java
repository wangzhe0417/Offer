/**
 * 题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 思路一：需要考虑base为0，exponent为负数这两种情况。
 * 思路二：对PowerUnsignedExponent类乘操作进行改进。运用递归，移位运算和位运算
 */

//思路一
public class Solution {
    public double Power(double base, int exponent) {
    	if(equal(base, 0.0) && exponent < 0)
            throw new RuntimeException("Error base");
        if(exponent < 0){
            return 1.0 / PowerUnsignedExponent(base, -exponent);
        }
        return PowerUnsignedExponent(base, exponent);
    }
    
    public double PowerUnsignedExponent(double base, int exponent) {
        double result = 1.0;
        while(exponent-- > 0) {
            result = result * base;
        }
        return result;
    }
    
    public boolean equal(double num1, double num2) {
        if((num1 - num2) < 0.0001 && (num1 - num2) > -0.0001)
            return true;
        else
            return false;
        
    }
}

//思路二
public class Solution {
    public double Power(double base, int exponent) {
    	if(equal(base, 0.0) && exponent < 0)
            throw new RuntimeException("Error base");
        if(exponent < 0){
            return 1.0 / PowerUnsignedExponent(base, -exponent);
        }
        return PowerUnsignedExponent(base, exponent);
    }
    
    public double PowerUnsignedExponent(double base, int exponent) {
        if(exponent == 0)
        	return 1;
        if(exponent == 1)
        	return base;
        double result = PowerUnsignedExponent(base, exponent >> 1);
        result *= result;
        if((exponent & 1) == 1)//通过与运算求余，如果为奇数，则再乘base。等价于(exponent % 2 == 1)
        	result *= base;
        return result;
    }
    
    public boolean equal(double num1, double num2) {
        if((num1 - num2) < 0.0001 && (num1 - num2) > -0.0001)
            return true;
        else
            return false;
        
    }
}
