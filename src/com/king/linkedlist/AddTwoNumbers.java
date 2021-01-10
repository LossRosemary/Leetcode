package com.king.linkedlist;

/**
 * 2、两数相加
 * 	给你两个非空的链表，表示两个非负的整数。
 * 	它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 	请你将两个数相加，并以相同形式返回一个表示和的链表
 * 	你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 * @author 19435
 *
 */
public class AddTwoNumbers {

	/**
	 * 示例：
	 * 	输入：L1 = [2,4,3], L2 = [5,6,4]
	 * 	输出：[7,0,8]
	 * 	解释：342 + 465 = 807
	 * @param args
	 */
	public static void main(String[] args) {
		
		ListNode L1 = new ListNode(2,new ListNode(4,new ListNode(3,new ListNode())));
		ListNode L2 = new ListNode(5,new ListNode(6,new ListNode(4,new ListNode())));
		ListNode L3 = new ListNode(2,new ListNode(3,new ListNode()));
		
		ListNode addListNode = addTwoNumbers(L1, L3);
		System.out.println(addListNode);
	}
	
	/**
	 * 对于链表问题，返回结果为头结点时，通常需要先初始化一个头指针 head，
	 * 该指针的下一个节点指向链表的第一个结点。
	 * 使用头指针的目的在于链表初始化时无可用结点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果
	 * @param L1
	 * @param L2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode L1, ListNode L2) {
		
		ListNode head = new ListNode(0);
		ListNode tail = head;
		
		int carry = 0;
		while(L1 != null || L2 != null) {
			int x = L1 == null ? 0 : L1.val;
			int y = L2 == null ? 0 : L2.val;
			
			int sum = x + y + carry; 	//链表处相应位置的数字
			
			carry = sum / 10;	// 进位值
			sum = sum % 10;		
			
			tail.next = new ListNode(sum);
			tail = tail.next;
			
			if (L1 != null) {
				L1 = L1.next;
			}
			if (L2 != null) {
				L2 = L2.next;
			}
		}
		if (carry > 0) {
			tail.next = new ListNode(1);
		}
		return head.next;
	}
}
