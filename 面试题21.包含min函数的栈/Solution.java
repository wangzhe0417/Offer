/**
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * 思路：使用一个辅助栈，记录当前数据栈的最小值。
 *		实现一：入栈数据小于等于辅助栈栈顶元素时，辅助栈才进行入栈操作，
 *			   出栈数据等于辅助栈栈顶元素时，辅助栈才进行出栈操作。
 * 		实现二：入栈数据小于辅助栈栈顶元素时，辅助栈入栈，否则重复入栈辅助栈栈顶数据，
 *			   出栈时辅助栈同步出栈，不需要判断。
 */

import java.util.Stack;

public class Solution {
	Stack<Integet> dataStack = new Stack<>();
	Stack<Integet> minStack = new Stack<>();
    
    public void push(int node) {
        if (dataStack.empty()) {
        	dataStack.push(node);
        	minStack.push(node);
        }else {
        	dataStack.push(node);
        	if (mode <= minStack.peek()) {
        		minStack.push(node);
        	}
        }
    }
    
    public void pop() {
        if (dataStack.peek() == minStack.peek) {
        	dataStack.pop();
        	minStack.pop();
        }else {
        	dataStack.pop();
        }
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}