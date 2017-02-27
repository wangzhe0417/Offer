/**
 * 题目：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个
 *		特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中
 *		请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * Hash表法：1.先复制原始链表，所有random指针指向null，同时使用hash表存储< N, N'>
 *		 	2.遍历链表，查询hash表，顺序设置random指针，即原链表random指向S，则复制链
 *			  表random指向S'。
 * 三步拆分法：1.在旧链表中每个节点之后插入一个与前节点N相同的节点N'，使当前链表从A->B->
 *			C->D->E变为A->A'->B->B'->C->C'->D->D'->E->E'
 *		 	2.根据链表中N节点的random指针设置链表中N'节点的random指针。
 *		 	3.从链表中将N‘节点拆分出来得到复制链表。
 */

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
//HashMap方法
import java.util.HashMap;

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
    	if (pHead == null)
    		return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode pCurrent = pHead;
        RandomListNode qHead = new RandomListNode(pHead.label);
        RandomListNode qCurrent = qHead;
        //复制链表的next指针，并存储HashMap
        while(pCurrent != null) {
        	map.put(pCurrent, qCurrent);
         	pCurrent = pCurrent.next;
         	RandomListNode temp;
         	if (pCurrent != null) {
         		temp = new RandomListNode(pCurrent.label);
         	} else {
         		temp = null;
         	}
         	qCurrent.next = temp;
         	qCurrent = qCurrent.next;
        }

        //设置random指针
        pCurrent = pHead;
        qCurrent = qHead;
        while(qCurrent != null) {
        	if (pCurrent.random == null) {
        		qCurrent.random = null;
        	}else {
        		qCurrent.random = map.get(pCurrent.random);
        	}
        	pCurrent = pCurrent.next;
        	qCurrent = qCurrent.next;
        }
        return qHead;
    }
}

//三步拆分法
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
    	if (pHead == null)
    		return null;
    	RandomListNode pCurrent = pHead;
         //第一步：在旧链表上插入
    	while(pCurrent != null) {
    		RandomListNode temp = new RandomListNode(pCurrent.label);
    		temp.next = pCurrent.next;
    		pCurrent.next = temp;
    		pCurrent = temp.next;
    	}
    	//第二步：设置N'的random指针
    	pCurrent = pHead;
    	while(pCurrent != null) {
    		if(pCurrent.random != null)
    			pCurrent.next.random = pCurrent.random.next;
    		pCurrent = pCurrent.next.next;
    	}

    	//第三步：切割分离
    	pCurrent = pHead;
    	RandomListNode qHead = pHead.next;
    	RandomListNode qCurrent = qHead;
    	while(pCurrent != null) {
    		pCurrent.next = qCurrent.next;
    		pCurrent = pCurrent.next; 
    		if (pCurrent != null) 
    			qCurrent.next = pCurrent.next;
    		qCurrent = qCurrent.next;
    	}
    	return qHead;
    }
}