package com.king.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1、两数之和
  * 	给定一个整数数组 nums 和一个整数目标值 target，
  * 	请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标，
  * 	你可以假设每种输入只会对应一个答案，但是，数组中同一个元素不能使用两遍，
  * 	你可以按任意顺序返回答案
 * @author 19435
 *
 */
public class Two_Sum {
	/**
	 * 示例：
	 * 	输入：nums = [2,7,11,15], target = 9 
	 * 	输出：[0,1] 
	 * 	解释：因为 nums[0] + nums[1] == 9，返回 [0, 1]
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int[] nums = { 2, 7, 11, 15 };
		int target = 17;
		//System.out.println(Arrays.toString(twoNum(nums, target)));
		System.out.println(Arrays.toString(twoNum_Map(nums, target)));

	}

	// 方法一：暴力枚举
	/**
	 * 	当我们使用遍历整个数组的方式寻找 target - x 时， 
	 * 	需要注意到每一个位于 x 之前的元素都已经和 x 匹配过，因此不需要再进行匹配。
	 * 	而每一个元素不能被使用两次，所以我们只需要在 x 后面的元素中寻找 target - x
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoNum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}
	
	// 方法二：哈希表
	/**
	 * 	创建一个哈希表，对于每一个 x，首先查询哈希表中是否存在 target - x，
	 * 	然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
	 * 	使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N)降低到 O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoNum_Map(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target-nums[i])) {
				return new int[] {map.get(target-nums[i]),i};
			}
			map.put(nums[i],i);
		}
		return null;
	}

}
