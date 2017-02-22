/**
 * 题目：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 思路：将一个链表顺序比较插入另一个链表。实现则有两种，递归实现和非递归实现。
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

//递归实现
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
		if (list1 == null) 
			return list2;
		if (list2 == null) 
			return list1;
		ListNode result = null;
		if(list1.val <= list2.val) {
			result = list1;
			result.next = Merge(list1.next, list2);
		}else{
			result = list2;
			result.next = Merge(list1, list2.next);
		}
		return result;
	}
}

//非递归实现
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode result = null;
		ListNode current = null;
		while((list1 != null) && (list2 != null) ) {
			if (list1.val <= list2.val) {
				if (result == null) {
					result = list1;
					current = list1;
				}else {
					current.next = list1;
					current = current.next;
				}
				list1 = list1.next;
			}else {
				if (result == null) {
					result = list2;
					current = list2;
				}else {
					current.next = list2;
					current = current.next; 
				}
				list2 = list2.next;
			}
		}
		if (list1 != null) 
			current.next = list1;
		if (list2 != null) 
			current.next = list2;
		return result;
	}
}