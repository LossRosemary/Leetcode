package com.king.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 		给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * @author 19435
 *
 */
public class RepeatingCharacters {
	
	/**
	 * 	示例1：
	 * 		输入: s = "abcabcbb"
	 * 		输出: 3 
	 * 		解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
	 * 	示例2：
	 * 		输入: s = "pwwkew"
	 * 		输出: 3 
	 * 		解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
	 * 		请注意：你的答案必须是子串的长度，"pwke" 是一个子序列，不是子串
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
	 * 	思路：「滑动窗口」
	 * 		使用两个指针表示字符串中的某个子串（的左右边界），
	 * 		左指针代表着起始位置，而右指针即为不包含重复字符的最长子串的结束位置
	 * 		不断地向右移动右指针，如果出现重复字符，则左指针向右移动一格，
	 * 		保证这两个指针对应的子串中没有重复的字符，
	 * 		在移动结束后，这个子串就对应着 以左指针开始的，不包含重复字符的最长子串。
	 * 		记录下这个子串的长度
	 * 	判断重复字符：HashMap
	 * @param str
	 */
	private static int lengthOfLongestSubstring(String str) {
		
		if (str == null) {
			return 0;
		}
		
		int str_length = str.length();
		
		Map<Character, Integer> map = new HashMap<>();
		int left = 0;	//滑动窗口左下标
		int max = 0;	//最长子串长度
		
		for (int right = 0; right < str_length; right++) {	// right滑动窗口右下标
			if (map.containsKey(str.charAt(right))) {	// charAt() 方法用于返回指定索引处的字符
				 // map.get():返回字符所对应的索引，当发现重复元素时，窗口左指针右移
				left = Math.max(left, map.get(str.charAt(right)) + 1);	// map.get('a')=0,因为map中只有第一个a的下标，然后更新left指针到原来left的的下一位
			}
			map.put(str.charAt(right) , right);		// 更新map中a映射的下标
			max = Math.max(max,right - left + 1);	 // 比较两个参数的大小
		}
		return max;
	}
	

	/**
	  *  判断重复字符：HasSet
	 * @param str
	 */
	private static int lengthOfLongestSubstring_Set(String str) {
		
		if (str == null) {
			return 0;
		}
		
		int str_length = str.length();
		
		Set<Character> set = new HashSet<>();
		int right = -1;	// 右指针，初始值为 -1，相当于在字符串的左边界的左侧，还没有开始移动
		int max = 0;	// 最长子串长度
		
		for (int left = 0; left < str_length; left++) {  // 左指针向右移动一格
			if (left != 0) {
				set.remove(str.charAt(left - 1));
			}
			while(right + 1 < str_length && !set.contains(str.charAt(right + 1))) {
				set.add(str.charAt(right + 1));
				// 不断地移动右指针
				right++;
			}
			max = Math.max(max, right - left + 1);
		}
		
		return max;
	}

}
