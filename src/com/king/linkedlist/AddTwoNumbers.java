package com.king.linkedlist;

/**
 * 2���������
 * 	���������ǿյ�������ʾ�����Ǹ���������
 * 	����ÿλ���ֶ��ǰ�������ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢һλ���֡�
 * 	���㽫��������ӣ�������ͬ��ʽ����һ����ʾ�͵�����
 * 	����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ
 * @author 19435
 *
 */
public class AddTwoNumbers {

	/**
	 * ʾ����
	 * 	���룺L1 = [2,4,3], L2 = [5,6,4]
	 * 	�����[7,0,8]
	 * 	���ͣ�342 + 465 = 807
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
	 * �����������⣬���ؽ��Ϊͷ���ʱ��ͨ����Ҫ�ȳ�ʼ��һ��ͷָ�� head��
	 * ��ָ�����һ���ڵ�ָ������ĵ�һ����㡣
	 * ʹ��ͷָ���Ŀ�����������ʼ��ʱ�޿��ý��ֵ�����������������Ҫָ���ƶ��������ᵼ��ͷָ�붪ʧ���޷����ؽ��
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
			
			int sum = x + y + carry; 	//������Ӧλ�õ�����
			
			carry = sum / 10;	// ��λֵ
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
