/**
 * 题目：输入两个链表，找出它们的第一个公共结点。
 *
 *
 * 基本思路：链表 A 固定，链表 B 顺序遍历，并跟 A 所指节点比较，若相同则输出；若遍历完 B 还未找到，则 A
 *  	   后移一位，B 重新遍历；直到找到公共节点或者 A 遍历完为止。
 * 缺点：时间复杂度过高O(mn)
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	if (pHead1 == null && pHead2 == null) 
    		return null;
 		ListNode pCurrent1 = pHead1;
 		ListNode pCurrent2 = pHead2;
 		while(pCurrent1 != null) {
 			while(pCurrent2 != null) {
 				if (pCurrent1.val == pCurrent2.val) {
 					return pCurrent1;
 				}
 				pCurrent2 = pCurrent2.next;
 			}
 			pCurrent1 = pCurrent1.next;
 			pCurrent2 = pHead2;
 		}
 		return null;
    }
}

/*
 * 改进思路一：存在公共节点，从公共节点往后的节点全部相同；所以可以借助两个栈，实现从后向前比较；对出栈的两个
 *			 节点进行比较，若相同则继续出栈；若不同则前一个节点为第一个公共节点。
 * 改进思路二：借助HashMap，先对一个链表进行遍历并加入map；然后遍历另一个链表并和map进行比较；相同的，则为
 *			 第一个公共节点；不相同则继续遍历；直到找到相同节点或链表遍历完成。
 * 改进思路三：首先遍历两个链表的长度m、n (m > n)，然后长的链表先向后遍历 m-n 个结点，然后两个链表同步向后
 *			 遍历；直到找到第一个公共结点或链表遍历完。
 */
//思路一实现：
import java.util.Stack;
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 		if (pHead1 == null || pHead2 == null) 
 			return null;
 		Stack<ListNode> stack1 = new Stack<>();
 		Stack<ListNode> stack2 = new Stack<>();
 		ListNode pCurrent1 = pHead1;
 		ListNode pCurrent2 = pHead2;
 		while(pCurrent1 != null){
 			stack1.push(pCurrent1);
 			pCurrent1 = pCurrent1.next;
 		}
 		while(pCurrent2 != null) {
 			stack2.push(pCurrent2);
 			pCurrent2 = pCurrent2.next;
 		}
 		ListNode commentNode = null;
 		while(!stack1.empty() && !stack2.empty() && stack1.peek().val == stack2.peek().val) {
 			commentNode = stack1.pop();
 			stack2.pop();
 		}	
 		return commentNode;
    }
}

//思路二实现：
import java.util.HashMap;
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 		if (pHead1 == null || pHead2 == null) 
 			return null;
 		HashMap<ListNode, Integer> map = new HashMap<>();
 		ListNode pCurrent1 = pHead1;
 		ListNode pCurrent2 = pHead2;
 		while(pCurrent2 != null) {
 			map.put(pCurrent2, pCurrent2.val);
 			pCurrent2 = pCurrent2.next;
 		}
 		while(pCurrent1 != null) {
 			if( map.containsKey(pCurrent1) )
 				return pCurrent1;
 			pCurrent1 = pCurrent1.next;
 		}
 		return null;
    }
}

//思路三实现：
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 		if (pHead1 == null || pHead2 == null) 
 			return null;
 		ListNode pCurrent1 = pHead1;
 		ListNode pCurrent2 = pHead2;
 		int length1 = 0;
 		int length2 = 0;
 		while(pCurrent1 != null) {
 			length1 ++;
 			pCurrent1 = pCurrent1.next;
 		}
 		while(pCurrent2 != null) {
 			length2 ++;
 			pCurrent2 = pCurrent2.next;
 		}
 		pCurrent1 = pHead1;
 		pCurrent2 = pHead2;
 		while (length1 > length2) {
 			pCurrent1 = pCurrent1.next;
 			length1 --;
 		}
 		while (length2 > length1) {
 			pCurrent2 = pCurrent2.next;
 			length2 --;
 		}
 		while(pCurrent1 != null){
 			if (pCurrent1.val == pCurrent2.val) {
 				return pCurrent1;
 			}
 			pCurrent1 = pCurrent1.next;
 			pCurrent2 = pCurrent2.next;
 		}
 		return null;
    }
}




