package com.king.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. ���ظ��ַ�����Ӵ�
 * 		����һ���ַ����������ҳ����в������ظ��ַ�����Ӵ��ĳ��ȡ�
 * @author 19435
 *
 */
public class RepeatingCharacters {
	
	/**
	 * 	ʾ��1��
	 * 		����: s = "abcabcbb"
	 * 		���: 3 
	 * 		����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3
	 * 	ʾ��2��
	 * 		����: s = "pwwkew"
	 * 		���: 3 
	 * 		����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
	 * 		��ע�⣺��Ĵ𰸱������Ӵ��ĳ��ȣ�"pwke" ��һ�������У������Ӵ�
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abcabcdb";
		//int num = lengthOfLongestSubstring(str);
		int num_set = lengthOfLongestSubstring_Set(str);
		//System.out.println(num);
		System.out.println(num_set);
	}
	
	/**
	 * 	˼·�����������ڡ�
	 * 		ʹ������ָ���ʾ�ַ����е�ĳ���Ӵ��������ұ߽磩��
	 * 		��ָ���������ʼλ�ã�����ָ�뼴Ϊ�������ظ��ַ�����Ӵ��Ľ���λ��
	 * 		���ϵ������ƶ���ָ�룬��������ظ��ַ�������ָ�������ƶ�һ��
	 * 		��֤������ָ���Ӧ���Ӵ���û���ظ����ַ���
	 * 		���ƶ�����������Ӵ��Ͷ�Ӧ�� ����ָ�뿪ʼ�ģ��������ظ��ַ�����Ӵ���
	 * 		��¼������Ӵ��ĳ���
	 * 	�ж��ظ��ַ���HashMap
	 * @param str
	 */
	private static int lengthOfLongestSubstring(String str) {
		
		if (str == null) {
			return 0;
		}
		
		int str_length = str.length();
		
		Map<Character, Integer> map = new HashMap<>();
		int left = 0;	//�����������±�
		int max = 0;	//��Ӵ�����
		
		for (int right = 0; right < str_length; right++) {	// right�����������±�
			if (map.containsKey(str.charAt(right))) {	// charAt() �������ڷ���ָ�����������ַ�
				 // map.get():�����ַ�����Ӧ���������������ظ�Ԫ��ʱ��������ָ������
				left = Math.max(left, map.get(str.charAt(right)) + 1);	// map.get('a')=0,��Ϊmap��ֻ�е�һ��a���±꣬Ȼ�����leftָ�뵽ԭ��left�ĵ���һλ
			}
			map.put(str.charAt(right) , right);		// ����map��aӳ����±�
			max = Math.max(max,right - left + 1);	 // �Ƚ����������Ĵ�С
		}
		return max;
	}
	

	/**
	  *  �ж��ظ��ַ���HasSet
	 * @param str
	 */
	private static int lengthOfLongestSubstring_Set(String str) {
		
		if (str == null) {
			return 0;
		}
		
		int str_length = str.length();
		
		Set<Character> set = new HashSet<>();
		int right = -1;	// ��ָ�룬��ʼֵΪ -1���൱�����ַ�������߽����࣬��û�п�ʼ�ƶ�
		int max = 0;	// ��Ӵ�����
		
		for (int left = 0; left < str_length; left++) {  // ��ָ�������ƶ�һ��
			if (left != 0) {
				set.remove(str.charAt(left - 1));
			}
			while(right + 1 < str_length && !set.contains(str.charAt(right + 1))) {
				set.add(str.charAt(right + 1));
				// ���ϵ��ƶ���ָ��
				right++;
			}
			max = Math.max(max, right - left + 1);
		}
		
		return max;
	}

}
