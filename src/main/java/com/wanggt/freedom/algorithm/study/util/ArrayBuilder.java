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
		if (length < 0) {
			throw new IllegalArgumentException("length must be more then 0!");
		}

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

	/**
	 * 此方法返回近乎有序的整形数组
	 * @param length 数组长度
	 * @param confusion 混乱度，数值越大，数组越无序，当值为0时，数组时有序的
	 * @return
	 * @author freedom wang
	 * @date 2018年3月23日下午4:52:39
	 * @version 1.0
	 */
	public static int[] getNearlyOrderlyIntArray(int length, int confusion) {
		if (length < 0) {
			throw new IllegalArgumentException("length must be more then 0!");
		}
		
		int[] intArray = new int[length];

		for (int i = 0; i < length; i++) {
			intArray[i] = i;
		}

		// 设置混乱
		for (int c = 0; c < confusion; c++) {
			Random random = new Random();
			int from = random.nextInt(length);
			int to = random.nextInt(length);

			int temp = intArray[from];
			intArray[to] = intArray[from];
			intArray[from] = temp;
		}

		return intArray;
	}
}
