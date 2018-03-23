package com.wanggt.freedom.algorithm.study.util;

/**
 * 排序工具类
 * @author freedom wang
 * @date 2018年3月22日下午11:12:35
 * @version 1.0
 */
public class SortUtil {

	/**
	 * 校验数组是否排序
	 * @param intArray 需要校验的数组
	 * @return
	 * @author freedom wang
	 * @date 2018年3月22日下午11:18:36
	 * @version 1.0
	 */
	public static boolean isSorted(int[] intArray) {
		if (intArray == null) {
			throw new NullPointerException("array can't be null!");
		}

		if (intArray.length <= 1) {
			return true;
		}

		// 获取数组的最后一个值减去第一个值，判断数组的排序趋势
		int asc = intArray[intArray.length - 1] - intArray[0];
		
		//如果asc等于0，那么intArray[i + 1] - intArray[i]的值也必然等于0，如果一旦存在不等于0，必然存在相反的结果
		for (int i = 0; i < intArray.length - 1; i++) {
			if (intArray[i + 1] - intArray[i] >= 0 ^ asc >= 0) {
				return false;
			}
		}

		return true;
	}
	
}
