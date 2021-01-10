package com.king.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1������֮��
  * 	����һ���������� nums ��һ������Ŀ��ֵ target��
  * 	�����ڸ��������ҳ���ΪĿ��ֵ�����������������������ǵ������±꣬
  * 	����Լ���ÿ������ֻ���Ӧһ���𰸣����ǣ�������ͬһ��Ԫ�ز���ʹ�����飬
  * 	����԰�����˳�򷵻ش�
 * @author 19435
 *
 */
public class Two_Sum {
	/**
	 * ʾ����
	 * 	���룺nums = [2,7,11,15], target = 9 
	 * 	�����[0,1] 
	 * 	���ͣ���Ϊ nums[0] + nums[1] == 9������ [0, 1]
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int[] nums = { 2, 7, 11, 15 };
		int target = 17;
		//System.out.println(Arrays.toString(twoNum(nums, target)));
		System.out.println(Arrays.toString(twoNum_Map(nums, target)));

	}

	// ����һ������ö��
	/**
	 * 	������ʹ�ñ�����������ķ�ʽѰ�� target - x ʱ�� 
	 * 	��Ҫע�⵽ÿһ��λ�� x ֮ǰ��Ԫ�ض��Ѿ��� x ƥ�������˲���Ҫ�ٽ���ƥ�䡣
	 * 	��ÿһ��Ԫ�ز��ܱ�ʹ�����Σ���������ֻ��Ҫ�� x �����Ԫ����Ѱ�� target - x
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
	
	// ����������ϣ��
	/**
	 * 	����һ����ϣ������ÿһ�� x�����Ȳ�ѯ��ϣ�����Ƿ���� target - x��
	 * 	Ȼ�� x ���뵽��ϣ���У����ɱ�֤������ x ���Լ�ƥ�䡣
	 * 	ʹ�ù�ϣ�����Խ�Ѱ�� target - x ��ʱ�临�ӶȽ��͵��� O(N)���͵� O(1)
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
