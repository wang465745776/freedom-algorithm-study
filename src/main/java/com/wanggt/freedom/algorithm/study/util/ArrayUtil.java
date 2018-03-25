package com.wanggt.freedom.algorithm.study.util;

/**
 * 数组工具类
 * @author freedom wang
 * @date 2018年3月25日上午10:45:43
 * @version 1.0
 */
public class ArrayUtil {

	/**
	 * 把基本类型int的数组转变成其包装类的数组
	 * @param primaryArray
	 * @return
	 * @author freedom wang
	 * @date 2018年3月25日上午10:54:42
	 * @version 1.0
	 */
	public static Integer[] convert(int[] primaryArray) {
		Integer[] result = new Integer[primaryArray.length];

		for (int i = 0; i < primaryArray.length; i++) {
			result[i] = primaryArray[i];
		}

		return result;
	}

	/**
	 * 把包装类型Integer的数组转变成其基本类int的数组
	 * @param primaryArray
	 * @return
	 * @author freedom wang
	 * @date 2018年3月25日上午10:55:08
	 * @version 1.0
	 */
	public static int[] convert(Integer[] primaryArray) {
		int[] result = new int[primaryArray.length];

		for (int i = 0; i < primaryArray.length; i++) {
			result[i] = primaryArray[i];
		}

		return result;
	}
}
