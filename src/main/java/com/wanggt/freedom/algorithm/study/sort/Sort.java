package com.wanggt.freedom.algorithm.study.sort;

/**
 * 实现此接口的类拥有排序功能
 * @author freedom wang
 * @date 2018年3月23日下午10:25:32
 * @version 1.0
 */
public interface Sort {
	/** 测试时数组的长度 */
	int LENGTH = 1000;

	/**
	 * 此方法通过排序算法对整形数组进行排序
	 * @param primaryArray 待排序的整形数组
	 * @return
	 * @author freedom wang
	 * @date 2018年3月22日下午9:20:35
	 * @version 1.0
	 */
	int[] intSort(int[] primaryArray);

	/**
	 * 测试排序效果
	 * @author freedom wang
	 * @date 2018年3月23日下午10:25:17
	 * @version 1.0
	 */
	void testSort();

	/**
	 * 测试排序效果
	 * @param primaryArray
	 * @author freedom wang
	 * @date 2018年3月23日下午10:27:56
	 * @version 1.0
	 */
	void testSort(int[] primaryArray);
}
