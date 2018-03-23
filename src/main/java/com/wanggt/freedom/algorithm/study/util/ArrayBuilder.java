package com.wanggt.freedom.algorithm.study.util;

import java.util.Random;

/**
 * 数组生产器
 * @author freedom wang
 * @date 2018年3月22日下午9:33:54
 * @version 1.0
 */
public class ArrayBuilder {

	/**
	 * 生成一个int数组
	 * @param length 数组长度
	 * @param start 数组值范围的开始
	 * @param end 数组值范围的结束，不包括
	 * @return
	 * @author freedom wang
	 * @date 2018年3月22日下午9:40:02
	 * @version 1.0
	 */
	public static int[] getIntArray(int length, int start, int end) {
		if (start >= end) {
			throw new IllegalArgumentException("start must be less then end!");
		}
		int[] intArray = new int[length];

		for (int i = 0; i < length; i++) {
			intArray[i] = start + new Random().nextInt(end - start);
		}

		return intArray;
	}

	/**
	 * 生成一个int数组,值的范围为0-1
	 * @param length 数组长度
	 * @return
	 * @author freedom wang
	 * @date 2018年3月22日下午9:40:02
	 * @version 1.0
	 */
	public static int[] getIntArray(int length) {
		return getIntArray(length, 0, 1);
	}
}
