/**
 * 题目：输入一个链表，输出该链表中倒数第k个结点。
 *
 * 思路：一个计数值i，ListNode head顺序遍历链表，同时i计数；当i=k时，ListNode result开始开始顺序遍历链表并与head同步；
 *		 当i走到链表末尾时，result对应的值就是链表倒数第k个结点。
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
public class Solution {
	public ListNode FindKthToTail(ListNode head,int k) {
		ListNode result = head;
        if(head == null || k <= 0) 
            return null;
		while(head.next != null){
			if(k-- > 1){
				head = head.next;
			}else{
				head = head.next;
				result = result.next;
			}
		}
        if(k > 1)//排除k大于链表长度的情况，其实可以在循环前直接比较k和head.size(),但是无法通过
            return null;
		return result;
	}
}