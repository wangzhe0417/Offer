/**
 * 题目：输入一个链表，反转链表后，输出链表的所有元素。
 *
 * 思路一：头插法
 * 思路二：三个指针pre、head、next同时遍历，并反转链表
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
//思路一：
public class Solution {
    public ListNode ReverseList(ListNode head) {
		if(head == null)
			return null;
		ListNode result = null;	
		ListNode pHead = null;
		while(head != null){ 
			pHead = head;
			head = head.next;
			pHead.next = result;
			result = pHead;
		}
		return result;
    }
}

//思路二
public class Solution {
    public ListNode ReverseList(ListNode head) {
    	if(head == null)
    		return null;
    	ListNode pre = null；
    	ListNode next = null;
    	while(head != null) {
    		next = head.next;
    		head.next = pre;
    		pre = head;
    		head = next;
    	}
    	return pre;
    }
}